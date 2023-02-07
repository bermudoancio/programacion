package tema5;


public class Triangulo extends Figura{
	private int base;
	private int altura;
	
	
	public Triangulo(String color, int grosorLinea, int base, int altura) {
		super(color, grosorLinea);
		this.base=base;
		this.altura=altura;
	}


	@Override
	public void colorearInterior() {
		System.out.println("Coloreando el triangulo");
		
	}
	
	public void t() {
		System.out.println("hola");
	}


	@Override
	public double calcularArea() {
		return (base* altura)/2;
	}
	
	public static void main(String[] args) {
		Figura f = new Triangulo("rojo", 0, 3, 4);
		System.out.println(f.calcularArea());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
