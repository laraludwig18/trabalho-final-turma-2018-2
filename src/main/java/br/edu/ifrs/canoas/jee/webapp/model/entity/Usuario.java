package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Data
public class Usuario extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull @Email 
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nome;

	@NotNull
	private String sobrenome;
	
	@NotNull
	private String pais;
	
	private String estado;
		
	private String municipio;

	private String logradouro;
	
	public Usuario() {
		super();
	}

}
