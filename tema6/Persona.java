package tema6;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private int edad;
	private int altura;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public int compareTo(Persona o) {
		return nombre.compareTo(o.nombre);
		//return edad - o.edad;
	}
	public Persona(String nombre, int edad, int altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		return nombre + " " + edad + " " + altura;
	}
	
}
