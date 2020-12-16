package boletin_07_string;

import java.util.Scanner;

public class Ej6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase");
		
		String frase = sc.nextLine().toLowerCase();
		sc.close();
		
		StringBuilder sb = new StringBuilder(5);
		
		for (int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				if (sb.toString().indexOf(c) == -1) {
					sb.append(c);
				}
			}
		}
		
		String vocales = "aeiou";
		int contador = 0;
		
		for (int i = 0; i < vocales.length(); i++) {
			if (frase.indexOf(vocales.charAt(i)) != -1) {
				contador++;
			}
		}
		
		//System.out.printf("La frase contiene %d vocales distintas", sb.length());
		System.out.printf("La frase contiene %d vocales distintas", contador);

	}

}
