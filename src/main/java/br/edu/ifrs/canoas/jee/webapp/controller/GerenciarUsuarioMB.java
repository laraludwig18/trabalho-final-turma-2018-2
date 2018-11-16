package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;

import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarUsuarioMB {

	@Inject
    private GerenciarUsuarioService gerenciarUsuarioService;	
	@Inject
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private String pais;
	private List<String> paises;

	private String estado;
	private List<String> estados;
	
	private String municipio;
	private List<String> municipios;
		
	public String salva() {
		gerenciarUsuarioService.salvaUsario(usuario);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		usuarios = gerenciarUsuarioService.busca(null);	
		paises = gerenciarUsuarioService.getPaises();
    }
	
	public void exclui() {
		gerenciarUsuarioService.exclui(usuario);
		this.init();
	}
	
	public void edita(Usuario u) {
		this.usuario = u;
	}

	public String limpa() {
		usuario = new Usuario();
		return "/public/usuario.jsf?facesRedirect=true";
	}
	
	public void alterarPais() {
	    estados = gerenciarUsuarioService.getEstados();
	}
	
	public void alterarEstado() {
		municipios = gerenciarUsuarioService.getMunicipios();
	}
}
