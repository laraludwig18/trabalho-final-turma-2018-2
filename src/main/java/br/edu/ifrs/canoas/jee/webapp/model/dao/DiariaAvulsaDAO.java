package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	private static final long serialVersionUID = 1L;

	public List<DiariaAvulsa> buscaPorQuarto(Quarto quarto) {
		TypedQuery<DiariaAvulsa> query = em.createQuery("SELECT da FROM  DiariaAvulsa da where da.quarto = :quarto",DiariaAvulsa.class);
		query.setParameter("quarto", quarto);
		
		return query.getResultList();
	}
	
}