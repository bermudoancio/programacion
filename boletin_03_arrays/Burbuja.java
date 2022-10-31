package boletin_03_arrays;

public class Burbuja {

	public static void main(String[] args) {
		int[] array = {3, 6, 1, 0, 45, 28, 7};
		
		ordenacionBurbuja2(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.println();

	}
	
	public static int[] ordenacionBurbuja(int[] desordenado) {
		for (int i = 0; i < desordenado.length - 1; i++) {
			for (int j = i + 1; j < desordenado.length; j++) {
				if (desordenado[i] > desordenado[j]) {
					int aux = desordenado[j];
					desordenado[j] = desordenado[i];
					desordenado[i] = aux;
				}
			}
		}
		
		return desordenado;
	}
	
	public static int[] ordenacionBurbuja2(int[] desordenado) {
		for (int i = 0; i < desordenado.length - 1; i++) {
			for (int j = 0; j < desordenado.length -1 -i; j++) {
				if (desordenado[j+1] < desordenado[j]) {
					int aux = desordenado[j];
					desordenado[j] = desordenado[j+1];
					desordenado[j+1] = aux;
				}
			}
		}
		
		return desordenado;
	}

}
