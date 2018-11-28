package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import br.edu.ifrs.canoas.jee.webapp.controller.GerenciarUsuarioMB;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;

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
	
	@NotNull
	private String estado;
	
	@NotNull
	private String municipio;

	@NotNull
	private String logradouro;
	
	public Usuario() {
		super();
	}

	public String toString() { 
    	return "\n" + "email: '" + this.email + "\n" + "senha: '" + this.senha + "\n" + "nome: '" + this.nome + "\n" + "sobrenome: '" + this.sobrenome + "\n" + "pais: '" + this.pais + "\n" +
    	 "estado: '" + this.estado + "\n" + "municipio: '" + this.municipio + "\n" + "logradouro: '" + this.logradouro + "\n";
	}
}
