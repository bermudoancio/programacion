package boletin_04_matrices;

public class Ej7 {

	public static void main(String[] args) {
		int[][] m1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] m2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		System.out.println("¿Son las matrices iguales?: " + sonIguales(m1, m2));
	}
	
	public static boolean sonIguales(int[][] m1, int[][] m2) {
		boolean sonIguales = true;
		// Primero vamos a comprobar si el tamaño es igual
		// ¿Tienen el mismo número de filas?
		if (m1.length == m2.length) {
			for (int i = 0; i < m1.length && sonIguales; i++) {
				// Comprobamos ahora que cada fila tiene el mismo número de columnas
				if (m1[i].length == m2[i].length) {
					/*
					 * Ahora comprobaremos si cada elemento de cada columna
					 * es igual en las dos matrices.
					 * Añadiremos la condicion de sonIguales a la de parada del 
					 * bucle. Así conseguiremos que si un elemento no es igual
					 * no se recorran los demás elementos inútilmente
					 */
					
					for (int j = 0; j < m1[i].length && sonIguales; j++) {
						if (m1[i][j] != m2[i][j]) {
							sonIguales = false;
						}
					}
				}
				else {
					sonIguales = false;
				}
			}
		}
		else {
			sonIguales = false;
		}
		
		
		return sonIguales;
	}

}
