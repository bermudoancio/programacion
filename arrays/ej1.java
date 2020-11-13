package boletin_03_arrays

/**
 * Crea un programa que sume todas las posiciones pares de un array de enteros.
 * @author Jose Manuel Bermudo
 *
 */

public class ej1 {

	public static void main(String[] args) {
		
		//Supondremos un array ya creado:
		int[] arrayEnteros = {1,2,3,4,5,6,7,8,9,10};
		
		//Esta variable llevará la suma parcial
		int suma = 0;
		
		for (int i = 0; i < arrayEnteros.length; i=i+2) {
			suma += arrayEnteros[i];
		}
		
		// Otra forma de hacerlo
//		for (int i = 0; i < arrayEnteros.length; i++) {
//			if (i % 2 == 0) {
//				suma += arrayEnteros[i];
//			}
//		}
		
		System.out.println("La suma de las posiciones pares del array es " + suma);

	}

}
