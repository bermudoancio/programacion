package boletines_09_colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Equipo {
	private String nombre;
	private Set<Alumno> jugadores;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.jugadores = new HashSet<>();
	}
	
	public void add(Alumno a) throws EquipoException {
		if (!this.jugadores.add(a)) {
			throw new EquipoException("No se ha podido añadir al jugador");
		}
	}
	
	public void borrar(Alumno a) throws EquipoException {
		if (!this.jugadores.remove(a)) {
			throw new EquipoException("No se ha podido borrar al jugador");
		}
	}
	
	public Alumno pertenece (Alumno a) {
		if (this.jugadores.contains(a)) {
			return a;
		}
		else {
			return null;
		}
	}
	
	public Alumno pertenece2 (Alumno a) {
				
		for (Alumno x : this.jugadores) {
			if (x != null && x.equals(a)) {
				return x;
			}
		}
		
		return null;
	}
	
	public Alumno pertenece3 (Alumno a) {
		Alumno x = null;
		Iterator<Alumno> it = this.jugadores.iterator();
		
		Alumno buscado = null;
		while (it.hasNext() && x == null) {
			buscado = it.next();
			if (buscado != null && buscado.equals(a)) {
				x = buscado;
			}
		}
		
		return x;
	}
	
	public void muestraEquipo() {
		for (Alumno x : this.jugadores) {
			System.out.println(x);
		}
	}
	
}
