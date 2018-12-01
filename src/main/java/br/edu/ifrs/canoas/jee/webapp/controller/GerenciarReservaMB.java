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
	@Inject
	private Reserva reserva;
	@Inject
	private DiariaReservada diariaReservada;
	@Inject
	private Quarto quarto;
	
	private List<DiariaReservada> diariasReservadas;
	private List<Reserva> reservas;
	private List<String> tipoClientes;
	private String tipoCliente;
	private List<PessoaFisica> cpfs;
	private List<PessoaJuridica> cnpjs;
	private List<Quarto> quartos;
	private Long quartoId;
	private Long pessoaId;
	private Integer qtdDias;
	private Date dataAtual;

	@PostConstruct
    public void init() {
		
		reserva.setPessoa(new PessoaFisica());
		
		reservas = gerenciarReservaService.busca(null);
		diariasReservadas = gerenciarDiariaService.buscaDiariaReservada(null);
		
		tipoClientes = Arrays.asList("Pessoa Fisica", "Pessoa Juridica");
		cpfs = gerenciarReservaService.pegaCpfPf();
		cnpjs = gerenciarReservaService.pegaCnpjPj();
		quartos = gerenciarReservaService.pegaQuartos();
		
		dataAtual = new Date();
    }

	public String salva() {
		gerenciarReservaService.salvaReserva(reserva);
		quarto = gerenciarReservaService.buscaQuarto(quartoId);
		diariaReservada = criaDiariaReservada(reserva, qtdDias, quarto);
		gerenciarDiariaService.salvaDiariaReservada(diariaReservada);
		this.init();
		return limpa();
	}

	public void edita(Reserva r) {
		this.reserva = r;
	}

	public void exclui(Reserva r) {
		gerenciarReservaService.exclui(r);
		this.init();
	}

	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}


	public DiariaReservada criaDiariaReservada(Reserva reserva, Integer qtdDias, Quarto quarto) {
		diariaReservada.setData(reserva.getData());
		diariaReservada.setQtdDias(qtdDias);
		diariaReservada.setQuarto(quarto);
		diariaReservada.setReserva(reserva);
		
		return diariaReservada;
	}


}
