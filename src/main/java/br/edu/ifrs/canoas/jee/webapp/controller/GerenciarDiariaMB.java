package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.ArrayList;
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
	private DiariaAvulsa diariaAvulsa;
	private List<String> tipoClientes;
	private String tipoCliente;
	private List<String> cnpjs;
	private List<String> cpfs;
	private List<String> quartos;
	private List<DiariaAvulsa> diarias;


	@PostConstruct
	public void init() {
		diariaAvulsa = new DiariaAvulsa();
		diarias = new ArrayList<>();
		tipoClientes = Arrays.asList("Pessoa Física", "Pessoa Jurídica");
		cpfs = Arrays.asList("CPF 1", "CPF2");
		cnpjs = Arrays.asList("CNPJ 1", "CNPJ 2");
		quartos = Arrays.asList("Quarto 1", "Quarto 2");
	}
	
	public void salva() {
		System.out.println("Teste: "+tipoCliente);
		gerenciarDiariaService.salvaDiaria(diariaAvulsa);
	}
}
