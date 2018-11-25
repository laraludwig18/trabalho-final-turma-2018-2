package br.edu.ifrs.canoas.jee.webapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
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
	
	public List<Pessoa> pegaCpfPf(){ //Ver com PF sobre buscarTodos
		return reservaDAO.pegaCpfPf();
		
	}
	
	public List<Pessoa> pegaCnpjPj(){ //Ver com PJ sobre buscarTodos
		return reservaDAO.pegaCnpjPj();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> busca(String criterio) {
		return reservaDAO.lista();		
	}
	
	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}
	
	
}
