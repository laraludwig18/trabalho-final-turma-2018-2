package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.MunicipioDAO;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Municipio;

@Stateless
public class GerenciarMunicipioService {
	
	@Inject
	private MunicipioDAO municipioDAO;
	
	public List<Municipio> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) 
			return municipioDAO.buscaPorCriterio(criterio);
		else
			return municipioDAO.lista();
	}

}
