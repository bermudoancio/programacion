package tema6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class EjemploStreamPersonas {

	public static void main(String[] args) {
		Persona p1 = new Persona("Pepe", 23, 150);
		Persona p2 = new Persona("Antonia", 30, 170);
		Persona p3 = new Persona("Mari", 21, 160);
		
		Stream<Persona> flujo = Stream.of(p1, p2, p3);
		
		//flujo.sorted(new ComparadorEdad())
//		flujo.sorted(new Comparator<Persona>() {
//
//			@Override
//			public int compare(Persona o1, Persona o2) {
//				if (o1.getEdad() == o2.getEdad()) {
//					return o1.getNombre().compareTo(o2.getNombre());			
//				}
//				else {
//					return o1.getEdad() - o2.getEdad();
//				}
//			}
//			
//		})
		
		//flujo.sorted((o1, o2) -> o1.getAltura() - o2.getAltura())
		
		flujo.map(o1 -> Integer.valueOf(o1.getAltura()))
		.forEach(System.out::println);

	}

}
