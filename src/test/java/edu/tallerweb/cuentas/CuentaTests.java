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
		public void queVerifiqueLaConsignaCajaAhorros() {
		CajaAhorros cuenta_a = new CajaAhorros();
		cuenta_a.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta_a.getSaldo(), 0.0);

		int i;
		for (i = 0; i < 5; i++) {
			cuenta_a.extraer(100.0);

			Assert.assertEquals("Se obtiene:", 4000.0 - 100 * (i + 1),
					cuenta_a.getSaldo(), 0.0);
		}
		cuenta_a.extraer(100.0);
		Assert.assertEquals("Se obtiene:", 4000.0 - 100 * (i + 1) - 6,
				cuenta_a.getSaldo(), 0.0);

		}
		
		public void queVerifiqueLaConsignaCuentaCorriente() {
		CuentaCorriente cuenta_c = new CuentaCorriente(new Double (600));
		cuenta_c.depositar(100.0);

		Assert.assertEquals(
				"al depositar $ 100.0 en una cuenta vacía, tiene $ 100.0",
				100.0, cuenta_c.getSaldo(), 0.0);

		cuenta_c.InicializarDescubiertoTotal(20.0);
		cuenta_c.extraer(110.0);

		Assert.assertEquals("Al extraer 110 tiene 0 de descubierto", -15.0,
				cuenta_c.getSaldo(), -15.0);

	}

	@Test(expected=CuentaBancariaException.class)
	public void queVerifiqueLaConsignaException() {
		CuentaSueldo cuenta = new CuentaSueldo();
		CajaAhorros cuenta_a = new CajaAhorros();

		
		cuenta.depositar(3500.0);
		cuenta.extraer(4000.0);
		
		cuenta_a.depositar(35.0);
		cuenta_a.extraer(100.0);

	}

}
