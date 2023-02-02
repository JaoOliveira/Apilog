package com.logistic.api.logistic.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.logistic.api.logistic.domain.VAlidationGroups;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

@Entity
public class Entrega {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = VAlidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@Valid
	@NotNull
	@Embedded
	private Destinatario destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	@JsonProperty(access= Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	@JsonProperty(access= Access.READ_ONLY)
	private OffsetDateTime dataPedido;
	
	@JsonProperty(access= Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
	
	
	
	public Entrega(Long id, Cliente cliente, Destinatario destinatario, StatusEntrega status, OffsetDateTime dataPedido,
			OffsetDateTime dataFinalizacao, BigDecimal taxa) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Destinatario getDestinatario() {
		return destinatario;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}
	public StatusEntrega getStatus() {
		return status;
	}
	public void setStatus(StatusEntrega status) {
		this.status = status;
	}
	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataFinalizacao, dataPedido, destinatario, id, status, taxa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataFinalizacao, other.dataFinalizacao)
				&& Objects.equals(dataPedido, other.dataPedido) && Objects.equals(destinatario, other.destinatario)
				&& Objects.equals(id, other.id) && status == other.status && Objects.equals(taxa, other.taxa);
	}

	
}
	
	
	
	
