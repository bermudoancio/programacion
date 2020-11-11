package refuerzo1;

import java.util.Scanner;

public class Ej2 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int num = pedirNumero();
		
		System.out.printf("El número %d en binario es %d", num, convertirABinario(num));
	}
	
	public static int convertirABinario(int decimal) {
		int resul = 0;
		int tamDecimal = 1;
		
		while(decimal > 1) {
			resul = resul + (decimal % 2) * tamDecimal;
			decimal = decimal / 2;
			tamDecimal *= 10;
		}
		
		resul += decimal * tamDecimal;
		
		return resul;
	}
	
	public static int convertirABinario1(int decimal) {
		String numBinario = "" + ""; //1 - 1010
		numBinario += "";
		
		while (decimal > 1) {
			numBinario = numBinario + (decimal % 2);
			decimal = decimal / 2;
		}
		
		numBinario = numBinario + decimal;
		
		StringBuilder sb = new StringBuilder();
		sb.append(numBinario);
		
		return Integer.parseInt(sb.reverse().toString());
	}
	
	public static int pedirNumero() {
		System.out.print("Escribe un número: ");
		return Integer.parseInt(sc.nextLine());
	}

}
