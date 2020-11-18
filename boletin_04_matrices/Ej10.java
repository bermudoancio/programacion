package boletin_04_matrices;

public class Ej10 {

	public static void main(String[] args) {
		int[][] m = {
				{1,3,3,1},
				{4,2,2,4},
				{4,2,2,4},
				{1,3,3,1}
		};
		
		System.out.println("El resultado es " + esSimetrica(m));
	}
	
	public static boolean esSimetrica(int[][] matriz) {
		boolean esSimetrica = true;
		
		for (int j = 0; j < matriz[0].length/2 && esSimetrica; j++) {
			for (int i = 0; i < matriz.length && esSimetrica; i++) {
				if (matriz[i][j] != matriz[i][matriz[0].length - 1 - j]) {
					esSimetrica = false;
				}
			}
		}
		
		return esSimetrica;
	}

}
