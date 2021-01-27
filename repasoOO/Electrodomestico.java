package repasoOO;

public class Electrodomestico {
	
	private double consumoWh;
	private String nombre;
	
	private long tiempoTotalEncendido;
	private long horaDeEncendido;
	private boolean encendido;

	public Electrodomestico(double consumoWh, String nombre) {
		this.consumoWh = consumoWh;
		this.setNombre(nombre);
	}
	
	private void setNombre(String n) {
		this.nombre = n;
	}

	/**
	 * @return the consumoWh
	 */
	public double getConsumoWh() {
		return consumoWh;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void encender() {
		if (!encendido) {
			this.horaDeEncendido = System.currentTimeMillis();
			encendido = true;
		}
	}
	
	public void apagar() {
		if (encendido) {
			this.tiempoTotalEncendido += System.currentTimeMillis() - this.horaDeEncendido;
			encendido = false;
		}
	}
	
	public long getTiempoTotal() {
		long tiempoEncendido = 0;
		
		if (!encendido) {
			tiempoEncendido = this.tiempoTotalEncendido;
		}
		else {
			tiempoEncendido = this.tiempoTotalEncendido + (System.currentTimeMillis() - this.horaDeEncendido);
		}
		
		return tiempoEncendido * 3600;
	}
	
	public double calculaConsumo() {
		// Para calcular el consumo, necesito saber:
		//	1º- El tiempo que ha estado encendido el electrodoméstico
		//  2º- El consumo del electrodoméstico
		long tiempoEnHoras = (this.getTiempoTotal() / 1000) / 3600;
		
		return this.consumoWh * tiempoEnHoras;
	}
	
}
