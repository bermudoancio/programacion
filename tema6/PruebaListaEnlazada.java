package tema6;

import java.util.Iterator;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		ListaEnlazada<String> lista = new ListaEnlazada<>();
		
		lista.add("Hola");
		lista.add("a");
		lista.add("todos");
		
		for (String s: lista) {
			System.out.println(s);
		}
		
		System.out.println(lista.get(1));
		
		Iterator<String> it = lista.iterator();
		
		while (it.hasNext()) {
			String s = it.next();
			
			if (s.equals("todos")) {
				it.remove();
			}
		}
		
		for (String s: lista) {
			System.out.println(s);
		}
	}

}
