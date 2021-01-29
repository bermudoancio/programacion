package clase.herencia;

public class Bicicleta extends Vehiculo {
	private int pulgadasRuedas;
	
	public Bicicleta(int numeroRuedas, int numeroPasajeros, int pulgadas) {
		super(numeroRuedas, numeroPasajeros);
		this.pulgadasRuedas = pulgadas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " ruedas: " + this.getNumeroRuedas();
	}
}
