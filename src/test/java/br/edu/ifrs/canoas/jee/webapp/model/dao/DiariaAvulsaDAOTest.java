package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;

@RunWith(Arquillian.class)
public class DiariaAvulsaDAOTest {
	
	@Inject
	DiariaAvulsaDAO diariaAvulsaDAO;
	
	@Inject
	DiariaAvulsa diaria;
	
	@Inject
    Logger log;
	
	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(DiariaAvulsaDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Test
	public void testaBuscaPorQtdDias() {
		diaria = new DiariaAvulsa();
		PessoaFisica pessoa = new PessoaFisica();
		Quarto quarto = new Quarto();
		diaria.setData(new Date(18/12/2018));
		diaria.setId(600L);
		diaria.setPessoa(pessoa);
		diaria.setQtdDias(3);
		diaria.setQuarto(quarto);
		
		diariaAvulsaDAO.insere(diaria);
		//assertNotNull(diariaAvulsaDAO.buscaPorCriterio(String.valueOf(diaria.getQtdDias())).get(0));
	}
	
}
