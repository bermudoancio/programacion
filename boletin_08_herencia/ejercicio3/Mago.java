package boletin_08_herencia.ejercicio3;

import java.util.Arrays;

public class Mago extends Personaje {
	
	public static final int MAGO_MIN_INTEL = 17;
	public static final int MAGO_MAX_FUERZA = 15;
	public static final int NUM_HECHIZOS_POR_DEFECTO = 4;
	public static final int MAGO_DAMAGE_POINTS = 10;
	
	// Array donde guardaremos los hechizos aprendidos
	private String[] hechizos;

	public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int puntos_vida_max)
			throws InvalidValueException {
		super(nombre, raza, fuerza, inteligencia, puntos_vida_max);
		
		this.hechizos = new String[NUM_HECHIZOS_POR_DEFECTO];
	}
	
	@Override
	public void setFuerza(int f) throws InvalidValueException {
		//Personaje.checkValidStat(f, Personaje.MIN_STATS, MAGO_MAX_FUERZA);
		if (f > MAGO_MAX_FUERZA) {
			throw new InvalidValueException("La fuerza máxima del mago es " + Mago.MAGO_MAX_FUERZA);
		}
		super.setFuerza(f);
	}
	
	@Override
	public void setInteligencia(int inteligencia) throws InvalidValueException {
		if (inteligencia < MAGO_MIN_INTEL) {
			throw new InvalidValueException("La inteligencia mínima del mago es " + Mago.MAGO_MIN_INTEL);
		}
		super.setInteligencia(inteligencia);
	}
	
	public boolean aprendeHechizo(String h) throws InvalidValueException {
		Mago.validarHechizo(h);
		
		boolean enc = false;
		int i = 0;
		
		if (!this.existeHechizo(h)) {
			while (!enc && i < this.hechizos.length) {
				if (this.hechizos[i] == null) {
					this.hechizos[i] = h;
					enc = true;
				}
				
				i++;
			}
		}
		else {
			//No lo aprendo porque ya existe
		}
		
		if (!enc) {
			// No puedo aprender más		
		}
		
		return enc;
	}
	
	public static void validarHechizo(String h) throws InvalidValueException {
		if (h == null || h.isBlank()) {
			throw new InvalidValueException("El hechizo no es válido");
		}
	}
	
	public String lanzaHechizo(Personaje p, String h) throws InvalidValueException {
		
		if (this.existeHechizo(h)) {
			p.setPuntos_vida_actuales(p.getPuntos_vida_actuales() - Mago.MAGO_DAMAGE_POINTS);
			//p.beDamaged(Mago.MAGO_DAMAGE_POINTS);
			this.olvidarHechizo(h);
		}
		else {
			throw new InvalidValueException("El hechizo \"" + h + "\" no existe");
		}
		
		return h;
	}
	
	private void olvidarHechizo(String h) {
		boolean enc = false;
		for (int i = 0; !enc && i < this.hechizos.length; i++) {
			if (h.equals(this.hechizos[i])) {
				this.hechizos[i] = null;
				enc = true;
			}
		}
	}
	
	private boolean existeHechizo(String h) {
		boolean enc = false;
		
		if (h != null) {
			for (int i = 0; !enc && i < this.hechizos.length; i++) {
				if (h.equals(this.hechizos[i])) {
					enc = true;
				}
			}
		}
		
		return enc;
	}

	@Override
	public String toString() {
		return "Mago [hechizos=" + Arrays.toString(hechizos) + ", getNombre()=" + getNombre() + ", getRaza()="
				+ getRaza() + ", getFuerza()=" + getFuerza() + ", getInteligencia()=" + getInteligencia()
				+ ", getPuntos_vida_max()=" + getPuntos_vida_max() + ", getPuntos_vida_actuales()="
				+ getPuntos_vida_actuales() + "]";
	}

//	@Override
//	public String toString() {
//		return super.toString() + "\nMago [hechizos=" + Arrays.toString(hechizos) + "]";
//	}
	
	
}
