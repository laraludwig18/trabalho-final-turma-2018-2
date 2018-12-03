package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaReservada;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarDiariaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarReservaService;
import lombok.Data;

@Named
@ManagedBean
@ViewScoped
@Data
public class GerenciarReservaMB {

	@Inject
    private GerenciarReservaService gerenciarReservaService;
	@Inject
    private GerenciarDiariaService gerenciarDiariaService;
	private DiariaReservada diariaReservada;
	private Reserva reserva;
	@Inject
	private Quarto quarto;
	private Pessoa pessoa;
	private Integer qtdDias;
	private Date dataAtual;
	private String tipoCliente;
	
	private List<DiariaReservada> diariasReservadas;
	private List<Reserva> reservasFiltradas;
	private List<Reserva> reservas;
	private List<String> tipoClientes;
	private List<PessoaFisica> cpfs;
	private List<PessoaJuridica> cnpjs;
	private List<Quarto> quartos;
	
	public void	onChangeTipoCliente() {
		if(tipoCliente.intern() == "Pessoa Física") {
			reserva.setPessoa(new PessoaFisica());
		}else if(tipoCliente.intern() == "Pessoa Jurídica") {
			reserva.setPessoa(new PessoaJuridica());
		}
    }
	
	public String isPFouPJ(Reserva reserva){
		return reserva.getPessoa() instanceof PessoaFisica
		? "Pessoa Física" : "Pessoa Jurídica";
	}
	
	@PostConstruct
    public void init() {
		reserva = new Reserva();
		diariaReservada = new DiariaReservada();
		diariaReservada.setQuarto(new Quarto());
		diariaReservada.setReserva(new Reserva());
		
		reservas = gerenciarReservaService.busca(null);
		diariasReservadas = gerenciarDiariaService.buscaDiariaReservada(null);
		
		tipoClientes = gerenciarReservaService.getTipoCliente();
		cpfs = gerenciarReservaService.pegaCpfPf();
		cnpjs = gerenciarReservaService.pegaCnpjPj();
		quartos = gerenciarReservaService.pegaQuartos();
		
		dataAtual = new Date();
    }

	public String salva() {
		gerenciarReservaService.salvaReserva(reserva);
		diariaReservada.getReserva().setId(reserva.getId());
		diariaReservada.getQuarto().setId(quarto.getId());
		gerenciarDiariaService.salvaDiariaReservada(diariaReservada);
		this.init();
		return limpa();
	}

	public void edita(Reserva r) {
		this.reserva = r;
		this.tipoCliente = isPFouPJ(r);
	}

	public void exclui(Reserva r) {
		gerenciarReservaService.exclui(r);
		this.init();
	}

	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}
}
