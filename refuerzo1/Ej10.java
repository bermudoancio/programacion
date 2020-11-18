package refuerzo1;

import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la altura del árbol");
		int alturaArbol = Integer.parseInt(sc.nextLine());
		int contador = 0;
		
		// En cada altura del árbol, comenzando por la punta:
		for (int i = 1; i <= alturaArbol; i++) {
			/*
			 * Pintaremos tantos espacios como resulten de restar a la altura,
			 * el nivel que estamos pintando. Por tanto, para una altura de 5,
			 * en el nivel 1 pintaremos (5-1) espacios, para el nivel 2 (5-2) 
			 * espacios, etc.
			 * 
			 * Posteriormente, toca pintar los asteriscos. En cada nivel,
			 * pintaremos exactamente el número de esteriscos indicados por el
			 * nivel en el que estemos: en el primer nivel pintaremos 1 asterisco,
			 * en el segundo 2, etc. Pintaremos los asteriscos seguidos de un espacio
			 * para que coja la forma deseada.
			 */
			for (int espacios = 0; espacios < alturaArbol - i; espacios++) {
				System.out.print(" ");
			}
			
			for (int asteriscos = 0; asteriscos < i; asteriscos++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
