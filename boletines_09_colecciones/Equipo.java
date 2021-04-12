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
	
	public String getNombre() {
		return nombre;
	}

	public Set<Alumno> getJugadores() {
		return jugadores;
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
	
	public Equipo union(Equipo e) {
		this.jugadores.addAll(e.getJugadores());
		return this;
	}
	
	public Equipo union2(Equipo e) {
		for (Alumno a : e.getJugadores()) {
			this.jugadores.add(a);
		}
		
		return this;
	}
	
	public Equipo interseccion(Equipo e) {
		this.jugadores.retainAll(e.getJugadores());
		return this;
	}
	
	public Equipo interseccion2(Equipo e) {
		Iterator<Alumno> it = this.jugadores.iterator();
		
		while (it.hasNext()) {
			Alumno a = it.next();
			if (!e.getJugadores().contains(a)) {
				it.remove();
			}
		}
		
		return this;
	}
	
}
