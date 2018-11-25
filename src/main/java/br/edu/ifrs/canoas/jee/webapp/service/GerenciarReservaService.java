package br.edu.ifrs.canoas.jee.webapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class GerenciarReservaService {
	@Inject
	private ReservaDAO reservaDAO;
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	public void salvaReserva(Reserva reserva) {
//		if (validaDataReserva(data) && validaQuantidadeDias(qtdeDias) && valida)
//			if (reserva.getId() == null)
//				reservaDAO.insere(reserva);
//			else 
//				reservaDAO.atualiza(reserva);
	}
	
//	public List<PessoaFisica> buscaPF(){ //Ver com PF sobre buscarTodos
//		pessoaFisicaDAO.busca(null);
//	}
	
//	public List<PessoaJuridica> buscaPj(){ //Ver com PJ sobre buscarTodos
//		pessoaJuridicaDAO.busca();
//	}
	
	public boolean validaQuantidadeDias(int dias) {
		//Inteiro positivo
		if (dias < 1) {
			return false;
		}
		else return true;
	}
	
	public boolean validaDataReserva(Date data) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date dataAtual = new Date();
		//Data maior que a atual
		if (data.after(dataAtual) || data.equals(dataAtual)) {
			return true;
		}
	    else return false;
	}
	
	public boolean validaValor(Double valor) {
		//Inteiro positivo
		if (valor > 0) {
			return true;
		}
		else return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> busca(String criterio) {
		return reservaDAO.lista();		
	}
	
	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}
	
	
}
