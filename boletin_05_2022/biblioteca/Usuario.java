package boletin_05_2022.biblioteca;

import java.util.Objects;

public class Usuario {
	private String nombre;
	private String apellido;
	private String dni;
	private String numeroSocio;
	private Libro[] prestamos;
	
	public Usuario(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.prestamos = new Libro[Biblioteca.PRESTAMOS_PERMITIDOS];
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getNumeroSocio() {
		return numeroSocio;
	}
	
	public void setNumeroSocio(String numero) {
		this.numeroSocio = numero;
	}
	
	public int getNumeroLibrosEnPrestamo() {
		int librosEnPrestamo = 0;
		for (int i = 0; i < prestamos.length && prestamos[i] != null; i++) {
			librosEnPrestamo++;
		}
		
		return librosEnPrestamo;
	}
	
	public void prestamo(Libro l) {
		for (int i = 0; i < prestamos.length; i++) {
			if (prestamos[i] == null) {
				prestamos[i] = l;
				l.prestamo();
				break;
			}
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return dni.equals(other.dni);
	}
}
