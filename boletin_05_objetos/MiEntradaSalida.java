package boletin_05_objetos;

import java.util.Scanner;

public class MiEntradaSalida {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static double leerDouble(String mensaje) {
		
		double res = 0;
		boolean ok = false;
		
		do {
			System.out.println(mensaje);
			try {
				res = Double.parseDouble(sc.nextLine());
				ok = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Tienes que introducir un número");
			}
			
		} while(!ok);
		
		return res;
	}
}
