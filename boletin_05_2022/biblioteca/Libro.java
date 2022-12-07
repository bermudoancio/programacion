package boletin_05_2022.biblioteca;

import java.util.Objects;

public class Libro {
	private String nombre;
	private String autor;
	private String sinopsis;
	private int numeroEjemplares;
	private int ejemplaresDisponibles;
	
	public Libro(String nombre, String autor, String sinopsis, int numeroEjemplares) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.numeroEjemplares = numeroEjemplares;
		this.ejemplaresDisponibles = numeroEjemplares;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}
	
	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}

	public void addEjemplares(int numeroEjemplares) throws BibliotecaException {
		if (numeroEjemplares > 0) {
			this.numeroEjemplares += numeroEjemplares;
			this.ejemplaresDisponibles += numeroEjemplares;
		}
		else {
			throw new BibliotecaException("No puedes añadir un número negativo de ejemplares");
		}
	}
	
	public void prestamo() {
		this.ejemplaresDisponibles--;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, nombre, numeroEjemplares, sinopsis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return autor.equals(other.autor) && nombre.equals(other.nombre);
	}
}
