package br.com.rogersdk.pontointeligente.api.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogersdk.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	private static final String CNPJ = "51463645000100";

	@Autowired
	private EmpresaRepository repository;
	
	@Before
	public void setUp() {
		Empresa e = new Empresa();
		e.setRazaoSocial("Razao Social");
		e.setCnpj(CNPJ);
		this.repository.save(e);
	}
	
	@Test
	public void buscarPorCnpjTest() {
		Empresa e = this.repository.findByCnpj(CNPJ);
		
		Assert.assertEquals(CNPJ, e.getCnpj());
	}
	
}
