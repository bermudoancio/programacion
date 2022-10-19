package boletin_03_java_22;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * IMPORTANTE: Esta solución no funciona con números que
		 * terminan en 0, pues rellena con 0s a la izquierda
		 */
		
		System.out.println("Introduce un número entero positivo");
		int num = Integer.parseInt(sc.nextLine());
		int numOriginal = num;
		int resultado = 0;
		
		while (num != 0) {
			resultado = resultado * 10 + num % 10;
			num = num / 10;
		}
		
		if (numOriginal == resultado) {
			System.out.println("El número es capicúa");
		}
		else {
			System.out.println("El número no es capicúa");
		}

	}

}
