package clase.herencia;

public class CocheGasolina extends Coche {
	private double capacidadDeposito;
	private double combustibleRestante;

	/**
	 * @return the capacidadDeposito
	 */
	public double getCapacidadDeposito() {
		return capacidadDeposito;
	}

	/**
	 * @param capacidadDeposito the capacidadDeposito to set
	 */
	public void setCapacidadDeposito(double capacidadDeposito) {
		this.capacidadDeposito = capacidadDeposito;
	}

	/**
	 * @return the combustibleRestante
	 */
	public double getCombustibleRestante() {
		return combustibleRestante;
	}

	/**
	 * @param combustibleRestante the combustibleRestante to set
	 */
	public void setCombustibleRestante(double combustibleRestante) {
		this.combustibleRestante = combustibleRestante;
	}

	public CocheGasolina(int numeroRuedas, int numeroPasajeros, int numeroPuertas, TColores color) {
		super(numeroRuedas, numeroPasajeros, numeroPuertas, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void repostar() {
		System.out.println("El coche de gasolina ha repostado");

	}

	@Override
	public String toString() {
		return "CocheGasolina [capacidadDeposito=" + capacidadDeposito + ", combustibleRestante=" + combustibleRestante
				+ "]";
	}
	
	@Override
	public void arrancar() {
		System.out.println("Arrancando coche de gasolina");
	}

}
