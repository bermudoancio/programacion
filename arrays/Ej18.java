package boletin_03_arrays

public class Ej18 {

	public static void main(String[] args) {
		char[][] matrizNormal = {
				{'a', 'b', 'c', 'd'},
				{'f', 'g', 'h', 'i'},
				{'j', 'k', 'l', 'm'},
				{'n', 'ñ', 'o', 'p'}
		};
		
		char[][] matrizEspejo = invierteMatriz(matrizNormal);
		
		for (int i = 0; i < matrizEspejo.length; i++) {
			for (int j = 0; j < matrizEspejo[0].length; j++) {
				System.out.printf("%4c", matrizEspejo[i][j]);
			}
			System.out.println();
		}
	}
	
	public static char[][] invierteMatriz(char[][] matriz){
		char[][] matrizInvertida = new char[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matrizInvertida[matriz.length - 1 - i][matriz[i].length - 1 - j] = matriz[i][j];
			}
		}
		
		return matrizInvertida;
	}

}
