package ej1;
import java.time.LocalDate;

public class Persona {

	private String nombre;
	private String DNI;
	private String telefono;
	private LocalDate fechaNacimiento;
	
	
	public Persona(String nombre, String dNI, String telefono, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDNI() {
		return DNI;
	}


	public String getTelefono() {
		return telefono;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
}
