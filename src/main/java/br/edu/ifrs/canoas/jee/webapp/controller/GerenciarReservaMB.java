package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private List<String> cpfs;
	private String cpf;
	private List<String> cnpjs;
	private String cnpj;
	private List<String> quartos;
	private String quarto;
	
	@PostConstruct
    public void init() {
		reservas = gerenciarReservaService.busca(null);	
		tipoClientes = Arrays.asList("Pessoa Fisica", "Pessoa Juridica");
		cpfs = Arrays.asList("CPF1", "CPF2");
		cnpjs = Arrays.asList("CNPJ1", "CNPJ2");
		quartos = Arrays.asList("Quarto 1", "Quarto 2");
    }
	
	public String salva() {
		gerenciarReservaService.salvaReserva(reserva);
		this.init();
		return limpa();
	}
	
	public void edita(Reserva r) {
		this.reserva = r;
	}
	
	public void exclui() {
		gerenciarReservaService.exclui(reserva);
		this.init();
	}
	
	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}
	
//	public Reserva getReserva() {
//		return reserva;
//	}
//
//	public List<Reserva> getReservas() {
//		return reservas;
//	}
//	
//	public void setReserva(Reserva r) {
//		this.reserva = r;
//	}
//
//	public void setReservas(List<Reserva> r) {
//		this.reservas = r;
//	}
	
}
