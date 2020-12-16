package boletin_07_string;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		String frase;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la frase:");
		frase = sc.nextLine();
		sc.close();
				
		System.out.printf("La frase %s %s", frase, esPalindromo(frase) ? "es un palíndromo" : "no es un palíndromo");
	}
	
	public static boolean esPalindromo(String frase) {
		StringBuilder sb = new StringBuilder(frase);
		boolean esPalindromo = false;
		
		//Vamos a borrar los espacios
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				sb.delete(i, i+1);
				i--;
			}
		}
		
		/*for (int i = 1; i < sb.length(); i++) {
			while (sb.charAt(i-1) == ' ' && i < sb.length()) {
				sb.delete(i-1, i);
			}
		}*/
		
		if (sb.toString().equals(sb.reverse().toString())) {
			esPalindromo = true;
		}
		
		return esPalindromo;
	}

}
