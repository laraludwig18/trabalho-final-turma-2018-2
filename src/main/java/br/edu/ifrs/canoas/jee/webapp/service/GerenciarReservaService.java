package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class GerenciarReservaService {
	@Inject
	private ReservaDAO reservaDAO;
	
	public void salvaReserva(Reserva reserva) {
		if (reserva.getId() == null)
			reservaDAO.insere(reserva);
		else 
			reservaDAO.atualiza(reserva);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> busca(String criterio) {
		if (criterio !=null && criterio.length() > 0) 
			return reservaDAO.buscaPorCriterio(criterio);
		 else 
			return reservaDAO.lista();
		
	}
	
	public List<Pessoa> pegaCpfPf(){
		return null;
	}
	
	public List<Pessoa> pegaCnpjPj(){
		return null;
	}
	
	public List<Quarto> pegaQuartos(){
		return null;
	}
	
	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}
	
	
}
