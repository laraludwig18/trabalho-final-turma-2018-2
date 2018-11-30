package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPaisService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarEstadoService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarMunicipioService;

import lombok.Data;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.component.UIOutput;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Pais;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Estado;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Municipio;

@Data
@ManagedBean
@RequestScoped
public class GerenciarUsuarioMB {

	@Inject
    private GerenciarUsuarioService gerenciarUsuarioService;
	
	@Inject
    private GerenciarPaisService gerenciarPaisService;
	@Inject
    private GerenciarEstadoService gerenciarEstadoService;
	@Inject
    private GerenciarMunicipioService gerenciarMunicipioService;
	
	@Inject
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private List<Pais> paises;
	private List<Estado> estados;
	private List<Municipio> municipios;
		
	public String salva() {
		gerenciarUsuarioService.salvaUsuario(usuario);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		usuarios = gerenciarUsuarioService.busca(null);
		
		paises = gerenciarPaisService.busca(null);
		estados = gerenciarEstadoService.busca(null);
		municipios = gerenciarMunicipioService.busca(null);

//		paises = gerenciarUsuarioService.getPaises();
//		estados = gerenciarUsuarioService.getEstados();			// : need work
//		municipios = gerenciarUsuarioService.getMunicipios();

		//	:	for testing
//		usuario.builder()
//			.name("Lukas")
//			.sobrenome("Kenes")
//			.email("lukaskenes@live.com")
//			.senha("lUk4s123")
//			.logradouro("lɐᴉpunɯ ɯǝʇ oɐu oᴉɯǝɹƃ")
//			.build();

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
	
	public void alterarPais(AjaxBehaviorEvent ev) {
		String pais = (String)((UIOutput)ev.getSource()).getValue();
		System.out.println("pais: " + pais);

		if(pais.equals("Brasil")) {
//			estados = gerenciarUsuarioService.getEstados();
		}
	}
	
	public void alterarEstado(AjaxBehaviorEvent ev) {
		String estado = (String)((UIOutput)ev.getSource()).getValue();
		System.out.println("estado: " + estado);

		if(estado.equals("RS - Rio Grande do Sul")) {
//			municipios = gerenciarUsuarioService.getMunicipios();
		}
	}
}
