package boletin_08_herencia.ejercicio3;

import java.util.Comparator;

public class PuntosVidaComparator implements Comparator<Personaje> {
	public int compare(Personaje p1, Personaje p2) {
		return p1.getPuntos_vida_actuales() - p2.getPuntos_vida_actuales();
	}
}
