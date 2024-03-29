package tema6;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private int edad;
	private int altura;
	private Coche coche;
	
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
		
		this.coche = new Coche("Coche " + Math.random() * 1010, 
				(int) (Math.random() * 150));
		
	}
	
	public Coche getCoche() {
		return coche;
	}
	@Override
	public String toString() {
		return nombre + " " + edad + " " + altura;
	}
	
}
