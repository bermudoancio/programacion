package boletin_04_matrices;

public class Ej4 {

	public static void main(String[] args) {
		int[][] matriz = {
				{1,3,4,5},
				{45,22,1,90},
				{123,8,97,62}
		};
		
		muestraPorFilasInversa(matriz);
	}
	
	public static void muestraPorFilasInversa(int[][] matriz) {
		for (int i = matriz.length - 1; i >= 0; i--) {
			for (int j = matriz[i].length - 1; j >=0; j--) {
				System.out.printf("%3d ", matriz[i][j]);
			}
		}
		System.out.println();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%3d ", matriz[matriz.length - 1 - i][matriz[0].length - 1 - j]);
			}
		}
	}

}