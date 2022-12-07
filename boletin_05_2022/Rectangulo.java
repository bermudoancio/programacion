package boletin_05_2022;

import java.util.Scanner;

public class Rectangulo {
	
	private int longitud, anchura;
	
	public Rectangulo(int longitud, int anchura) {
		setAnchura(anchura);
		setLongitud(longitud);
	}
	
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		if (longitud > 0 && longitud <= 20) {
			this.longitud = longitud;
		}
	}

	public void setAnchura(int anchura) {
		if (anchura > 0 && anchura <= 20) {
			this.anchura = anchura;
		}
		else {
			if (anchura < 0) {
				this.anchura = 0;
			}
			else {
				this.anchura = 20;
			}
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la longitud: ");
		int longitud = Integer.parseInt(sc.nextLine());
		System.out.print("Introduce la anchura: ");
		int anchura = Integer.parseInt(sc.nextLine());
		
		Rectangulo r = new Rectangulo(longitud, anchura);
		
		System.out.println("Perímetro: " + r.perimetro());
		System.out.println("Área: " + r.area());
	}

	public int getAnchura() {
		return anchura;
	}
	
	public int perimetro() {
		return this.anchura * 2 + this.longitud * 2;
	}
	
	public int area() {
		return this.anchura * this.longitud;
	}

}
