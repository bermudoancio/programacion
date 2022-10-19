package boletin_03_java;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, interiorRaiz;
		int numSoluciones = 0;
		
		System.out.println("Introduce el coeficiente A");
		a = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el coeficiente B");
		b = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el coeficiente C");
		c = Integer.parseInt(sc.nextLine());
		
		
		interiorRaiz = b * b - 4 * a * c;
		
		if (interiorRaiz > 0) {
			numSoluciones = 2;
		}
		else if (interiorRaiz == 0) {
			numSoluciones = 1;
		}
		
		System.out.printf("La ecuación %dx^2 + %dx + %d = 0 tiene %d soluciones", a, b, c, numSoluciones);

	}

}
