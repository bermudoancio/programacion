package boletin_08_herencia.estrellas;

public class Planeta extends Planetoide {
	public static final int MAX_LUNAS = 30;
	
	private float distanciaMediaAlSol;
	private Luna[] lunas;

	public Planeta(String nombre, double diametro, TipoPlaneta tipo, float distanciaMediaAlSol) {
		super(nombre, diametro, tipo);
		this.distanciaMediaAlSol = distanciaMediaAlSol;
		this.lunas = new Luna[Planeta.MAX_LUNAS];
	}

	public float getDistanciaMediaAlSol() {
		return distanciaMediaAlSol;
	}

	public Luna[] getLunas() {
		return lunas;
	}
	
	
}
