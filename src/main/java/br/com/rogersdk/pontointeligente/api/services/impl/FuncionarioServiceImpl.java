package br.com.rogersdk.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rogersdk.pontointeligente.api.entities.Funcionario;
import br.com.rogersdk.pontointeligente.api.repositories.FuncionarioRepository;
import br.com.rogersdk.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

	@Autowired
	private FuncionarioRepository repository;

	@Override
	public Funcionario persistir(Funcionario funcionario) {
		LOGGER.info("Persistindo o funcionário: {}", funcionario);
		return repository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		LOGGER.info("Buscando o funcionário pelo CPF {}", cpf);
		return Optional.ofNullable(repository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		LOGGER.info("Buscando o funcionário pelo email {}", email);
		return Optional.ofNullable(repository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorid(Long id) {
		LOGGER.info("Buscando o funcionário pelo ID {}", id);
		return repository.findById(id);
	}

}
