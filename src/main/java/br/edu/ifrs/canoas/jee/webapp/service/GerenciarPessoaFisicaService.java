package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.h2.jdbc.JdbcSQLException;
import org.h2.message.DbException;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarPessoaFisicaService {

	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	@Inject
	private Logger log;

	public boolean salvaPessoaFisica(PessoaFisica pessoaFisica) {

		if (validaDataDeNascimento(pessoaFisica) == false) {
			log.info("Pessoa.idade.erro");
			Mensagens.define(FacesMessage.SEVERITY_ERROR, "Pessoa.idade.erro");
			return false;
		}

		if (pessoaFisica.getId() == null) {
			pessoaFisicaDAO.insere(pessoaFisica);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Pessoa.cadastro.sucesso", pessoaFisica.getNome());
			return true;
		} else {
			pessoaFisicaDAO.atualiza(pessoaFisica);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Pessoa.atualizado.sucesso", pessoaFisica.getNome());
			return true;
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
		if (pessoaFisica.getId() != null) {
			pessoaFisicaDAO.exclui(pessoaFisica.getId());
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Usuario.excluido.sucesso");
		} else {
			pessoaFisicaDAO.insere(pessoaFisica);
		}
	}

	public boolean validaDataDeNascimento(PessoaFisica pessoaFisica) {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(pessoaFisica.getDataNascimento());
		Calendar hoje = Calendar.getInstance();

		int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

		if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
			idade--;
		} else {
			if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
					&& hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				idade--;
			}
		}

		return (idade >= 18 ? true : false);
	}

}
