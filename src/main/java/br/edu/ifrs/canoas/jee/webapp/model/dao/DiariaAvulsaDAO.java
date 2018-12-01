package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<DiariaAvulsa> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT da "
		         + "FROM DiariaAvulsa da "
		         + "WHERE da.qtdDias= :qtdDias "
		         + " or da.data = :data "
		         + " or da.pessoa.cpf = :cpf "
		         + " or da.pessoa.cnpj = :cnpj "
		         + " or da.quarto.numero = :numero ")
				
		         .setParameter("qtdDias", criterio.trim().toLowerCase())
		         .setParameter("data", criterio.trim().toLowerCase())
		         .setParameter("cpf", criterio.trim().toLowerCase())
		         .setParameter("cnpj", criterio.trim().toLowerCase())
		         .setParameter("numero", criterio.trim().toLowerCase())
		         .getResultList();
	}
}