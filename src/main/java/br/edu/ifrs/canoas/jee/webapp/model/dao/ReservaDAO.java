package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.Date;
import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class ReservaDAO extends BaseDAO<Reserva, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Reserva> buscaPorData(Date data) {
		return em.createQuery("SELECT r " + "FROM Reserva r " + "WHERE r.data = :data")
				.setParameter("data", data).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> buscaPorCpf(String cpf) {
		return em.createQuery("SELECT r " + "FROM Reserva r " + " inner join r.Pessoa as p" + "WHERE r.cpf = :cpf")
				.setParameter("cpf", cpf).getResultList();
		
		/*PESSOA_ID
		
		select d.descricao, p.nome, p.preco from Produto p 
		 inner join p.detalhesProduto as d*/
	}
	
//	public List<Reserva> buscaPorCnpj(String cnpj) {
//		return em.createQuery("SELECT r " + "FROM Reserva r " + " inner join r.Pessoa as p" + "WHERE r.cnpj = :cnpj")
//				.setParameter("cnpj", cnpj).getResultList();
//	}
	
//	public List<Reserva> buscaQuartos()
}
