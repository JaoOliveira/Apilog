package com.logistic.api.logistic.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.api.logistic.domain.exception.NegocioException;
import com.logistic.api.logistic.domain.model.Cliente;
import com.logistic.api.logistic.domain.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService  {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso= clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExixtente -> !clienteExixtente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe esse email cadastrado");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir (Long clienteId) {
		 clienteRepository.deleteById(clienteId);	
	}
}
