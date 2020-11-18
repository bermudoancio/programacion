package boletin_04_matrices;

public class Ej8 {

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
		
		imprimeMatriz(sumaMatrices(m1, m2));
		
	}
	
	/**
	 * Suma 2 matrices, comprobando antes que tienen el mismo tamaño.
	 * @param m1 matriz bidimensional
	 * @param m2 matriz bidimensional
	 * @return una nueva matriz con la suma de los valores de m1 y m2. Una matriz vacía del tamaño de m1 en caso de que las matrices no tengan el mismo tamaño
	 */
	public static int[][] sumaMatrices(int[][] m1, int[][] m2){
		
		/*
		 * Inicializamos resultado con el tamaño de m1. Si todo es correcto,
		 * las 2 matrices deben tener el mismo tamaño. Si no, se devuelve todo a 0.
		 */
		int[][] resultado = new int[m1.length][m1[0].length];
		/*
		 * Primero comprobamos que sean del mismo tamaño. 
		 * Podemos suponer que todas las filas tienen el mismo número de columnas,
		 * o comprobar el nº de columnas fila por fila. 
		 * Tal y como hemos comentado en clase, nosotros supondremos que todas
		 * las filas tienen el mismo número de columna.
		 */
		if (m1.length == m2.length) {
			// Si llega aquí, las matrices tienen el mismo número de filas
			if (m1[0].length == m2[0].length) {
				/*
				 * La primera fila tiene el mismo número de columnas.
				 * Para nosotros, esto significa que las matrices ya son del mismo tamaño.
				 * Ahora, sumaremos los valores de cada posición y lo guardaremos
				 * en la misma posición de la matriz resultado
				 */
				for (int i = 0; i < m1.length; i++) {
					for (int j = 0; j < m1[0].length; j++) {
						resultado[i][j] = m1[i][j] + m2[i][j];
					}
				}
			}
		}
		
		return resultado;
	}
	
	/**
	 * Imprime por consola una matriz de enteros
	 * @param matriz
	 */
	public static void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println();
		}
	}

}
