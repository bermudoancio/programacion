package boletin_08_herencia.ejercicio3;

public abstract class Personaje {
	
	public static enum Raza {
		HUMANO, ELFO, ENANO, ORCO
	}
	
	public static final int MAX_STATS = 20;
	public static final int MIN_STATS = 0;
	
	public static final int MAX_PUNTOS_VIDA = 100;
	public static final int MIN_PUNTOS_VIDA = 0;
	
	private String nombre;
	private Raza raza;
	private int fuerza, inteligencia, puntos_vida_max, puntos_vida_actuales;
	
	
	public Personaje(String nombre, Raza raza, int fuerza, int inteligencia, int puntos_vida_max) throws InvalidValueException {
				
		this.setNombre(nombre);	
		this.setRaza(raza);	
		this.setFuerza(fuerza);
		this.setInteligencia(inteligencia);
		this.setPuntos_vida_max(puntos_vida_max);
		this.setPuntos_vida_actuales(puntos_vida_max);
		

	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws InvalidValueException {
		if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
			throw new InvalidValueException("El nombre no es correcto");
		}
		this.nombre = nombre;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) throws InvalidValueException {
		if (raza == null) {
			throw new InvalidValueException("Raza no puede estar vacía");
		}
		this.raza = raza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) throws InvalidValueException {
		if (!Personaje.checkValidStat(fuerza, Personaje.MIN_STATS, Personaje.MAX_STATS)) {
			throw new InvalidValueException("La fuerza debe estar entre " + Personaje.MIN_STATS + " y " + Personaje.MAX_STATS);
		}
		this.fuerza = fuerza;
	}
	
	protected static boolean checkValidStat(int value, int minValue, int maxValue) {
		boolean valid = true;
		if (value < minValue || value > maxValue) {
			valid = false;
		}
		
		return valid;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) throws InvalidValueException {
		if (!Personaje.checkValidStat(inteligencia, Personaje.MIN_STATS, Personaje.MAX_STATS)) {
			throw new InvalidValueException("La inteligencia debe estar entre " + Personaje.MIN_STATS + " y " + Personaje.MAX_STATS);
		}
		this.inteligencia = inteligencia;
	}

	public int getPuntos_vida_max() {
		return puntos_vida_max;
	}

	public void setPuntos_vida_max(int puntos_vida_max) throws InvalidValueException {
		if (!Personaje.checkValidStat(puntos_vida_max, Personaje.MIN_PUNTOS_VIDA, Personaje.MAX_PUNTOS_VIDA)) {
			throw new InvalidValueException("Los puntos de vida máxima deben estar entre " + Personaje.MIN_PUNTOS_VIDA + " y " + Personaje.MAX_PUNTOS_VIDA);
		}
		this.puntos_vida_max = puntos_vida_max;
	}

	public int getPuntos_vida_actuales() {
		return puntos_vida_actuales;
	}

	public void setPuntos_vida_actuales(int puntos_vida_actuales) {
//		if (!Personaje.checkValidStat(puntos_vida_actuales, Personaje.MIN_PUNTOS_VIDA, this.puntos_vida_max)) {
//			throw new InvalidValueException("Los puntos de vida deben estar entre " + Personaje.MIN_PUNTOS_VIDA + " y " + this.puntos_vida_max);
//		}
		if (puntos_vida_actuales < Personaje.MIN_PUNTOS_VIDA) {
			puntos_vida_actuales = Personaje.MIN_PUNTOS_VIDA;
		}
		else if (puntos_vida_actuales > this.puntos_vida_max) {
			puntos_vida_actuales = this.puntos_vida_max;
		}
		
		this.puntos_vida_actuales = puntos_vida_actuales;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + ", inteligencia="
				+ inteligencia + ", puntos_vida_max=" + puntos_vida_max + ", puntos_vida_actuales="
				+ puntos_vida_actuales + "]";
	}
	
	public void beDamaged(int points) throws InvalidValueException {
		if (points > 0) {
			this.setPuntos_vida_actuales(this.getPuntos_vida_actuales() - points);
		}
		else {
			throw new InvalidValueException("No me hagas trampas");
		}
	}
	
	public void beHealed(int points) throws InvalidValueException {
		if (points > 0) {
			this.setPuntos_vida_actuales(this.getPuntos_vida_actuales() + points);
		}
		else {
			throw new InvalidValueException("No me hagas trampas");
		}
	}
	
}
