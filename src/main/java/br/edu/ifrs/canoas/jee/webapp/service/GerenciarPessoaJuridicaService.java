package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.ValidationException;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;

@Stateless
public class GerenciarPessoaJuridicaService {
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	public void salvaPessoaJuridica(PessoaJuridica pessoaJuridica) throws ValidationException {
		// TODO Auto-generated method stub
		if (pessoaJuridica.getId() == null) {
//			if (pessoaJuridicaDAO.buscaPorCnpj(pessoaJuridica.getCnpj()).size()>0) {
//				throw new ValidationException("CNPJ ja cadastrado");
//			}
			pessoaJuridicaDAO.insere(pessoaJuridica);
		} else {
			pessoaJuridicaDAO.atualiza(pessoaJuridica);
		}
	}

	public List<PessoaJuridica> busca(String criterio) {
		if (criterio != null && criterio.length() > 0) {
			return pessoaJuridicaDAO.buscaPorCriterio(criterio);
		} else {
			return pessoaJuridicaDAO.lista();
		}
	}

	public List<PessoaJuridica> busca(Object object) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void exclui(PessoaJuridica pessoaJuridica) {
		pessoaJuridicaDAO.exclui(pessoaJuridica.getId());
	}
}
