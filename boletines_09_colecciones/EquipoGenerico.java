package boletines_09_colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EquipoGenerico<T> {
	private String nombre;
	private Set<T> jugadores;
	
	public EquipoGenerico(String nombre) {
		this.nombre = nombre;
		this.jugadores = new HashSet<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public Set<T> getJugadores() {
		return jugadores;
	}

	public void add(T a) throws EquipoException {
		if (!this.jugadores.add(a)) {
			throw new EquipoException("No se ha podido añadir al jugador");
		}
	}
	
	public void borrar(T a) throws EquipoException {
		if (!this.jugadores.remove(a)) {
			throw new EquipoException("No se ha podido borrar al jugador");
		}
	}
	
	public T pertenece (T a) {
		if (this.jugadores.contains(a)) {
			return a;
		}
		else {
			return null;
		}
	}
	
	public T pertenece2 (T a) {
				
		for (T x : this.jugadores) {
			if (x != null && x.equals(a)) {
				return x;
			}
		}
		
		return null;
	}
	
	public T pertenece3 (T a) {
		T x = null;
		Iterator<T> it = this.jugadores.iterator();
		
		T buscado = null;
		while (it.hasNext() && x == null) {
			buscado = it.next();
			if (buscado != null && buscado.equals(a)) {
				x = buscado;
			}
		}
		
		return x;
	}
	
	public void muestraEquipo() {
		for (T x : this.jugadores) {
			System.out.println(x);
		}
	}
	
	public EquipoGenerico<T> union(EquipoGenerico<? extends T> e) {
		this.jugadores.addAll(e.getJugadores());
		return this;
	}
	
	public EquipoGenerico<T> union2(EquipoGenerico<? extends T> e) {
		for (T a : e.getJugadores()) {
			this.jugadores.add(a);
		}
		
		return this;
	}
	
	public EquipoGenerico<T> interseccion(EquipoGenerico<? extends T> e) {
		this.jugadores.retainAll(e.getJugadores());
		return this;
	}
	
	public EquipoGenerico<T> interseccion2(EquipoGenerico<? extends T> e) {
		Iterator<T> it = this.jugadores.iterator();
		
		while (it.hasNext()) {
			T a = it.next();
			if (!e.getJugadores().contains(a)) {
				it.remove();
			}
		}
		
		return this;
	}
	
}
