package br.edu.ifrs.canoas.jee.webapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Automovel
 *
 */
@Entity
public class Automovel extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -5665692921950546560L;

	@Pattern(regexp ="^[a-zA-Z]{3}\\-\\d{4}$", message="{automovel.placa}")
	@NotEmpty
	private String placa;
	private String marca;
	private String modelo;
	@Pattern(regexp="(^$|[0-9]{4})", message="{automovel.ano}")
	private String ano;		
	private String renavan;
	
	/********************
	 * GETTERS & SETTERS
	 ********************/
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavan() {
		return renavan;
	}
	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}
	
}
