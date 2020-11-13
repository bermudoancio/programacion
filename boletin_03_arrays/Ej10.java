package boletin_03_arrays;

public class Ej10 {

	public static void main(String[] args) {
		// {1,3,1,5,4,3,7}
		// {1,3,5,4,7}
		int[] elementosDuplicados = {1,3,1,5,4,3,7,8,5,12,1,7,6,-1};
		//					�		{1,3,,5,4,,7}
		
		imprimeArray(elementosDuplicados);
		
		//llamada a m�todo que elimina los duplicados
		int[] otroArray = eliminaDuplicados(elementosDuplicados);
		imprimeArray(otroArray);
		
	}
	
	public static int[] eliminaDuplicados(int[] unArray) {
		int[] arraySinDuplicados;
		int[] arrayFinal;
		arraySinDuplicados = new int[unArray.length];
		
		int elementosEnNuevoArray = 0;
		
		for (int i = 0; i < unArray.length; i++) {
			//El elemento que ocupa la posici�n i de unArray, �est� ya en arraySinDuplicados?
			//Si no est�, lo a�ado a arraySinDuplicados
			//Si est�, no hago nada
			if (!contieneElemento(arraySinDuplicados, unArray[i])) {
				arraySinDuplicados[elementosEnNuevoArray++] = unArray[i];
			}
		}
		
		arrayFinal = new int[elementosEnNuevoArray];
		
		for (int i = 0; i < arrayFinal.length; i++) {
			arrayFinal[i] = arraySinDuplicados[i];
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
