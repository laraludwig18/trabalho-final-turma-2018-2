package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Entity implementation class for Entity: Diaria
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "diaria_tipo")
@Data
public class Diaria  extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Date data;
	
	@ManyToMany()
	protected Collection<PessoaFisica> hospedes;
	
	@ManyToOne
	protected Quarto quarto;
   
	public Diaria() {
		super();
		this.hospedes = new ArrayList<>();
	}
	public Diaria(Date data, Quarto quarto) {
		this.data = data;
		this.hospedes = new ArrayList<>();
		this.quarto = quarto;
	}
	public void addHospedes(PessoaFisica pessoa) {
		this.hospedes.add(pessoa);
	}

}
