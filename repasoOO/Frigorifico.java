package repasoOO;

public class Frigorifico extends Electrodomestico {

	public Frigorifico(double consumoWh, String nombre) {
		super(consumoWh, nombre);
		// TODO Auto-generated constructor stub
	}
	
	public double calculaConsumo() {
		// Para calcular el consumo, necesito saber:
		//	1�- El tiempo que ha estado encendido el electrodom�stico
		//  2�- El consumo del electrodom�stico
		long tiempoEnHoras = (this.getTiempoTotal() / 1000) / 3600;
		
		return this.getConsumoWh() * tiempoEnHoras;
	}

}
