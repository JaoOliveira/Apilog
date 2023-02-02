package com.logistic.api.logistic.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Destinatario {
	
	@NotBlank
	@Column(name = "destinatario_nome")
	private String nome;
	
	@NotBlank
	@Column(name = "destinatario_logadouro")
	private String logadouro;
	
	@NotBlank
	@Column(name = "destinatario_numero")
	private String numero;
	
	@NotBlank
	@Column(name = "destinatario_complemento")
	private String complemento;
	
	@NotBlank
	@Column(name = "destinatario_bairro")
	private String bairro;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
