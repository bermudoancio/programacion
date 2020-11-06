package refuerzo1;

import java.util.Scanner;

public class Ej3 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int num = pedirNumero();
		
		System.out.printf("El número %d en decimal es %d", num, convertirADecimal(num));

	}
	
	public static int convertirADecimal(int numBinario) {
		int decimal = 0;
		int exponente = 0; //1010
		
		while(numBinario > 0) {
			
			decimal += (int)Math.pow(2, exponente++) * (numBinario % 10);
			
			numBinario /= 10; // numbinario = numbinario / 10;
		}
		
		return decimal;
	}
	
	public static int pedirNumero() {
		System.out.print("Escribe un número: ");
		return Integer.parseInt(sc.nextLine());
	}

}
