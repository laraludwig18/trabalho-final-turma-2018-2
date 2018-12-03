package br.edu.ifrs.canoas.jee.webapp.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.UsuarioDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

public class GerenciarReservaServiceTest {

	@Inject
	GerenciarReservaService gerenciarReservaService;

	@Inject
    Logger log;

	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(GerenciarReservaService.class, ReservaDAO.class, org.apache.commons.lang3.StringUtils.class, Mensagens.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File("src/main/webapp", "WEB-INF/faces-config.xml"))
                .addAsResource(new File("src/main/resources/ValidationMessages.properties"), "ValidationMessages.properties")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                ;
    }

	public void salva() {

	}

}
