package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
public class PessoaFisicaDAO extends BaseDAO<PessoaFisica, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 //CONSULTAS ESPECIFICAS
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscaPorCpf(String cpf) {
		return em.createQuery("SELECT u " + "FROM PessoaFisica u " + "WHERE u.cpf = :cpf")
				.setParameter("cpf", cpf).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscaPorRg(String rg) {
		return em.createQuery("SELECT u " + "FROM PessoaFisica u " + "WHERE u.rg = :rg")
				.setParameter("rg", rg).getResultList();
	}
	
}
