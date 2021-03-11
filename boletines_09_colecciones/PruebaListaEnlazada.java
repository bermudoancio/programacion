package boletines_09_colecciones;

import java.util.Iterator;

public class PruebaListaEnlazada {

	public PruebaListaEnlazada() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ListaEnlazada<Integer> lista = new ListaEnlazada<>();

		lista.add(3);
		lista.add(4);
		lista.add(12);
		
		System.out.println(lista.contains(6));
		
		Iterator<Integer> it = lista.iterator();
		
		while (it.hasNext()) {
			Integer el = it.next();
			System.out.println(el);
			if (el.equals(4)) {
				System.out.println("Borrando el número " + el);
				it.remove();
			}
		}
	}

}
