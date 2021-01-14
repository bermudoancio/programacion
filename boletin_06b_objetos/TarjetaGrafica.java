package boletin_06b_objetos;

public class TarjetaGrafica {
	private String marca;
	private String modelo;
	private int numeroNucleos;
	private float velocidad;
	private int memoria;
	
	public TarjetaGrafica(String marca, String modelo, int numeroNucleos, float velocidad, int memoria) {
		this.marca = marca;
		this.modelo = modelo;
		this.numeroNucleos = numeroNucleos;
		this.velocidad = velocidad;
		this.memoria = memoria;
	}

	@Override
	public String toString() {
		return "TarjetaGrafica [marca=" + marca + ", modelo=" + modelo + ", numeroNucleos=" + numeroNucleos
				+ ", velocidad=" + velocidad + ", memoria=" + memoria + "]";
	}	
	
}
