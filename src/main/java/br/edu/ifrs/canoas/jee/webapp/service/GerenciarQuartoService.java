package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarQuartoService {
	
	@Inject
	private QuartoDAO quartoDAO;

	public void salvaQuarto(Quarto quarto) {
		// TODO Auto-generated method stub
		if (quarto.getId() == null) {
			quartoDAO.insere(quarto);
		} else {
			quartoDAO.atualiza(quarto);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Quarto> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) {
			return quartoDAO.buscaPorCriterio(criterio);
		} else {
			return quartoDAO.lista();
		}
	}


	public void exclui(Quarto quarto) {
		quartoDAO.exclui(quarto.getId());
	}
}
