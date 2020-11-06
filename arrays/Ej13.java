package arrays;

public class Ej13 {

	private static int tamPila = 0;
	private static int[] pila = new int[10];
	
	public static void main(String[] args) {
		
		apilar(3);
		apilar(13);
		apilar(0);
		apilar(2);
		apilar(5);		
		desapilar();
		apilar(2);
		apilar(5);
		apilar(2);
		apilar(5);
		apilar(2);
		apilar(5);
		apilar(3); //Debería de decir que la pila está llena
		desapilar();
		apilar(11);
		
	}
	
	public static void apilar(int numero) {
		
		imprimeArray(pila);
	}
	
	public static void desapilar() {
		
		System.out.println("Desapilar");
		imprimeArray(pila);
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
