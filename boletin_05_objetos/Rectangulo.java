package boletin_05_objetos;

public class Rectangulo {
	private int longitud;
	private int anchura;
	
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo();
		r.setAnchura(11);
		r.setLongitud(11);
		
		r.imprimeCuadrado();
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public void setLongitud(int longitud) {
		if (longitud > 0 && longitud < 20) {
			this.longitud = longitud;
		}
	}
	
	public int getAnchura() {
		return anchura;
	}
	
	public void setAnchura(int anchura) {
		if (anchura > 0 && anchura < 20) {
			this.anchura = anchura;
		}
	}
	
	/**
	 * Devuelve el área del rectángulo
	 * @return el área del rectángulo
	 */
	public int getArea() {
		return this.anchura * this.longitud;
	}
	
	/**
	 * Devuelve el perímetro del rectángulo
	 * @return el perímetro del rectángulo
	 */
	public int getPerimetro() {
		return 2 * this.anchura + 2 * this.longitud;
	}
	
	public void imprimeCuadrado() {
		if (this.anchura == this.longitud) {
			for(int i = 0; i < this.longitud; i++) {
				for (int j = 0; j< this.anchura; j++) {
					if (i == 0 || j == 0 || i == this.longitud - 1 || j == this.anchura - 1) {
						System.out.print("* ");
					}
					else if (i == j) {
						System.out.print("* ");
					}
					else if (j == this.anchura - 1 - i) {
						System.out.print("* ");
					}
					else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}
	}
}
