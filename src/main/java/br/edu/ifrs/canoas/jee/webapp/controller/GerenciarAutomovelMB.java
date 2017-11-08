package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.Automovel;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarAutomovelService;

@Named
@RequestScoped
public class GerenciarAutomovelMB {

	@Inject
    private GerenciarAutomovelService gerenciarAutomovelService;	
	
	@Inject
	private Automovel automovel;
	
	private List<Automovel> automoveis;
			
	@PostConstruct
    public void init() {
		automoveis = gerenciarAutomovelService.busca(null);	
    }
	
	public String limpa() {
		automovel = new Automovel();
		return "/public/automovel.jsf?facesRedirect=true";
	}

	public String salva() {
		gerenciarAutomovelService.salva(automovel);
		this.init();
		return limpa();
	}

	public void exclui() {
		gerenciarAutomovelService.exclui(automovel);
		this.init();
	}
	
	/********************
	 * GETTERS & SETTERS
	 ********************/

	public void edita(Automovel automovel) {
		this.automovel = automovel;
	}
	
	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

}
