package boletin_06b_objetos;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Persona {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int dni;
	private char sexo;
	private float altura;
	private float peso;
	
	public Persona(String nombre, int dia, int mes, int anyo, int dni, char sexo, float altura, float peso) 
			throws ParametroInvalidoException {
		super();
		this.nombre = nombre;
		this.setFechaNacimiento(dia, mes, anyo);
		this.dni = dni;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	/**
	 * 
	 * @return
	 */
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	private void setFechaNacimiento(int dia, int mes, int anyo) throws ParametroInvalidoException {
		try {
			LocalDate fecha = LocalDate.of(anyo, mes, dia);
			
			if (fecha.isAfter(LocalDate.now())) {
				throw new ParametroInvalidoException("La fecha debe ser igual o menor al día de hoy");
			}
			
			this.fechaNacimiento = fecha;
		}
		catch (DateTimeException ex) {
			throw new ParametroInvalidoException("La fecha no es correcta");
		}
		
		
	}
	
	public int getDni() {
		return dni;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	/**
	 * Calcula la letra asociada a un número de DNI
	 * @param dni
	 * @return la letra asociada al número
	 */
	public char calculaLetraDni() {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		int resto = this.dni % 23;
		
		return letras.charAt(resto);
	}
	
	public float getIMC() {
		return this.peso / (float) (Math.pow(this.altura, 2));
	}
}
