package boletin_03_arrays;

public class Ej07 {

	public static void main(String[] args) {
		int[] miArray = {1,2,3,4,5};
		
		if (contieneElemento(miArray, 1)) {
			System.out.println("Sí, lo contiene");
		}
		else {
			System.out.println("No, no lo contiene");
		}

	}
	
	private static boolean contieneElemento(int[] array, int elemento) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elemento) {
				return true;
			}
		}
		
		return false;
	}

}
