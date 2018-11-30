package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.EstadoDAO;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Estado;

@Stateless
public class GerenciarEstadoService {
	
	@Inject
	private EstadoDAO estadoDAO;
	
	public List<Estado> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) 
			return estadoDAO.buscaPorCriterio(criterio);
		else
			return estadoDAO.lista();
	}

}
