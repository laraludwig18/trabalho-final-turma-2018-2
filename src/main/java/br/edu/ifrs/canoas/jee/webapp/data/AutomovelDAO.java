package br.edu.ifrs.canoas.jee.webapp.data;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.Automovel;

@Stateless
public class AutomovelDAO extends BaseDAO<Automovel, Long> {

	private static final long serialVersionUID = -667922945358113440L;

	@SuppressWarnings("unchecked")
	public List<Automovel> buscaPorCriterio(String criterio) {
		return em.createQuery(
		         "SELECT a "
		         + "FROM Automovel a"
		         + "WHERE lower(a.placa) = :placa "
		         + " or lower (a.marca) = :marca "
		         + " or lower (a.modelo) =  :modelo ")
		         .setParameter("placa", criterio.trim().toLowerCase())
		         .setParameter("marca", criterio.trim().toLowerCase())
		         .setParameter("modelo", criterio.trim().toLowerCase())
		         .getResultList();
	}

}