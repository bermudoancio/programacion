package boletin_06_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Receta implements Comparable<Receta>{
	private String nombreReceta;
	private int minutosDePreparacion;
	private HashSet<Ingrediente> ingredientes;
	private LinkedList<String> pasos;

	public Receta(String nombreReceta, int minutosPreparacion) throws RecetaException {
		this.nombreReceta = nombreReceta.toUpperCase();
		setMinutosDePreparacion(minutosPreparacion);
		ingredientes = new HashSet<Ingrediente>();
		pasos = new LinkedList<String>();
	}

	public int getMinutosDePreparacion() {
		return minutosDePreparacion;
	}

	public void setMinutosDePreparacion(int minutosDePreparacion) throws RecetaException {
		if (minutosDePreparacion <= 0) {
			throw new RecetaException("Minutos incorrectos");
		}
		this.minutosDePreparacion = minutosDePreparacion;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void annadirPasoAlFinal(String paso) {
		pasos.add(paso.toUpperCase());
	}

	public void annadirIngrediente(Ingrediente ingredienteNuevo) {

		boolean esta = false;
		Ingrediente ingredienteDeLaColeccion;
		int nuevaCantidad;
		Iterator<Ingrediente> iterador = ingredientes.iterator();

		while (iterador.hasNext() && esta == false) {

			ingredienteDeLaColeccion = iterador.next();
			if (ingredienteNuevo.equals(ingredienteDeLaColeccion)) {

				nuevaCantidad = ingredienteNuevo.getCantidad() + ingredienteDeLaColeccion.getCantidad();
				ingredienteDeLaColeccion.setCantidad(nuevaCantidad);
				esta = true;
			}
		}

		if (esta == false) {

			ingredientes.add(ingredienteNuevo);
		}

	}

	public boolean necesitaIngrediente(String nombreIngrediente) {

		Ingrediente ingredientePatron = new Ingrediente(nombreIngrediente);
		return ingredientes.contains(ingredientePatron);
	}

	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {

		String paso;
		if (!ingredientes.contains(ingredienteABorrar)) {
			throw new RecetaException("ERROR. No se encuentra dicho ingrediente,as� que no se puede borrar.");
		}

		// Borrar el ingrediente
		ingredientes.remove(ingredienteABorrar);

		// Borrar todos los pasos que nombran a ese ingrediente
		
		Iterator<String> it= pasos.iterator();
		while (it.hasNext()) {
			paso=it.next();
			
			if (paso.contains(ingredienteABorrar.getNombreIngrediente())) {
				it.remove();
			}
			
		}
		
		
	}

	// A -> B -> C ->  D
	// 0    1    2    3
	
	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {

		int indice;
		
		indice=pasos.indexOf(pasoExistente);
		if (indice ==-1) {
			throw new RecetaException("No se encuentra el paso " + pasoExistente);
		}
		
		pasos.add(indice+1, pasoNuevo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReceta == null) ? 0 : nombreReceta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (nombreReceta == null) {
			if (other.nombreReceta != null)
				return false;
		} else if (!nombreReceta.equals(other.nombreReceta))
			return false;
		return true;
	}

	@Override
	public int compareTo(Receta otra) {
		return this.getNombreReceta().compareTo( otra.getNombreReceta());
	}

}
