package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaFisicaService;

public class GerenciarPessoaFisica {
	
	private GerenciarPessoaFisicaService gerenciarPessoaFisicaService;
	
	private PessoaFisica pessoaFisica;
	
	private List<PessoaFisica> pessoasFisicas;
		
	public String salva() {
		gerenciarPessoaFisicaService.salvaPessoaFisica(pessoaFisica);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		pessoasFisicas = gerenciarPessoaFisicaService.busca(null);	
    }
	
	public void exclui() {
		gerenciarPessoaFisicaService.exclui(pessoaFisica);
		this.init();
	}
	
	public void edita(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public List<PessoaFisica> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public String limpa() {
		pessoaFisica = new PessoaFisica();
		return "/client/pessoafisica.jsf?facesRedirect=true";
	}

}
