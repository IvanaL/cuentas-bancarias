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
	 * 
	 * @param monto
	 *            a depositar
	 */
	public void depositar(final Double monto) {
		if (this.getMonto() >= 0)
			this.setMonto(this.getMonto() + monto);
		else{
			throw new CuentaBancariaException(
					"El monto debe ser un numero positivo");
		}
	}

	/**
	 * No hay reglas adicionales para la extracción
	 * 
	 * @param monto
	 *            a extraer
	 */
	public void extraer(final Double monto) {
		if (this.getMonto() > monto) {
			this.setMonto(this.getMonto() - monto);
		} 
		else{
			throw new CuentaBancariaException(
					"El monto debe ser menor al que usted tiene depositado");
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * 
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.getMonto();
	}

}
