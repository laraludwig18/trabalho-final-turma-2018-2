package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.assertNotNull;

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

import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;

@RunWith(Arquillian.class)
public class UsuarioDAOTest {

	@Inject
	UsuarioDAO usuarioDAO;
	
	@Inject
	AutomovelDAO automovelDAO;
	@Inject
    Logger log;

	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(UsuarioDAO.class, AutomovelDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Test
	public void testa_a_persistencia_do_usuario_em_branco () {
		Automovel automovel = new Automovel("III-0000");
		automovelDAO.insere(automovel);
		
		Usuario usuario = new Usuario();
		usuario.setEmail("email@email.com");
		usuario.setNome("Rodrigo");
		usuario.setSenha("senha");
		usuario.setSobrenome("Noll");
		usuario.setAutomovel(automovel);
		usuarioDAO.insere(usuario);
		assertNotNull(usuario.getId());
		log.info(usuario.getNome() + " foi persistido com o id " + usuario.getId());
	
	}

}