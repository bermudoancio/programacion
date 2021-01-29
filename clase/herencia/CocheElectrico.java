package clase.herencia;

import java.io.File;

public class CocheElectrico extends Coche{
	private double capacidadBateria;
	private double bateriaRestante;
	//private int numeroPuertas;
	
	public CocheElectrico(int numeroRuedas, int numPasajeros, int numPuertas, TColores color, double cap) {
		super(numeroRuedas, numPasajeros, numPuertas, color);
		this.capacidadBateria = cap;
		this.getNumeroPuertas();
	}
	
				
	public void unMetodo() {
		this.setNumeroRuedas(2);
	}
	
	@Override
	public void claxon() {
		//super.claxon();
		System.out.println("Claxon en coche eléctrico");
	}
	
	public void tocarClaxonPadre() {
		super.claxon();
	}
	
	public void repostar() {
		this.bateriaRestante = capacidadBateria;
		System.out.println("El coche eléctrico ha repostado");
	}


	@Override
	public void arrancar() {
		System.out.println("Arrancando coche eléctrico");
	}


	@Override
	public String toString() {
		return "CocheElectrico [capacidadBateria=" + capacidadBateria + ", bateriaRestante=" + bateriaRestante + 
				"Color: " + this.getColor() + "]";
	}
	
}
