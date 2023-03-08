package boletin_09_clase;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaOrdenada {
	LinkedList<Integer> lista = new LinkedList<Integer>();
	
	public void insertarEnOrden(Integer nuevo) {
		int pos = buscarSuSito(nuevo);
		lista.add(pos, nuevo);
	}

	private int buscarSuSito(Integer nuevo) {
		boolean encontradoPosicion = false;
		
		int pos = 0;
		Iterator<Integer> it = lista.iterator();
		Integer elemento;
		
		while (it.hasNext() && encontradoPosicion == false) {
			elemento = it.next();
			if (nuevo.intValue() < elemento.intValue())
				encontradoPosicion = true;
			else
				pos++;
		}
		return pos;
	}
	
	public LinkedList<Integer> getLista() {
		return lista;
	}
}
