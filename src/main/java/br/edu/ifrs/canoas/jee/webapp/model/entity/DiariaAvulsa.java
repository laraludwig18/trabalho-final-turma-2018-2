package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DiariaAvulsa extends Diaria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Pessoa pessoa;
 
	public DiariaAvulsa() {
		super();
	}
	public DiariaAvulsa(Date data, Pessoa pessoa) {
		this.data = data;
		this.pessoa = pessoa;
	}
	public DiariaAvulsa(Date data) {
		this.data = data;
	}
	
   
}
