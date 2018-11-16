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

	public void exclui(PessoaFisica pessoaFisica) {
		if(pessoaFisica.getId() != null)
		{
			pessoaFisicaDAO.exclui(pessoaFisica.getId());
		}
		else
		{
			pessoaFisicaDAO.insere(pessoaFisica);
		}
	}
}
