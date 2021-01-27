package repasoOO;

public class Estufa extends Electrodomestico {
	private int numeroFases;
	
	public Estufa(double consumoWh, String nombre, int numeroFases) {
		super(consumoWh, nombre);
		
		this.numeroFases = numeroFases;
	}
	
	public void imprimeEstufa() {
		System.out.println("soy una estufa");
	}
	
	public double calculaConsumo() {
		// Para calcular el consumo, necesito saber:
		//	1º- El tiempo que ha estado encendido el electrodoméstico
		//  2º- El consumo del electrodoméstico
		long tiempoEnHoras = (this.getTiempoTotal() / 1000) / 3600;
		
		return this.getConsumoWh() * numeroFases * tiempoEnHoras;
	}
	
	public void imprimeQuienEres() {
		System.out.println("Soy una estufa");
	}
}
