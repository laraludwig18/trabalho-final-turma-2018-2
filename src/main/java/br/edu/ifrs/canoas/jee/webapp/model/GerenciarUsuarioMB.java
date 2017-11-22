package br.edu.ifrs.canoas.jee.webapp.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarAutomovelService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;

@Named
@RequestScoped
public class GerenciarUsuarioMB {

	@Inject
    private GerenciarUsuarioService gerenciarUsuarioService;
	@Inject
    private GerenciarAutomovelService gerenciarAutomovelService;
	
	@Inject
	private Usuario usuario;
	
	private List<Usuario> usuarios;
	private List<Automovel> automoveis;
		
	@PostConstruct
    public void init() {
		usuarios = gerenciarUsuarioService.busca(null);	
		automoveis = gerenciarAutomovelService.busca(null);	
    }
	
	public String limpa() {
		usuario = new Usuario();
		return "/public/usuario.jsf?facesRedirect=true";
	}
	
	public String salva() {
		gerenciarUsuarioService.salva(usuario);
		this.init();
		return limpa();
	}

	public void edita(Usuario usuario) {
		this.usuario = usuario;
	}

	public void exclui() {
		gerenciarUsuarioService.exclui(usuario);
		this.init();
	}
	
	/********************
	 * GETTERS & SETTERS
	 ********************/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
