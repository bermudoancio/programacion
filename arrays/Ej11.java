package arrays;

public class Ej11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] elementosEnComun(int[] array1, int[] array2) {
		int[] arrayComun;
		int[] arrayPeq;
		
		int tamMenor = array2.length;
		arrayPeq = array2;
		
		if (array1.length < array2.length) {
			tamMenor = array1.length;
			arrayPeq = array1;
		}
		
		arrayComun = new int[tamMenor];
		
		for (int i = 0; i < arrayComun.length; i++) {
			
		}
		
		return arrayComun;
	}

}
