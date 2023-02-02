package com.logistic.api.logistic.domain.services;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.api.logistic.domain.model.Cliente;
import com.logistic.api.logistic.domain.model.Entrega;
import com.logistic.api.logistic.domain.model.StatusEntrega;
import com.logistic.api.logistic.domain.repositories.EntregaRepository;

import jakarta.transaction.Transactional;

@Service
public class EntregaService {
	
		@Autowired
		private EntregaRepository entregaRepository;
		@Autowired
		private ClienteService clienteService;
		
		@Transactional
		public Entrega solicitar(Entrega entrega){
			Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
			
			entrega.setCliente(cliente);
			entrega.setStatus(StatusEntrega.PENDENTE);
			entrega.setDataPedido(OffsetDateTime.now());
			
			return entregaRepository.save(entrega);
		}
}
