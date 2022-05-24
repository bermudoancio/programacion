package boletin_09_colecciones_diccionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Diccionario22 {
	Map<String, List<String>> diccionario;
	
	public Diccionario22() {
		diccionario = new HashMap<>();
	}
	
	public void addPalabra(String palabra, String significado){
		List<String> significados;
		if (diccionario.containsKey(palabra)) {
			significados = diccionario.get(palabra);
		//if ((significados = diccionario.get(palabra)) != null) {
			significados.add(significado);
		}
		else {
			significados = new ArrayList<>();
			significados.add(significado);
			diccionario.put(palabra, significados);
			
		}
	}
	
	public List<String> buscarPalabra(String palabra) {
		return diccionario.get(palabra);
	}
	
	public void borrarPalabra(String palabra) {
		diccionario.remove(palabra);
	}
	
	public List<String> listadoPalabras(String cadena){
		
		return diccionario.keySet().stream()
				.filter(p -> p.startsWith(cadena))
				.sorted()
				.collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
