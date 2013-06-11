package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa de que en
 * tanto y en cuanto se tenga tanto o más dinero en cuenta del que se quiere
 * extraer, la operación se debe efectuar correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	public CuentaSueldo() {
		super.setMonto(new Double("0"));
	}

	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto
	 *            a depositar
	 */
	public void depositar(final Double monto) {
		if (this.getMonto() < 0) {
			throw new CuentaBancariaException("CuentaSueldo No se puede depositar un monto negativo");
		}
			this.setMonto(this.getMonto() + monto);
	}

	/**
	 * No hay reglas adicionales para la extracción 
	 * @param monto
	 *            a extraer
	 */
	public void extraer(final Double monto) {
		if (monto < 0) {
			throw new CuentaBancariaException("CuentaSueldo No se puede extraer un monto negativo");
			}
			Double saldoActual = getSaldo();
			if (saldoActual < monto) {
				System.out.println("CuentaSueldo Extracci�n Fallida " + monto + " -> El saldo es:" + getSaldo());
				throw new CuentaBancariaException("La operacion no puede realizarse, el saldo es insuficiente");
			}
			else {
				saldoActual -= monto;
				this.setMonto(saldoActual);
			}
			System.out.println("CuentaSueldo Extracci�n " + monto + " -> El saldo es:" + getSaldo());	
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.getMonto();
	}

}
