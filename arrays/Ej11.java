package arrays;

public class Ej11 {

	public static void main(String[] args) {
		int[] miArray1 = {1,2,3,4,8,10,3};
		int[] miArray2 = {2,2,0,5,3};
		//	arrayComun = {2}
		
		imprimeArray(miArray1);
		imprimeArray(miArray2);
		
		int[] arrayComunes = elementosEnComun(miArray1, miArray2);
		
		imprimeArray(arrayComunes);
	}
	
	public static int[] elementosEnComun(int[] array1, int[] array2) {
		int[] arrayComun;
		int[] arrayPeq, arrayGrande, arrayFinal;
		int comunes = 0;
		
		arrayPeq = array2;
		arrayGrande = array1;
		
		if (array1.length < array2.length) {
			arrayPeq = array1;
			arrayGrande = array2;
		}
		
		/*
		 * Primero voy a comprobar que el elemento no esté ya en el array de comunes, pues entonces
		 * el elemento ya está comprobado 
		 */
		
		arrayComun = new int[arrayPeq.length];
		
		for (int i = 0; i < arrayPeq.length; i++) {
			if (!contieneElemento(arrayComun, arrayPeq[i])) {
				if (contieneElemento(arrayGrande, arrayPeq[i])) {
					arrayComun[comunes++] = arrayPeq[i];
				}
			}
		}
		
		// Elimino las posiciones no usadas del array comun
		arrayFinal = new int[comunes];
		
		for (int i = 0; i < arrayFinal.length; i++) {
			arrayFinal[i] = arrayComun[i];
		}
		
		return arrayFinal;

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
	
	public static void imprimeArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println("");
	}

}
