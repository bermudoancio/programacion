package tema5;

public class Rectangulo {
	private int lado1, lado2;
	
	public Rectangulo(int l1, int l2) {
		this.lado1 = l1;
		this.lado2 = l2;
	}

	
	public void dibujar() {
		System.out.println("Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + "]");
	}


	public int getLado1() {
		return lado1;
	}


	public int getLado2() {
		return lado2;
	}
	
	
}
