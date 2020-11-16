package boletin_04_matrices;

public class Ej2 {
	public static void main(String[] args) {
		int[][] matriz = {
				{1,3,4,5},
				{45,22,1,90},
				{123,8,97,62}
		};
		
		int suma = sumaMatriz(matriz);
		
		System.out.println("La suma de la matriz es " + suma);
	}
	
	public static int sumaMatriz(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j =0; j< matriz[i].length; j++) {
				suma += matriz[i][j];
			}
		}
		
		return suma;
	}
}
