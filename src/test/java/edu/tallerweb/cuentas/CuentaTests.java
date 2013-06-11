package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueLaConsigna() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacÃ­a, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaException() {
		CuentaSueldo cuenta = new CuentaSueldo();

		cuenta.depositar(3500.0);
		cuenta.extraer(4000.0);

	}

	@Test
	public void queVerifiqueLaConsignaCajaAhorros() {

		CajaAhorros cuenta_a = new CajaAhorros();
		cuenta_a.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta_a.getSaldo(), 0.0);

		cuenta_a.extraer(500.0);
		cuenta_a.extraer(100.0);
		cuenta_a.extraer(100.0);
		cuenta_a.extraer(100.0);
		cuenta_a.extraer(100.0);
		cuenta_a.extraer(100.0);
		cuenta_a.extraer(100.0);

		Assert.assertEquals(
				"al extraer despues de la quinta extraccion el saldo debe ser",
				2888.0, cuenta_a.getSaldo(), 0.0);

	}

	@Test
	public void queVerifiqueLaConsignaCuentaCorriente() {
		CuentaCorriente cuentacc = new CuentaCorriente(new Double (600));
		cuentacc.depositar(4000.0);

		cuentacc.extraer(500.0);
		cuentacc.extraer(4000.0);
		cuentacc.depositar(100.0);
		cuentacc.depositar(500.0);
		
		
	}
}
