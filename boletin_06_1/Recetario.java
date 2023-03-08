package boletin_06_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Recetario {

	private HashMap<String, Receta> recetas;
	
	public Recetario() {
		recetas=new HashMap<String,Receta>();
	
	}
	
	public void annadirReceta( Receta nuevaReceta) throws RecetaException {
		// Si ya existe
		if ( recetas.containsKey(nuevaReceta.getNombreReceta())) {
			throw new RecetaException("Ya existe esa receta ");
		}
		
		recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
		
	}
	
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		StringBuilder info=new StringBuilder();
		List<Receta> listaRecetasOrdenadas=(List<Receta>) recetas.values();
		Collections.sort(listaRecetasOrdenadas);
		for (Receta receta : listaRecetasOrdenadas) {
			info.append(receta + "\n");
		}
		return info.toString();
	}
	
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException{
		StringBuilder info=new StringBuilder();
		ArrayList<Receta> listaRecetasConIngrediente=new ArrayList<Receta>();
		for (Receta receta : recetas.values()) {
			
			if (receta.necesitaIngrediente(ingrediente)) {
				listaRecetasConIngrediente.add(receta);
			}
		}
		ComparadorPorTiempo comp=new ComparadorPorTiempo();
		
		Collections.sort( listaRecetasConIngrediente, comp);
		for (Receta receta : listaRecetasConIngrediente) {
			info.append(receta + "\n");
		}
		return info.toString();
		
	}
}
