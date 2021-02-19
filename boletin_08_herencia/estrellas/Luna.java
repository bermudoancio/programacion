package boletin_08_herencia.estrellas;

public class Luna extends Planetoide{
	private double distanciaAlPlaneta;

	public Luna(String nombre, double diametro, TipoPlaneta tipo, double distanciaAlPlaneta) {
		super(nombre, diametro, tipo);
		this.distanciaAlPlaneta = distanciaAlPlaneta;
	}	
	
}
