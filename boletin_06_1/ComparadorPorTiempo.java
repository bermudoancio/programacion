package boletin_06_1;

import java.util.Comparator;

public class ComparadorPorTiempo implements Comparator<Receta>{

	@Override
	public int compare(Receta o1, Receta o2) {
		
		return Integer.compare(o1.getMinutosDePreparacion(), o2.getMinutosDePreparacion());
	}

}
