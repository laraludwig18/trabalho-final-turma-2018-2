package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarPessoaFisicaService {
	
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	public void salvaPessoaFisica(PessoaFisica pessoaFisica) {
		// TODO Auto-generated method stub
		if (pessoaFisica.getId() == null) {
			pessoaFisicaDAO.insere(pessoaFisica);
		} else {
			pessoaFisicaDAO.atualiza(pessoaFisica);
		}
	}

	public List<PessoaFisica> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) {
			return pessoaFisicaDAO.buscaPorCriterio(criterio);
		} else {
			return pessoaFisicaDAO.lista();
		}
	}

	public List<PessoaFisica> busca(Object object) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void exclui(PessoaFisica pessoaFisica) {
		pessoaFisicaDAO.exclui(pessoaFisica.getId());
	}
}
