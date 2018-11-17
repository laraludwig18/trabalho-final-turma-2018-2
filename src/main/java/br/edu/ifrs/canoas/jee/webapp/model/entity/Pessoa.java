package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


import lombok.Data;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Data
public abstract class Pessoa extends BaseEntity<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp="@\"^((\\b[a-zA-Z]{2,40}\\b)\\s*){2,}$\"", message="Invalid Name!")
	@Size(max = 100)
	private String nome;
	@Email
	private String email;
	@Pattern(regexp="^[1-9]{2}\\-[2-9][0-9]{9,9}$") //FORMATO ACEITO POR ENQUANTO: 99-99999999 /99-999999999
	private String telefone;
	private Endereco endereco;
	
	public Pessoa() {
		super();
	}
	public Pessoa(String nome, String email, String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
}
