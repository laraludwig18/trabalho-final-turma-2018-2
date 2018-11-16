package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;

@Stateless
public class PessoaJuridicaDAO extends BaseDAO<PessoaJuridica, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> buscaPorCnpj(String cpf) {
		return em.createQuery("SELECT u " + "FROM PessoaJuridica u " + "WHERE u.cnpj = :cnpj")
				.setParameter("cpf", cpf).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT u "
		         + "FROM PessoaFisica u "
		         + "WHERE u.cnpj = :cnpj "
		         + " or u.razaoSocial = :razaoSocial "
		         + " or u.inscricaoEstadual = :inscricaoEstadual "
		         + " or u.inscricaoMunicipal = :inscricaoMunicipal "
				)				
				 .setParameter("cnpj", criterio.trim().toLowerCase())
		         .setParameter("razaoSocial", criterio.trim().toLowerCase())
		         .setParameter("inscricaoEstadual", criterio.trim().toLowerCase())
		         .setParameter("inscricaoMunicipal", criterio.trim().toLowerCase())
		         .getResultList();
	}
}
