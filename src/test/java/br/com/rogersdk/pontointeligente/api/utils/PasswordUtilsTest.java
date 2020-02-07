package br.com.rogersdk.pontointeligente.api.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {

	private static final String SENHA = "123456";
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Test
	public void senhaNulaTest() throws Exception {
		Assert.assertNull(PasswordUtils.gerarBCrypt(null));
	}

	@Test
	public void senhaGerarHashSenhaTest() throws Exception {
		Assert.assertTrue(encoder.matches(SENHA, PasswordUtils.gerarBCrypt(SENHA)));
	}

}
