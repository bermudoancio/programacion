package boletin_04_matrices;

/**
 * Este ejercicio es una mezcla de los dos anteriores. Para más información 
 * sobre los índices y su transformación, ver la explicación del ejercicio 11.
 * @author Jose
 *
 */
public class Ej13 {

	public static void main(String[] args) {
		int[][] m1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 0},
				{3, 2, 1, 4, 5},
				{9, 5, 8, 6, 7},
				{0, 9, 8, 5, 4}
		};
		
		imprimeMatrices(m1, invierteMatriz(m1));

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
					 * En este caso, cambiaremos tanto la fila por la columna,
					 * como las mismas por su inversa (la inversa de la 0 es la 
					 * última, la inversa de la segunda es la penúltima...). Es decir, 
					 * por cada fila que sumamos, restamos una columna a su inversa, y por 
					 * cada columna que sumamos, restamos una fila. Ejemplo:
					 * Dada una matriz de 3x3. 
					 * La primera posición (esquina superior izquierda) 
					 * sería [0,0]. La inversa a la misma sería la esquina 
					 * inferior derecha [2,2]. La inversa a la posición [0,1]
					 * (nota que hemos avanzado una columna), sería la [1,2]
					 * (nota que hemos restado una fila). Mira el ejemplo siguiente:
					 * 
					 *   1  2  3  4  5       4  7  5  0  5 
					 *	 6  7  8  9  0       5  6  4  9  4 
					 *	 3  2  1  4  5       8  8  1  8  3 
					 *	 9  5  8  6  7       9  5  2  7  2 
					 *	 0  9  8  5  4       0  9  3  6  1
					 * 
					 */
					invertida[i][j] = m[m.length - 1 - j][m.length - 1 - i];
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
	
	/**
	 * Imprime dos matrices del mismo tamaño una al lado de la otra, para
	 * facilitar su visualización
	 * @param m1
	 * @param m2
	 */
	public static void imprimeMatrices(int[][] m1, int[][] m2) {
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				System.out.printf("%2d ", m1[i][j]);
			}
			/*
			 * Hemos impreso la primera matriz, daremos ahora 5 espacios
			 * y luego imprimiremos la segunda 
			 */
			System.out.print("     ");
			for (int j = 0; j < m2[i].length; j++) {
				System.out.printf("%2d ", m2[i][j]);
			}
			
			// Y luego pasaremos a la fila siguiente
			System.out.println();
		}
	}

}
