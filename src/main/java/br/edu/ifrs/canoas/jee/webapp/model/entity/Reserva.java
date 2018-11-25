package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity
@Data
public class Reserva extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -7506875242774252963L;
	@Temporal(TemporalType.DATE)
	private Date data;
	private Double valor;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public Reserva() {
		super();
	}

	public Reserva(Date data, Double valor) {
		if(validaData(data)) {
			this.data = data;
			this.valor = valor;
		}
		else
			throw new RuntimeException("data nao pode ser menor que a data atual");
	}
	
	private boolean validaData(Date data) {
		Date dataAtual = new Date();
		return data.after(dataAtual);
	}
}
