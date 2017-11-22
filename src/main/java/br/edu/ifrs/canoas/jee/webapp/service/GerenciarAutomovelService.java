package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.AutomovelDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;


@Stateless
public class GerenciarAutomovelService {

	@Inject
	private AutomovelDAO automovelDAO;
	
	@Inject
	private Logger log;

	public boolean salva(Automovel automovel) {

		if (automovel == null) {
			log.warning("ERRO: Salvando automovel nulo");
			return false;
		}
		
		log.info("Salvando " + automovel.getPlaca());
		
		if (automovel.getId() != null) {
			automovelDAO.atualiza(automovel);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "atualizado.sucesso",automovel.getPlaca());
			return true;
		} else {
			automovelDAO.insere(automovel);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "cadastro.sucesso",automovel.getPlaca());
			log.info("Salvo " + automovel.getPlaca() + " com id " + automovel.getId());
			return true;
		}
		 
	}

	public List<Automovel> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) 
			return automovelDAO.buscaPorCriterio(criterio);
		else
			return automovelDAO.lista();
	}
	
	public void exclui(Automovel automovel) {
		automovelDAO.exclui(automovel.getId());
		Mensagens.define(FacesMessage.SEVERITY_INFO, "excluido.sucesso",automovel.getPlaca());
		log.info("Excluido " + automovel.getPlaca() + " com id " + automovel.getId());
	}


	public Automovel get(Long id) {
		return automovelDAO.busca(id);
	}

}