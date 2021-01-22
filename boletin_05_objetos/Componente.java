package boletin_05_objetos;

import java.time.LocalDate;

public class Componente {
	private String nombre;
	private String instrumento;
	private final LocalDate fechaNacimiento;
	
	public Componente(String nombre, String instrumento, LocalDate fn) {
		this.setNombre(nombre);
		this.setInstrumento(instrumento);
		
		if (fn.isBefore(LocalDate.now())) { 
			this.fechaNacimiento = fn;
		}
		else {
			this.fechaNacimiento = LocalDate.now();
		}
			
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the instrumento
	 */
	public String getInstrumento() {
		return instrumento;
	}
	
	/**
	 * @param instrumento the instrumento to set
	 */
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	
	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
		
	
}
