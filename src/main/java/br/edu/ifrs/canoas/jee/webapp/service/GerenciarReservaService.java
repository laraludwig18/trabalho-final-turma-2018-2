package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class GerenciarReservaService {
	@Inject
	private ReservaDAO reservaDAO;
	
	public void salvaReserva(Reserva reserva) {
		
		if (reserva.getId() == null) {
			reservaDAO.insere(reserva);
		} else {
			reservaDAO.atualiza(reserva);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> busca(String parm) {
//		if () {
//			return reservaDAO.buscaPorX(parm);
		return null;
//		} else {
//			return reservaDAO.lista();
//		}
	}
	
	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}
}
