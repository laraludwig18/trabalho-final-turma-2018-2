package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
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
	private Pessoa pessoa;
	private Quarto quarto;
	
	private List<PessoaJuridica> PJ;
	private List<PessoaFisica> PF;
	
	private List<Quarto> quartos;
	private List<DiariaAvulsa> diarias;
	
	public Boolean isPf() {
		return pessoa instanceof PessoaFisica ? true : false;
	}

	@PostConstruct
	public void init() {
		diariaAvulsa = new DiariaAvulsa();
		diariaAvulsa.setPessoa(new PessoaFisica());
		diariaAvulsa.setQuarto(new Quarto());
		
		diarias = gerenciarDiariaService.busca();	
		tipoClientes = gerenciarDiariaService.getTipoCliente();
		
		PF = gerenciarDiariaService.getPF();
		PJ = gerenciarDiariaService.getPJ();
		
		quartos = gerenciarDiariaService.getQuartos();
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
		gerenciarDiariaService.exclui(diaria);
		this.init();
	}
	
	public String limpa() {
		diariaAvulsa = new DiariaAvulsa();
		PF = new ArrayList<>();
		PJ = new ArrayList<>();
		quartos = new ArrayList<>();
		return "/public/diaria?facesRedirect=true";
	}
}
