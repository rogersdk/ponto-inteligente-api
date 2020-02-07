package br.com.rogersdk.pontointeligente.api.services;

import java.util.Optional;

import br.com.rogersdk.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	/**
	 * Persiste um funcionário
	 * 
	 * @param funcionario
	 * @return
	 */
	Funcionario persistir(Funcionario funcionario);

	/**
	 * Busca e retorna um funcionário pelo cpf
	 * 
	 * @param cpf
	 * @return
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);

	/**
	 * Busca e retorna um funcionário pelo email
	 * 
	 * @param email
	 * @return
	 */
	Optional<Funcionario> buscarPorEmail(String email);

	/**
	 * Busca e retorna um funcionário pelo id
	 * 
	 * @param id
	 * @return
	 */
	Optional<Funcionario> buscarPorid(Long id);
}
