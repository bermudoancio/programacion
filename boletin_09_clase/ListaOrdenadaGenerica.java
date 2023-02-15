package boletin_09_clase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaOrdenadaGenerica<T extends Comparable<T>> implements Iterable<T> {
	List<T> lista;
	
	public ListaOrdenadaGenerica() {
		lista = new LinkedList<>();
	}

	public void insertarEnOrden(T nuevo) {
		boolean encontradoPosicion = false;
		
		int pos = 0;
		Iterator<T> it = lista.iterator();
		T elemento;
		
		while (it.hasNext() && !encontradoPosicion) {
			elemento = it.next();
			if (nuevo.compareTo(elemento) <= 0)
				encontradoPosicion = true;
			else
				pos++;
		}
		
		lista.add(pos, nuevo);
	}

	
	public List<T> getLista() {
		return lista;
	}

	@Override
	public Iterator<T> iterator() {
		return lista.iterator();
	}
}
