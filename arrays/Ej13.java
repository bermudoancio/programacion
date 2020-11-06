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
		
		for (int i = 0; i < 11; i++) {
			desapilar();
		}
		
	}
	
	public static void apilar(int numero) {
		
		if (tamPila < pila.length) {
			pila[tamPila++] = numero;
			System.out.println("Apilo el número " + numero);
		}
		else {
			System.out.println("La pila está llena. No puedo apilar el elemento");
		}
		
		imprimeArray(pila);
	}
	
	public static void desapilar() {
		System.out.println("Desapilar");
		
		if (tamPila > 0) {
			tamPila--;
		}
		else {
			System.out.println("No hay elementos en la pila");
		}
		
		imprimeArray(pila);
	}
	
	public static void imprimeArray(int[] array) {
		for (int i = 0; i < tamPila; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println("");
	}

}
