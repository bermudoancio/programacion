package boletin_03_java;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		int numA, numB;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un número positivo");
			numA = Integer.parseInt(sc.nextLine());
		} while (numA < 0);
		
		do {
			System.out.println("Introduce otro número positivo");
			numB = Integer.parseInt(sc.nextLine());
		} while (numB < 0);
		
		// Hacemos que A siempre sea >= que B
		if (numA < numB) {
			int t = numA;
			numA = numB;
			numB = t;
		}
		
		int resto = numA % numB;
		
		while (resto != 0) {
			numA = numB;
			numB = resto;
			resto = numA % numB;
		}

		System.out.println("El MCD es " + numB);

	}

}
