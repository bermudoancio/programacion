package boletin_04_matrices;

public class Ej5 {

	public static void main(String[] args) {
		int[][] matriz = {
				{1,3,4,5},
				{45,22,1,90},
				{123,8,97,62}
		};
		
		muestraPorColumnas(matriz);
	}
	
	public static void muestraPorColumnas(int[][] matriz) {
		for (int j = 0; j < matriz[0].length; j++) {
			for (int i = 0; i < matriz.length; i++) {
				System.out.printf("%d ", matriz[i][j]);
			}
		}
	}

}
