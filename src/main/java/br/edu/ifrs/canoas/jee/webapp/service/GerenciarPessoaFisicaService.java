package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarPessoaFisicaService {
	
	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	public void salvaPessoaFisica(PessoaFisica pessoaFisica) {

		if (pessoaFisica.getId() == null) {
			pessoaFisicaDAO.insere(pessoaFisica);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Usuario.cadastro.sucesso");
		} else {
			pessoaFisicaDAO.atualiza(pessoaFisica);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Usuario.atualizado.sucesso");
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
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Usuario.excluido.sucesso");
		}
		else
		{
			pessoaFisicaDAO.insere(pessoaFisica);
		}
	}
	
	public void validaId() {
		
	}
	//public void validaDataDeNascimento(PessoaFisica pessoaFisica) {
		/*Date dataNascimento = pessoaFisica.getDataNascimento();
		Date dataHoje = null;

		int idade;

		idade = (int)(dataHoje.getTime() - dataNascimento.getTime());
		if(idade > 18)
		{
			pessoaFisicaDAO.insere(pessoaFisica);
		}
	}*/
//}
}
