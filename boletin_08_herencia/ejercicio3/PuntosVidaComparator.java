package boletin_08_herencia.ejercicio3;

import java.util.Comparator;

public class PuntosVidaComparator implements Comparator<Personaje> {
	public int compare(Personaje p1, Personaje p2) {
		int res = 0;
		if (p1 == null && p2 == null) {
			res = 0;
		}
		else if (p1 == null) {
			res = 1;
		}
		else if (p2 == null) {
			res = -1;
		}
		else {
			res = p1.getPuntos_vida_actuales() - p2.getPuntos_vida_actuales();
			// También valdría
			// res = p1.compareTo(p2);
			// ya que sabemos que ni p1 ni p2 son nulos
		}
		
		return res;
	}
}
