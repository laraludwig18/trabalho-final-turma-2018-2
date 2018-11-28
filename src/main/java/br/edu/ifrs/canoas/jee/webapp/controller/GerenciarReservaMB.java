package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarReservaService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarReservaMB {

	@Inject
    private GerenciarReservaService gerenciarReservaService;	
	@Inject
	private Reserva reserva;
	private List<Reserva> reservas;
	private List<String> tipoClientes;
	private String tipoCliente;
	private List<PessoaFisica> cpfs;
	private List<PessoaJuridica> cnpjs;
	private List<Quarto> quartos;
	private Integer idPf;
	private Integer idPj;
	private Integer quartoId;
	private Integer qtdDias;
	private Date dataAtual;
	
	@PostConstruct
    public void init() {
		reservas = gerenciarReservaService.busca(null);	
		tipoClientes = Arrays.asList("Pessoa Fisica", "Pessoa Juridica");
		cpfs = gerenciarReservaService.pegaCpfPf();
		cnpjs = gerenciarReservaService.pegaCnpjPj();
		quartos = gerenciarReservaService.pegaQuartos();
		dataAtual = new Date();
    }
	
	public String salva() {
		gerenciarReservaService.salvaReserva(reserva);
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
	
	
}
