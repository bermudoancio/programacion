package boletin_04_matrices;

public class Ej12 {

	public static void main(String[] args) {
		int[][] m1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 0},
				{3, 2, 1, 4, 5},
				{9, 5, 8, 6, 7},
				{0, 9, 8, 5, 4}
		};
		
		imprimeMatriz(invierteMatriz(m1));

	}
	
	public static int[][] invierteMatriz(int[][] m){
		int[][] invertida = new int[m.length][m[0].length];
		
		/*
		 * Primero comprobaremos que la matriz es cuadrada
		 */
		if(m.length == m[0].length) {
			// Al tener el mismo nº de filas que de columnas, es cuadrada
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					/*
					 * Recorremos todas las posiciones y cambiamos sus índices
					 * i por j. Ej: la posición [1][0] va a ir a la [0][1],
					 * la [2][4] a la [4][2], etc.
					 */
					invertida[i][j] = m[j][i];
				}
			}
		}
		else {
			System.out.println("No se invierte la matriz por no ser cuadrada");
		}
		
		return invertida;
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
