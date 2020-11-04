package arrays;

import java.util.Random;
import java.util.Scanner;

public class Ej5 {

	private static int MAX = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// El n�mero de elementos que tendr� el array
		int tam;
		// El array de enteros que contendr� los n�meros aleatorios
		int[] elementos;
		
		System.out.print("�Cu�ntas posiciones tiene el array?: ");
		// Leemos el n�mero
		tam = Integer.parseInt(sc.nextLine());
		// Y cerramos el esc�ner
		sc.close();
		
		// Llamamos al m�todo que generar� el array con tam n�meros aleatorios
		elementos = generaNumerosAleatorios(tam);
		
		// Y por �ltimo lo pintamos
		for (int i = 0; i < elementos.length; i++) {
			System.out.printf("Elemento %d: %d\n", (i+1), elementos[i]);
		}
	}
	
	/**
	 * Genera un array de enteros de tama�o tam y lo llena de n�meros aleatorios
	 * @param tam el tama�o del array
	 * @return el array con tam n�meros aleatorios 
	 */
	public static int[] generaNumerosAleatorios(int tam) {
		
		// Inicializamos el array con tam elementos
		int[] aleatorios = new int[tam];
		// Creamos el generador de n�meros aleatorios
		Random r = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < aleatorios.length; i++) {			
			// Si dejasemos solo MAX, 1000 no estar�a incluido
			aleatorios[i] = r.nextInt(MAX + 1);
		}
		
		return aleatorios;
	}

}
