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

import br.com.rogersdk.pontointeligente.api.entities.Funcionario;
import br.com.rogersdk.pontointeligente.api.repositories.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository repository;

	@Autowired
	private FuncionarioService service;

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(repository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Funcionario()));
		BDDMockito.given(repository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(repository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
	}

	@Test
	public void persistirTest() {
		Assert.assertNotNull(service.persistir(new Funcionario()));
	}

	@Test
	public void buscarPorIdTest() {
		Optional<Funcionario> f = service.buscarPorid(1l);
		Assert.assertTrue(f.isPresent());
	}

	@Test
	public void buscarPorCpfTest() {
		Optional<Funcionario> f = service.buscarPorCpf("");
		Assert.assertTrue(f.isPresent());
	}

	@Test
	public void buscarPorEmailTest() {
		Optional<Funcionario> f = service.buscarPorEmail("");
		Assert.assertTrue(f.isPresent());
	}

}
