package refuerzo1;

import java.util.Scanner;

public class Ej1 {

	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int num1, num2;
		
		num1 = pedirNumero();
		num2 = pedirNumero();
		
		// Cerramos el teclado. Gracias Alejandro
		sc.close();
		
		System.out.println("La suma de los dos números es " + suma(num1, num2));
	}
	
	public static int suma(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int pedirNumero() {
		System.out.print("Escribe un número: ");
		return Integer.parseInt(sc.nextLine());
	}

}
