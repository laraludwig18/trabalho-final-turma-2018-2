package br.edu.ifrs.canoas.jee.webapp.model.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaReservada;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class ReservaTest {

	Reserva reserva = new Reserva();

	@Test
	public void testaReservaEmBranco() {
		assertThat(reserva).isNotNull();
	}

}
