package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarDiariaService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarDiariaMB {
	@Inject
    private GerenciarDiariaService gerenciarDiariaService;
	@Inject
	private DiariaAvulsa diariaAvulsa;
	private List<String> tipoClientes;
	private String tipoCliente;
	private List<String> cnpjs;
	private List<String> cpfs;
	private List<String> quartos;
	private List<DiariaAvulsa> diarias;


	@PostConstruct
	public void init() {
		diarias = gerenciarDiariaService.busca();	
		diariaAvulsa = new DiariaAvulsa();
		tipoClientes = Arrays.asList("Pessoa Física", "Pessoa Jurídica");
		cpfs = Arrays.asList("CPF 1", "CPF2");
		cnpjs = Arrays.asList("CNPJ 1", "CNPJ 2");
		quartos = Arrays.asList("Quarto 1", "Quarto 2");
	}
	
	public String salva() {
		gerenciarDiariaService.salvaDiaria(diariaAvulsa);
		this.init();
		return limpa();
	}
	
	public void edita(DiariaAvulsa diariaAvulsa) {
		this.diariaAvulsa = diariaAvulsa;
	}
	
	public void exclui(DiariaAvulsa diaria) {
		System.out.println("Entra");
		System.out.println(diaria);
		gerenciarDiariaService.exclui(diaria);
		this.init();
	}
	
	public String limpa() {
		diariaAvulsa = new DiariaAvulsa();
		return "/public/diaria.jsf?facesRedirect=true";
	}
}
