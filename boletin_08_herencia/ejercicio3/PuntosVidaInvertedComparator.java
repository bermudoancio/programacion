package boletin_08_herencia.ejercicio3;

import java.util.Comparator;

public class PuntosVidaInvertedComparator implements Comparator<Personaje> {
	public int compare(Personaje p1, Personaje p2) {
		int res = 0;
		res = p2.getPuntos_vida_actuales() - p1.getPuntos_vida_actuales();
				
		return res;
	}
}
