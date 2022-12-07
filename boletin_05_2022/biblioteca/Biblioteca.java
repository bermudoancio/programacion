package boletin_05_2022.biblioteca;

public class Biblioteca {
	public static final int PRESTAMOS_PERMITIDOS = 2;	
	private final int CAPACIDAD_LIBROS = 2;
	private final int CAPACIDAD_USUARIOS = 2;
	
	private String nombre;
	private Libro[] estanteria;
	private Usuario[] socios;
	private int numeroLibros;
	private int numeroSocios;
	
	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.numeroLibros = 0;
		this.numeroSocios = 0;
		this.estanteria = new Libro[CAPACIDAD_LIBROS];
		this.socios = new Usuario[CAPACIDAD_USUARIOS];
	}

	public String getNombre() {
		return nombre;
	}
	
	public void addLibro(Libro nuevoLibro) throws BibliotecaException {
		boolean libroEncontrado = false;
		
		for (int i = 0; i < estanteria.length && !libroEncontrado; i++) {
			if (nuevoLibro.equals(estanteria[i])) {
				libroEncontrado = true;
				estanteria[i].addEjemplares(nuevoLibro.getNumeroEjemplares());
			}
		}
		if (!libroEncontrado) {
			if (this.numeroLibros < CAPACIDAD_LIBROS) {
				estanteria[this.numeroLibros++] = nuevoLibro;
			}
			else {
				
				throw new BibliotecaException("No puedes añadir más libros. Estantería llena");
			}
		}
		
		
	}
	
	public void addSocio(Usuario u) throws BibliotecaException {
		if (!esSocio(u)) {
			if (numeroSocios < CAPACIDAD_USUARIOS) {
				u.setNumeroSocio("" + numeroSocios);
				socios[numeroSocios++] = u;
			}
			else {
				throw new BibliotecaException("Lo siento, no caben más socios");
			}
		}
		else {
			throw new BibliotecaException("El usuario indicado ya es socio");
		}
		
	}
	
	/**
	 * Realiza el préstamo de un libro teniendo en cuenta que:
	 * - El usuario sea socio
	 * - Haya ejemplares disponibles del libro seleccionado
	 * - El usuario no tenga más del límite de libros en préstamo actualmente
	 * 
	 * @param u
	 * @param l
	 * @throws BibliotecaException
	 */
	public void prestamo(Usuario u, Libro l) throws BibliotecaException {
		if (!esSocio(u)) {
			throw new BibliotecaException("El usuario no es socio de la biblioteca");
		}
		
		if (l.getEjemplaresDisponibles() <= 0) {
			throw new BibliotecaException("No quedan ejemplares disponibles del libro");
		}
		
		if (u.getNumeroLibrosEnPrestamo() >= PRESTAMOS_PERMITIDOS) {
			throw new BibliotecaException("El usuario no puede retirar más libros.");
		}
		
		u.prestamo(l);
		
	}
	
	public boolean esSocio(Usuario u) {
		return u.getNumeroSocio() != null;
	}
}
