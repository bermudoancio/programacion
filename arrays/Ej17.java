package arrays;

public class Ej17 {

	public static void main(String[] args) {
		int[][] a = {{1,2,3}, {8,7,6}}; 
		int[][] b = new int [2][4];
		
		copiaMatriz(a, b);
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.printf("%4d", b[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void copiaMatriz(int a[][], int b[][]) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("No puedo copiar matrices de distinto tamaño");
		}
		else {
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					b[i][j] = a[i][j];
				}
			}
		}
	}

}
