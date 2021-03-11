package boletin_08_herencia.estrellas;

public class Planetoide {
	private String nombre;
	private double diametro;
	private TipoPlaneta tipo;
	
	public Planetoide(String nombre, double diametro, TipoPlaneta tipo) {
		this.nombre = nombre;
		this.diametro = diametro;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDiametro() {
		return diametro;
	}

	public TipoPlaneta getTipo() {
		return tipo;
	}
	
	
	
}
