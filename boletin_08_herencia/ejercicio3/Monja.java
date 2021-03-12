package boletin_08_herencia.ejercicio3;

public class Monja extends Personaje implements IRezable {

	private int puntosExtraCuracion;
	
	public Monja(String nombre, Raza raza, int fuerza)
			throws InvalidValueException {
		super(nombre, raza, fuerza, 20, 100);
		
	}

	@Override
	public void rezar() {
		this.puntosExtraCuracion += 4;
	}
	
}
