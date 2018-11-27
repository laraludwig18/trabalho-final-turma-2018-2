package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	private static final long serialVersionUID = 1L;
	
	public List<DiariaAvulsa> busca() {
		return em.createQuery("SELECT da FROM DiariaAvulsa da ", DiariaAvulsa.class).getResultList();
	}
}