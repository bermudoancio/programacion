package clase.herencia;

public abstract class Vehiculo {
	private int numeroRuedas;
	private int numeroPasajeros;
	
	public Vehiculo(int numeroRuedas, int numeroPasajeros) {
		super();
		
		this.numeroRuedas = numeroRuedas;
		this.numeroPasajeros = numeroPasajeros;
	}
	
	public Vehiculo() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Vehiculo) {
			Vehiculo v = (Vehiculo) obj;
		}
		return super.equals(obj);
	}
	
	public int getNumeroRuedas() {
		return numeroRuedas;
	}
	
	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}
	
	public void setNumeroRuedas(int num) {
		this.numeroRuedas = num;
	}
	
	
	public String toString() {
		return "ToString de Vehículo";
	}
	
}
