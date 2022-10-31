package boletin_03_arrays;

public class Ej08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4};
		int posicion = encuentraPosicion(array, 5);
		
		if (posicion == -1) {
			System.out.println("El elemento no se encuentra en el array");
		}
		else {
			System.out.printf("El elemento se encuentra en la posición %d", posicion);
		}
		
	}
	
	private static int encuentraPosicion(int[] array, int elemento) {
		int pos = -1;
		for (int j = 0; j < array.length; j++) {
			if (array[j] == elemento) {
				pos = j;
			}
		}
		
		return pos;
	}

}
