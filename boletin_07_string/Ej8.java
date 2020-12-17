package boletin_07_string;

import java.util.Scanner;

public class Ej8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase");
		
		// Elimino los espacios iniciales y finales
		String frase = sc.nextLine();
		sc.close();
		
		System.out.println("En la frase hay " + cuentaPalabras(frase) + " palabras");

	}
	
	public static int cuentaPalabras(String frase) {
		return frase.trim().split("\s+").length;
	}

}
