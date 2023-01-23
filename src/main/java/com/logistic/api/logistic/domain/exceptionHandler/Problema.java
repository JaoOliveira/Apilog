package com.logistic.api.logistic.domain.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Problema {
	private Integer Status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo>campos;
	
	public Problema() {}
	
	
	public List<Campo> getCampos() {
		return campos;
	}


	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}


	public Integer getStatus() {
		return Status; 	
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public LocalDateTime getDatahora() {
		return dataHora;
	}
	public void setDatahora(LocalDateTime datahora) {
		this.dataHora = datahora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Status, dataHora, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problema other = (Problema) obj;
		return Objects.equals(Status, other.Status) && Objects.equals(dataHora, other.dataHora)
				&& Objects.equals(titulo, other.titulo);
	}

	public static class Campo{
		
		private String nome;
		private String mensagem;
		
		
		public Campo(String nome, String mensagem) {
			this.nome = nome;
			this.mensagem = mensagem;
		}
		public Campo() {
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
		
		
	}
	

}
