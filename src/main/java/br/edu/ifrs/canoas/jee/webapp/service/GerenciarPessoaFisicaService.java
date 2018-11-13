package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;

@Stateless
public class GerenciarPessoaFisicaService {
	
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	public void salvaPessoaFisica(PessoaFisica pessoaFisica) {
		// TODO Auto-generated method stub
		
	}

	public List<PessoaFisica> busca(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void exclui(PessoaFisica pessoaFisica) {
		// TODO Auto-generated method stub
		
	}


}
