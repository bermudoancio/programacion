package boletin_09_colecciones_diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Diccionario {
	
	private Map<String, List<String>> diccionario;

	public Diccionario() {
		diccionario = new HashMap<>();
	}
	
	public void addPalabra(String palabra, String significado) {
		if (diccionario.containsKey(palabra)) {
			// La palabra ya está en el diccionario
			diccionario.get(palabra).add(significado);
		}
		else {
			// La palabra no se encuentra en el diccionario todavía
			List<String> significados = new ArrayList<>();
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
	
	public List<String> listadoPalabras(String comienzaPor){
		Set<String> claves = diccionario.keySet();
		List<String> clavesOrdenadas = new ArrayList<String>();
		
		for (String palabra : claves) {
			if (palabra.toUpperCase().startsWith(comienzaPor.toUpperCase())) {
				clavesOrdenadas.add(palabra);
			}	
		}
				
		//Collections.sort(clavesOrdenadas);
		clavesOrdenadas.sort(null);
		return clavesOrdenadas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
