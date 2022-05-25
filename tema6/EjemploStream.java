package tema6;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStream {

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<>();
		lista.add(1);
		lista.add(2);
		lista.add(88);
		lista.add(4);
		lista.add(5);
		lista.add(47);
		lista.add(7);
		lista.add(1);
		
		Stream<Integer> flujo = lista.stream();
		
		//flujo.forEach(System.out::println);
		
		
//		System.out.println(" ");
//		
//		List<Integer> enteros = flujo.filter(a -> a.intValue() > 4)
//		.filter(a -> a.intValue() < 7)
//		.collect(Collectors.toList());
//		
//		enteros.stream().filter(a -> a < 6).forEach(System.out::println);
		
		flujo.sorted().forEach(System.out::println);
	}

}
