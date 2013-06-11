package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {
	
	private Double descubiertoTotal;
	
	/**
	 * Toda cuenta corriente se inicia con un límite total
	 * para el descubierto.
	 * @param descubiertoTotal
	 */
	
	public CuentaCorriente(final Double descubiertoTotal) {
		super.setMonto(new Double(0));
		this.descubiertoTotal = descubiertoTotal;
	}
	
	public void InicializarDescubiertoTotal(Double descubiertoTotal) {

		this.setDescubiertoTotal(descubiertoTotal);
	}
	
	/**
	 * Todo depósito deberá cubrir primero el descubierto,
	 * si lo hubiera, y luego contar para el saldo de la
	 * cuenta.
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (this.getMonto() >= 0) {
			this.setMonto(this.getMonto() + monto);

		} else
			throw new CuentaBancariaException("CuentaSueldo No se puede depositar un monto negativo");

	}

	/**
	 * Se cobrará el 5% de comisión sobre el monto girado
	 * en descubierto.
	 * Por supuesto, no puede extraerse más que el total
	 * de la cuenta, más el descubierto (comisión incluída)
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (this.getMonto() < this.descubiertoTotal * -1)
			throw new CuentaBancariaException(
					"Debe cubrir primero el descubierto total");

		else {
			if (this.getMonto() - monto > 0)
				this.setMonto(this.getMonto() - monto);
			else {
				if (this.getMonto() - monto >= this.descubiertoTotal * -1)
					this.setMonto(this.getMonto() - monto - 0.05
							* this.getMonto());
				else
					throw new CuentaBancariaException(
							"El monto  debe ser menor al que usted tiene depositado");
			}
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.getMonto();
	}
	
	/**
	 * Permite saber el saldo en descubierto
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.getDescubierto();
	}

	public Double getDescubiertoTotal() {
		return descubiertoTotal;
	}

	public void setDescubiertoTotal(Double descubiertoTotal) {
		this.descubiertoTotal = descubiertoTotal;
	}
}
