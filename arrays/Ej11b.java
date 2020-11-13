package boletin_03_arrays

public class Ej11b {

	public static void main(String[] args) {
		int[] miArray1 = {1,2,3,4};
		int[] miArray2 = {2,5,4};
	}
	
	public static int[] elementosEnComun(int[] array1, int[] array2) {
		int[] arrayComun;
		int tamPeq = array1.length;
		
		if (array1.length > array2.length) {
			tamPeq = array2.length;
		}
		
		arrayComun = new int[tamPeq];
				
		for (int i = 0; i < array1.length; i++) {
			
		}
		
		return arrayComun;
	}
	
	public static boolean contieneElemento(int[] array, int elemento) {
		boolean encontrado = false;
		
		for(int i = 0; i < array.length && !encontrado; i++) {
			if(array[i] == elemento) {
				encontrado = true;
			}
		}
		return encontrado;
	}

}
