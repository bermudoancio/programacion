package boletin_09_clase;

public class PruebaListaOrdenada {

	public static void main(String[] args) {
		ListaOrdenada lo = new ListaOrdenada();
		lo.insertarEnOrden(7);
		lo.insertarEnOrden(3);
		lo.insertarEnOrden(1);
		lo.insertarEnOrden(8);
		lo.insertarEnOrden(5);
		
		for(Integer i: lo.getLista()) {
			System.out.println(i);
		}
		
		ListaOrdenadaGenerica<Integer> log = new ListaOrdenadaGenerica<>();
		log.insertarEnOrden(7);
		log.insertarEnOrden(3);
		log.insertarEnOrden(1);
		log.insertarEnOrden(8);
		log.insertarEnOrden(5);
		
		for(Integer i: log) {
			System.out.println(i);
		}

	}

}
