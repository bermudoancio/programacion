package boletin_06b_objetos;

public class Microprocesador {
	private String marca;
	private String modelo;
	private String socket;
	private int numeroNucleos;
	private float velocidad;
	
	public Microprocesador(String marca, String modelo, String socket, int numeroNucleos, float velocidad) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.socket = socket;
		this.numeroNucleos = numeroNucleos;
		this.velocidad = velocidad;
	}
	
	public String getSocket() {
		return this.socket;
	}
	
	@Override
	public String toString() {
		return "Microprocesador [marca=" + marca + ", modelo=" + modelo + ", socket=" + socket + ", numeroNucleos="
				+ numeroNucleos + ", velocidad=" + velocidad + "]";
	}
}
