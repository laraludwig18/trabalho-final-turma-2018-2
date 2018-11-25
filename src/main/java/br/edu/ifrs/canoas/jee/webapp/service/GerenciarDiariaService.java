package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.DiariaAvulsaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;

@Stateless
public class GerenciarDiariaService {
	@Inject
	private DiariaAvulsaDAO diariaAvulsaDAO;
	
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	
	@Inject
	private QuartoDAO quartoDAO;
	
	
	public void salvaDiaria(DiariaAvulsa diariaAvulsa) {
		if (diariaAvulsa.getId() == null) {
			diariaAvulsaDAO.insere(diariaAvulsa);
		}else {
			diariaAvulsaDAO.atualiza(diariaAvulsa);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DiariaAvulsa> busca() {
		return diariaAvulsaDAO.lista();
	}
	
	public void exclui(DiariaAvulsa diariaAvulsa) {
		diariaAvulsaDAO.exclui(diariaAvulsa.getId());
	}
	
	public List<String> getTipoCliente() {
		List<String> list = new ArrayList<String>();
		list.add("Pessoa Física");
		list.add("Pessoa Jurídica");
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> getPF(){ 
		return pessoaFisicaDAO.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> getPJ(){ 
		return pessoaJuridicaDAO.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<Quarto> getQuartos(){ 
		return quartoDAO.lista();
	}

}
