package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.assertNotNull;

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
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

@RunWith(Arquillian.class)
public class ReservaDAOTest {

	@Inject
	ReservaDAO reservaDAO;

	@Inject
    Logger log;

	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(ReservaDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	@Test
	public void testa_a_persistencia_da_usuario_em_branco () {

//		Reserva reserva = new Reserva();
//		reserva.setData(data);
//		reserva.setValor(200.00D);
//		reserva.setPessoa(1);
//		reservaDAO.insere(reserva);
//		assertNotNull(reserva.getId());
//		log.info(reserva.setPessoa() + " foi persistido com o id " + reserva.getId());

	}

}
