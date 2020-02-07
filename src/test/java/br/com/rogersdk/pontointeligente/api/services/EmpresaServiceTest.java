package br.com.rogersdk.pontointeligente.api.services;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogersdk.pontointeligente.api.entities.Empresa;
import br.com.rogersdk.pontointeligente.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	private static final String CNPJ = "51463645000100";

	@MockBean
	private EmpresaRepository repository;

	@Autowired
	private EmpresaService service;

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(repository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(repository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}

	@Test
	public void buscarEmpresaPorCnpjTest() {
		Optional<Empresa> e = service.buscarPorCnpj(CNPJ);

		Assert.assertTrue(e.isPresent());
	}

	@Test
	public void persistirTest() {
		Empresa e = service.persistir(new Empresa());

		Assert.assertNotNull(e);
	}
}
