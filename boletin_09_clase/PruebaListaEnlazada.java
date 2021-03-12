package boletin_09_clase;

import java.util.Iterator;
import java.util.List;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		
		List<Integer> lista = new ListaEnlazada<>();
		
		System.out.println(lista.isEmpty());
		
		lista.add(1);
		lista.add(3);
		lista.add(2);
		lista.add(null);
		
		lista.indexOf(null);
		
		Iterator<Integer> it = lista.iterator();
		
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
		}
		
	}

}
