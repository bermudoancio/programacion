package boletin_04_matrices;

public class Ej11 {

	public static void main(String[] args) {
		int[][] m1 = {
				{5,8,9,0},
				{4,7,5,2},
				{1,7,3,2}
		};
		
		int[][] m2 = {
				{2,3,7,1},
				{2,5,7,4},
				{0,9,8,5}
		};
		
		System.out.println("�Son matrices inversas?: "+ sonInversas(m1, m2));
	}
	
	public static boolean sonInversas(int[][] m1, int[][] m2) {
		// Supondremos que son inversas hasta que descubramos lo contrario
		boolean sonInversas = true;
		
		/*
		 * Para que exista la posibilidad de que sean matrices inversas, la matriz m1 tiene que
		 * tener el mismo n�mero de filas y columnas que m2.
		 */
		if(m1.length != m2.length || m1[0].length != m2[0].length) {
			// No cumple las condiciones para ser su inversa
			sonInversas = false;
		}
		
		/*
		 * Aqu� jugaremos con los �ndices.
		 * Describiremos el inverso de un �ndice como el mismo �ndice empezando desde el final.
		 * Por tanto, en una matriz de 7 filas y 6 columnas (donde la �ltima posici�n es la 
		 * fila 6, columna 5), la posici�n inversa de la [0,0] ser� la esquina opuesta, [6,5].
		 * la inversa de la posici�n [0,5] ser� la [6,0]. La de la [1,2] ser� la [5,3].
		 * Podemos ver aqu� que hay una correlaci�n entre los �ndices de la casilla "principal"
		 * con su casilla "inversa" y el tama�o de la matriz. Si avanzamos un �ndice en la fila
		 * de la casilla principal, hemos de restarlo de su inversa. Si avanzamos un �ndice en
		 * la columna de la casilla principal, hemos de restarlo de su inversa.
		 * Por tanto, en una matriz de n filas y m columnas, la inversa de una fila i ser�:
		 * 		inversaI = matriz.length - 1 - i.
		 * Del mismo modo, la inversa de una columna ser�:
		 * 		inversaJ = matriz[0].length - 1 - j.
		 * 
		 * Donde matriz.length - 1 representa a la �ltima fila, y 
		 * matriz[0].length - 1 representa a la �ltima columna (suponiendo que todas las filas
		 * tienen el mismo n�mero de columnas).
		 * 
		 * Adem�s, tenemos que tener en cuenta que el �ndice de las columnas en m1 ser� en 
		 * realidad, el �ndice de las filas en m2, y el �ndice de las filas en m1 ser� el 
		 * �ndice de las columnas en m2.
		 */
		
		/*
		 * Nota: estos bucles anidados se pueden hacer m�s eficientes, pues podemos parar justo 
		 * cuando hayamos recorrido la mitad de los elementos de las matrices (imaginate la
		 * mitad exacta de la matriz), pues, como estamos haciendo la comprobaci�n de los 
		 * inversos, ya habremos comprobado dichas posiciones. Si sigui�ramos (como se sigue
		 * en esta implementaci�n), comprobar�amos 2 veces todas las posiciones de la matriz.
		 * Por ejemplo, comprobar que la posici�n [0][0] y [3][3] tienen el mismo valor es
		 * lo mismo que comprobar que la posici�n [3][3] y [0][0] tambi�n lo tienen.
		 * Se deja al alumno la implementaci�n de dicha funcionalidad.
		 */
		int i = 0;
		while (i < m1.length && sonInversas) {
			int j = 0;
			
			while (j < m1[0].length && sonInversas) {
				/*
				 * Si las posiciones inversas tienen valores distintos, significa que no
				 * son matrices inversas 
				 */
				
				if (m1[i][j] != m2[m2.length - 1 - i][m2[0].length - 1 - j]) {
					sonInversas = false;
				}
				// Incrementamos j
				j++;
			}
			// Incrementamos i
			i++;
		}
		
		return sonInversas;
	}

}
