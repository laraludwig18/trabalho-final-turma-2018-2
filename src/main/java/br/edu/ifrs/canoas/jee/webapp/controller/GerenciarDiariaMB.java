package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarDiariaMB {
	
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
		tipoClientes = Arrays.asList("Pessoa Fisisca", "Pessoa Juridica");
		cpfs = Arrays.asList("CPF 1", "CPF2");
		cnpjs= Arrays.asList("CNPJ 1", "CNPJ 2");
		quartos = Arrays.asList("Quarto 1", "Quarto 2");
	}
	
	public void salvar() {
		System.out.println("Tipo de cliente: " + tipoCliente);
	}
	
	

	
	
}
