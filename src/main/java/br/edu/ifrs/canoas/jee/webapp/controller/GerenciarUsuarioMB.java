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
	
	private List<String> paises;
	private List<String> estados;
	private List<String> municipios;
		
	public String salva() {
		gerenciarUsuarioService.salvaUsuario(usuario);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		usuarios = gerenciarUsuarioService.busca(null);	
		paises = gerenciarUsuarioService.getPaises();

		estados = gerenciarUsuarioService.getEstados();
		municipios = gerenciarUsuarioService.getMunicipios();

		//	:	for testing
		usuario.setNome("Lukas");
		usuario.setSobrenome("Kenes");
		usuario.setEmail("lukaskenes@live.com");
		usuario.setSenha("lUk4s123");
		usuario.setLogradouro("lɐᴉpunɯ ɯǝʇ oɐu oᴉɯǝɹƃ");
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
		return "/Administracao/Usuario.jsf?facesRedirect=true";
	}
	
	public void alterarPais() {
	    // estados = gerenciarUsuarioService.getEstados();
	}
	
	public void alterarEstado() {
		// municipios = gerenciarUsuarioService.getMunicipios();
	}
}
