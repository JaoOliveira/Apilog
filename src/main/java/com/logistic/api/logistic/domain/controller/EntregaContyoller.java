package com.logistic.api.logistic.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.api.logistic.domain.model.Entrega;
import com.logistic.api.logistic.domain.repositories.EntregaRepository;
import com.logistic.api.logistic.domain.services.EntregaService;
import com.logistic.api.logistic.model.EntregaModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entregas")
public class EntregaContyoller {
		
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega){
		
		return entregaService.solicitar(entrega);
		}
	
	@GetMapping
	public List<Entrega> listar(){
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega-> {
					EntregaModel entregaModel = new EntregaModel();
					entregaModel.setId(entrega.getId());
					entregaModel.setNomeCliente(entrega.getCliente().getNome());
					entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
					entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogadouro());
					entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
					entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					entregaModel.setTaxa(entrega.getTaxa());
					entregaModel.setStatus(entrega.getStatus());
					entregaModel.setDataPedido(entrega.getDataPedido());
					entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
					
					return ResponseEntity.ok(entregaModel);
					}).orElse(ResponseEntity.notFound().build());
	}
}
