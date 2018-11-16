package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarReservaMB {

	@Inject
    private GerenciarUsuarioService gerenciarUsuarioService;	
	@Inject
	private Reserva reserva;
	private List<String> tipoClientes;
	private String tipoCliente;
	private List<String> cpfs;
	private String cpf;
	private List<String> cnpjs;
	private String cnpj;
	private List<String> quartos;
	private String quarto;
	
	
	
	private List<Reserva> reservas;
		
	public String salva() {
//		gerenciarReservaService.salvaReserva(reserva);
//		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		tipoClientes = Arrays.asList("Pessoa Fisica", "Pessoa Juridica");
		cpfs = Arrays.asList("CPF1", "CPF2");
		cnpjs = Arrays.asList("CNPJ1", "CNPJ2");
		quartos = Arrays.asList("Quarto 1", "Quarto 2");
		//gerenciar reserva services	
		//reservas = gerenciarReservaService.busca(null);	
    }
	
	public void exclui() {
//		gerenciarReservaService.exclui(reserva);
		this.init();
	}
	
	public void edita(Reserva r) {
		this.reserva = r;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva r) {
		this.reserva = r;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setUsuarios(List<Reserva> r) {
		this.reservas = r;
	}
	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}

}
