package edu.tallerweb.cuentas;

/**
 * Modela el concepto de Cuenta. Esta clase abstracta sirve como base para una
 * posible jerarquía (si fuese necesaria)
 * Es probable que la tarea se facilite otorgando una imple- mentación a los
 * métodos proporcionados.
 */
public abstract class AbstractCuenta {
	private Double monto;

	/**
	 * Agrega a la cuenta el monto determinado
	 * 
	 * @param monto
	 *            a depositar
	 */
	public abstract void depositar(final Double monto);

	/**
	 * Retira de la cuenta el monto determinado
	 * @param monto
	 *            a extraer
	 */
	public abstract void extraer(final Double monto);

	public Double getMonto() {
		return monto;
	}

	public void setMonto(final Double monto) {
		this.monto = monto;
	}

}
