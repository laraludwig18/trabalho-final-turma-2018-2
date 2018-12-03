package br.edu.ifrs.canoas.jee.webapp.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import org.junit.Test;

public class DiariaReservadaTest {

	@Test
	public void testaDiariaReservadaEmBranco() {
		DiariaReservada diariaReservada = new DiariaReservada();
		assertThat(diariaReservada).isNotNull();
	}

	@Test
	public void testaDadosDiariaReservada() throws ParseException {
		DiariaReservada diariaReservada = new DiariaReservada();
		diariaReservada = criaDiariaReservada();
//		assertThat(diariaReservada.getData()).isEqualTo();
//		assertThat(diariaReservada.setQuarto()).isEqualTo();
//		assertThat(diariaReservada.setReserva()).isEqualTo();
		assertThat(diariaReservada.getQtdDias()).isEqualTo(6);
		assertThat(diariaReservada.getId()).isNull();
	}


	private DiariaReservada criaDiariaReservada()
	{
		DiariaReservada diariaReservada = new DiariaReservada();

//		diariaReservada.setData(data);
//		diariaReservada.setQuarto(quarto);
//		diariaReservada.setReserva(reserva);
		diariaReservada.setQtdDias(6);

		diariaReservada.setId(null);
		return diariaReservada;
	}
}
