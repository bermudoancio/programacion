package boletin_06b_objetos;

public class DiscoDuro {
	private String marca;
	private String tipo;
	private int capacidad;
	
	@Override
	public String toString() {
		return "DiscoDuro [marca=" + marca + ", tipo=" + tipo + ", capacidad=" + capacidad + "]";
	}

	public DiscoDuro(String marca, String tipo, int capacidad) {
		super();
		this.marca = marca;
		this.tipo = tipo;
		this.capacidad = capacidad;
	}
	
	
}
