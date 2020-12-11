package boletin_07_string;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		String frase;
		int contadorMayusculas = 0;
		int contadorMinusculas = 0;
		int contadorNumeros = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la frase o palabra");
		frase = sc.nextLine();
		sc.close();
		
		for (int i = 0; i < frase.length(); i++) {
			if (Character.isDigit(frase.charAt(i))) {
				contadorNumeros++;
			}
			else if (Character.isUpperCase(frase.charAt(i))) {
				contadorMayusculas++;
			}
			else if (Character.isLowerCase(frase.charAt(i))) {
				contadorMinusculas++;
			}
		}
		
		System.out.printf("En la frase %s hay %d mayúsculas, %d minúsculas y %d dígitos", 
				frase, contadorMayusculas, contadorMinusculas, contadorNumeros);
	}

}
