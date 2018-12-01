package br.edu.ifrs.canoas.jee.webapp.service;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

@Stateless
public class GerenciarReservaService {
	@Inject
	private ReservaDAO reservaDAO;
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	@Inject
	private QuartoDAO quartoDAO;

	public void salvaReserva(Reserva reserva) {
			if (reserva.getId() == null)
				reservaDAO.insere(reserva);
			else 
				reservaDAO.atualiza(reserva);
	}
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> pegaCpfPf(){ 
		return pessoaFisicaDAO.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> pegaCnpjPj(){ 
		return pessoaJuridicaDAO.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<Quarto> pegaQuartos(){
		return quartoDAO.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> busca(String criterio) {
		if(criterio !=null && criterio.length() > 0)
			return reservaDAO.buscaPorCriterio(criterio);
		else
			return reservaDAO.lista();
	}
	
	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}
	
	public Quarto buscaQuarto(Long id) {
		return quartoDAO.busca(id);
	}
	
}
