package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.SituacaoQuarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.TipoDeQuarto;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarQuartoService;
import lombok.Data;


@ManagedBean
@RequestScoped
@Data
public class GerenciarQuartoMB {
	
	@Inject
	private GerenciarQuartoService gerenciarQuartoService;
	
	private Quarto quarto;
			
	private List<Quarto> quartos;
	
	//private TipoDeQuarto tipo;
			
	public String salva() {
		gerenciarQuartoService.salvaQuarto(quarto);
		this.init();
		return limpa();
	}
	
	
	@PostConstruct
    public void init() {
		this.limpa();
		quartos = gerenciarQuartoService.busca(null);
    }
	
	public void exclui() {
		gerenciarQuartoService.exclui(quarto);
		this.init();
	}

	public String limpa() {
		quarto = new Quarto();
		return "/adm/quarto.jsf?facesRedirect=true";
	}
	
	public TipoDeQuarto[] getTpQuartos(){
		   return TipoDeQuarto.values();
	}
	
	public SituacaoQuarto[] getSituacoes(){
		   return SituacaoQuarto.values();
	}
	 

}
