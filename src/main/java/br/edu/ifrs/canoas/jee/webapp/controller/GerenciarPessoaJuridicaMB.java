package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.xml.bind.ValidationException;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaJuridicaService;
import lombok.Data;
@Data
@ManagedBean
@RequestScoped
public class GerenciarPessoaJuridicaMB {
	
	@Inject
	private GerenciarPessoaJuridicaService gerenciarPessoaJuridicaService;
	
	private PessoaJuridica pessoaJuridica;

	private List<PessoaJuridica> pessoasJuridicas;
	

	public String salva() throws ValidationException {
		gerenciarPessoaJuridicaService.salvaPessoaJuridica(pessoaJuridica);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		pessoasJuridicas = gerenciarPessoaJuridicaService.busca(null);	
    }
	
	public void exclui() {
		gerenciarPessoaJuridicaService.exclui(pessoaJuridica);
		this.init();
	}
	
	public void edita(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}


	public String limpa() {
		pessoaJuridica = new PessoaJuridica();
		return "/client/pessoajuridica.jsf?facesRedirect=true";
	}

}
