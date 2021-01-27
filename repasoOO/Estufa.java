package repasoOO;

public class Estufa extends Electrodomestico {
	private int numeroFases;
	
	public Estufa(double consumoWh, String nombre, int numeroFases) {
		super(consumoWh, nombre);
		
		this.numeroFases = numeroFases;
	}
}
