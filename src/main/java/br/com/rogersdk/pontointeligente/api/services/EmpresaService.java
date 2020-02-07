package br.com.rogersdk.pontointeligente.api.services;

import java.util.Optional;

import br.com.rogersdk.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	/**
	 * Buscar uma empresa pelo CNPJ.
	 * 
	 * @param cnpj
	 * @return
	 */
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	/**
	 * Cadastra uma nova empresa
	 * 
	 * @param empresa
	 * @return
	 */
	Empresa persistir(Empresa empresa);
}
