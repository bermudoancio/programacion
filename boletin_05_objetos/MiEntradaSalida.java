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

	public static <T> T leerEnum(T[]){
		int opcionElegida = 0;

		do {
			for (int i = 0; i < opciones.length; i++) {
				System.out.printf("%d = %s \n", i + 1, opciones[i]);
			}
			System.out.println(mensaje);
			opcionElegida = Integer.parseInt(sc.nextLine());
		} while (opcionElegida <= 0 || opcionElegida > opciones.length);

		return opciones[opcionElegida - 1];
	}
}
