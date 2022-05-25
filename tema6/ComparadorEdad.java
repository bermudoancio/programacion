package tema6;

import java.util.Comparator;

public class ComparadorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getEdad() - p2.getEdad();
	}

}
