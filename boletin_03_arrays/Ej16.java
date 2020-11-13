package boletin_03_arrays;

import java.util.Scanner;

public class Ej16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		// Declaramos la matriz
		int[][] tabla;
				
		System.out.print("Escribe el número de tablas de multiplicar: ");
		n = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		// Ahora que sabemos el valor de n, inicializamos
		tabla = new int[n][10];
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				tabla[i][j] = (i+1) * (j+1);
			}
		}
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				System.out.printf("%4d", tabla[i][j]);
			}
			System.out.println();
		}
	}

}
