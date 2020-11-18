package boletin_04_matrices;

public class Ej14 {

	public static void main(String[] args) {
		int[][] m1 = {
				{1, 2, 3},
				{6, 7, 8},
				{3, 2, 1},
				{9, 5, 8},
				{0, 9, 8,}
		};
		
		imprimeMatrices(m1, filasPorColumnas(m1));

	}
	
	public static int[][] filasPorColumnas(int[][] m){
		/*
		 * La matriz resultante tendrá tantas filas como
		 * columnas tenga la matriz original, y tantas columnas
		 * como filas tenga la matriz original. Por tanto,
		 * podemos crearla ya
		 */
		int[][] resultado = new int[m[0].length][m.length];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				resultado[j][i] = m[i][j];
			}
		}
		
		return resultado;
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
			 * y luego imprimiremos la segunda.
			 * 
			 *  Puede darse el caso de que la segunda matriz no tenga
			 *  tantas filas como la primera. Si por ejemplo, la primera
			 *  matriz tiene 6 filas y 2 columnas, la resultante tendrá
			 *  2 filas y 6 columnas, y al intentar mostrar la 3ª fila
			 *  de la segunda columna, obtendremos un IndexOutOfBoundsException.
			 *  Por tanto, sólo mostraremos la fila de la segunda si el 
			 *  índice i está dentro de los límites de la 2ª matriz
			 */
			if (i < m2.length) {
				System.out.print("     ");
				for (int j = 0; j < m2[i].length; j++) {
					System.out.printf("%2d ", m2[i][j]);
				}
			}
			// Y luego pasaremos a la fila siguiente
			System.out.println();
		}
	}

}
