package boletin_04_matrices;

import java.util.Scanner;

public class Ej15 {
	public static void main(String[] args) {
		/*
		 * En este ejercicio, aunque parezca raro, no necesitamos
		 * ninguna matriz.
		 * El c�lculo de la posici�n que ocupa una casilla es, en 
		 * realidad, trivial.
		 * Para saberlo, simplemente multiplicaremos las columnas 
		 * que hay en una fila, por la fila de la columna de la 
		 * casilla objetivo, y luego, le sumaremos la posici�n de
		 * la columna que ocupa dicha casilla:
		 * 
		 * Ejemplo: matriz de 4x7. En cada fila hay 7 columnas. 
		 * Por tanto, si quisi�semos saber la posici�n que ocupa
		 * la casilla [2,5], tan solo tenemos que multiplicar la
		 * fila que nos piden (que casualmente es el n�mero de filas
		 * completas que hemos "saltado" por el n�mero de columnas
		 * que tiene cada fila. Suponiendo como siempre matrices
		 * regulares, con el mismo n�mero de columnas en cada fila,
		 * tendr�amos por ahora 2x7 = 14 casillas antes de la primera
		 * de esta fila. Ahora, sumaremos la columna de la casilla
		 * en cuesti�n 14 + 5 = 19. A este n�mero, tendremos que 
		 * sumarle 1, dado que el �ndice de la columna (al igual
		 * que el de la fila) comienza en 0. Por tanto, en este 
		 * ejempo, la casilla [2,5] ocupa la posici�n 20.
		 * 
		 *	 1  2  3  4  5    6   7
		 *	 8  9 10 11 12   13  14
		 *	15 16 17 18 10  *20* 21 
		 *	22 23 24 25 26   27  28
		 * 
		 */
		int[][] matriz = {
				{1,  2,  3,   4,  5,  6}, 
				{7,  8,  9,  10, 11, 12}, 
				{13, 14, 15, 16, 17, 18}, 
				{19, 20, 21, 25, 23, 24}, 
				{25, 26, 27, 28, 29, 30} 
		};
		Scanner sc = new Scanner(System.in);
		
		int fila;
		do {
			System.out.printf("Introduce la fila empezando en 0 (la matriz tiene %d filas): ", matriz.length);
			fila = sc.nextInt();
		} while (fila < 0 || fila >= matriz.length);
		
		int columna;
		do {
			System.out.printf("Introduce la columna empezando en 0 (la matriz tiene %d columnas): ", matriz[0].length);
			columna = sc.nextInt();
		} while (columna < 0 || columna >= matriz[0].length);
		sc.close();
		
		System.out.printf("La casilla [%d,%d] ocupa la posici�n %d", fila, columna, (fila * matriz[0].length) + columna + 1);
		
	}
}
