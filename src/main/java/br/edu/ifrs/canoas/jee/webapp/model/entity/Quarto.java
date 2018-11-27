package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

/**
 * Entity implementation class for Entity: Quarto
 *
 */
@Entity
@Data
public class Quarto extends BaseEntity<Long> implements Serializable {

	
	private static final long serialVersionUID = 57657643543453426L;
	//@Min(3)
	//@Max(20)
	private String numero;
	@Enumerated(EnumType.STRING)
	private TipoDeQuarto tipo;
	@Enumerated(EnumType.STRING)
	private SituacaoQuarto situacao;
	@Max(400)
	private String descricao;
	
	public Quarto() {
		super();
	}
   
}
