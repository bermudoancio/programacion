package arrays;

import java.util.Random;
import java.util.Scanner;

public class Ej5 {

	private static int MAX = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// El número de elementos que tendrá el array
		int tam;
		// El array de enteros que contendrá los números aleatorios
		int[] elementos;
		
		System.out.print("¿Cuántas posiciones tiene el array?: ");
		// Leemos el número
		tam = Integer.parseInt(sc.nextLine());
		// Y cerramos el escáner
		sc.close();
		
		// Llamamos al método que generará el array con tam números aleatorios
		elementos = generaNumerosAleatorios(tam);
		
		// Y por último lo pintamos
		for (int i = 0; i < elementos.length; i++) {
			System.out.printf("Elemento %d: %d\n", (i+1), elementos[i]);
		}
	}
	
	/**
	 * Genera un array de enteros de tamaño tam y lo llena de números aleatorios
	 * @param tam el tamaño del array
	 * @return el array con tam números aleatorios 
	 */
	public static int[] generaNumerosAleatorios(int tam) {
		
		// Inicializamos el array con tam elementos
		int[] aleatorios = new int[tam];
		// Creamos el generador de números aleatorios
		Random r = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < aleatorios.length; i++) {			
			// Si dejasemos solo MAX, 1000 no estaría incluido
			aleatorios[i] = r.nextInt(MAX + 1);
		}
		
		return aleatorios;
	}

}
