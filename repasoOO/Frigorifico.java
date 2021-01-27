package repasoOO;

public class Frigorifico extends Electrodomestico {

	public Frigorifico(double consumoWh, String nombre) {
		super(consumoWh, nombre);
		// TODO Auto-generated constructor stub
	}
	
	public double calculaConsumo() {
		// Para calcular el consumo, necesito saber:
		//	1º- El tiempo que ha estado encendido el electrodoméstico
		//  2º- El consumo del electrodoméstico
		long tiempoEnHoras = (this.getTiempoTotal() / 1000) / 3600;
		
		return this.getConsumoWh() * tiempoEnHoras;
	}

}
