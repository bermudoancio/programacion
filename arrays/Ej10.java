package arrays;

public class Ej10 {

	public static void main(String[] args) {
		// {1,3,1,5,4,3,7}
		// {1,3,5,4,7}
		int[] elementosDuplicados = {1,3,1,5,4,3,7};
		//					�		{1,3}
		
		imprimeArray(elementosDuplicados);
		
		//llamada a m�todo que elimina los duplicados
		
	}
	
	public static int[] eliminaDuplicados(int[] unArray) {
		int[] arraySinDuplicados;
		arraySinDuplicados = new int[unArray.length];
		
		for (int i = 0; i < unArray.length; i++) {
			//El elemento que ocupa la posici�n i de unArray, �est� ya en arraySinDuplicados?
			//Si no est�, lo a�ado a arraySinDuplicados
			//Si est�, no hago nada
			if (contieneElemento(arraySinDuplicados, unArray[i])) {
				
			}
		}
		
		return arraySinDuplicados;
	}
	
	public static boolean contieneElemento(int[] array, int elemento) {
		return false;
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
