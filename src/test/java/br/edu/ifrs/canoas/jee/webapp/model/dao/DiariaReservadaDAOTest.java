package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.*;

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

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaReservada;

@RunWith(Arquillian.class)
public class DiariaReservadaDAOTest {

	@Inject
	DiariaReservadaDAO diariaReservadaDAO;

	@Inject
    Logger log;

	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(DiariaReservadaDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	@Test
	public void testa_a_persistencia_do_usuario_em_branco () {
//		DiariaReservada diariaReservada = new DiariaReservada();
//		diariaReservada.setReserva(reserva);
//		diariaReservada.setQtdDias(5);
//		diariaReservada.setQuarto(quarto);
//		diariaReservada.setData(data);
//		diariaReservadaDAO.insere(diariaReservada);
//		assertNotNull(diariaReservada.getId());
//		log.info("DiariaReservada com reserva " + diariaReservada.getReserva().getId() + " foi persistido com o id " + diariaReservada.getId());

	}

}
