package boletin_04_matrices;

public class Ej1 {

	public static void main(String[] args) {
		
	}
	
	public static boolean hayElementosNegativos(int[][] matriz) {
		boolean hayNegativos = false;
		
		/*
		 * Recorreremos todas las filas y columnas mientras se cumpla:
		 * 	- todavía no hemos recorrido todas las filas y columnas
		 *  - todavía no hemos encontrado números negativos
		 */
		for (int i = 0; i < matriz.length && !hayNegativos; i++) {
			for (int j = 0; j < matriz[i].length && !hayNegativos; j++) {
				if (matriz[i][j] < 0) {
					hayNegativos = true;
				}
			}
		}
		
		return hayNegativos;
	}
	
	public static boolean hayElementosNegativosConWhile(int[][] matriz) {
		boolean hayNegativos = false;
		
		/*
		 * Recorreremos todas las filas y columnas mientras se cumpla:
		 * 	- todavía no hemos recorrido todas las filas y columnas
		 *  - todavía no hemos encontrado números negativos
		 */
		int i = 0;
		while (i < )
		for (int i = 0; i < matriz.length && !hayNegativos; i++) {
			for (int j = 0; j < matriz[i].length && !hayNegativos; j++) {
				if (matriz[i][j] < 0) {
					hayNegativos = true;
				}
			}
		}
		
		return hayNegativos;
	}

}
