package boletin_04_matrices;

public class Ej6 {

	public static void main(String[] args) {
		int[][] matriz = {
				{1,3,4,5},
				{45,22,1,90},
				{123,8,97,62}
		};
		
		muestraPorColumnasInversa(matriz);
	}
	
	public static void muestraPorColumnasInversa(int[][] matriz) {
		for (int j = matriz[0].length - 1; j >=0; j--) {	
			for (int i = matriz.length - 1; i >= 0; i--) {
				System.out.printf("%3d ", matriz[i][j]);
			}
		}
	}

}
