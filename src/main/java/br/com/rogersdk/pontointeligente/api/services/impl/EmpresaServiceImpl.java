package br.com.rogersdk.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rogersdk.pontointeligente.api.entities.Empresa;
import br.com.rogersdk.pontointeligente.api.repositories.EmpresaRepository;
import br.com.rogersdk.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository repository;

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		LOGGER.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(repository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		LOGGER.info("Buscando uma empresa para o CNPJ {}", empresa);
		return repository.save(empresa);
	}

}
