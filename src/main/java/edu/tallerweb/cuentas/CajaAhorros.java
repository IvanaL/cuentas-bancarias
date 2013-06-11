package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la quinta extracción de
 * dinero se cobre un costo adicional por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {

	private Integer cantidadextraccion;
	private final static double A = 5;
	private final static double B = 6;

	public CajaAhorros() {
		super.setMonto(new Double("0"));
		cantidadextraccion = 0;
	}

	/**
	 * No hay reglas adicionales para el depósito
	 * 
	 * @param monto
	 *            a depositar
	 */
	public void depositar(final Double monto) {
		if (this.getMonto() >= 0) {
			this.setMonto(this.getMonto() + monto);
		} else {
			throw new CuentaBancariaException(
					"El monto debe ser un numero positivo");
		}
	}

	/**
	 * Se cobran $6 adicionales por cada extracción luego de la quinta.
	 * 
	 * @param monto
	 *            a extraer
	 */
	public void extraer(final Double monto) {
		if (this.getMonto() > monto) {
			if (cantidadextraccion >= A)
				this.setMonto(this.getMonto() - monto - B);
			else {
				this.setMonto(this.getMonto() - monto);
				this.cantidadextraccion++;
			}
		} else {
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
