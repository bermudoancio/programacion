package tema8.bbdd;

import java.util.Arrays;
import java.util.Scanner;

public class UserDataCollector {

	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Muestra un mensaje por pantalla y solicita un entero. Repite la operaci�n 
	 * hasta que se introduce un n�mero entero v�lido
	 * @param mensaje El mensaje que se mostrar�
	 * @return el n�mero introducido por el cliente
	 */
	public static int getEntero(String mensaje) {
		System.out.print(mensaje + ": ");
		
		int entero = 0;
		boolean ok = false;
		
		while (!ok) {
			try {
				entero = Integer.parseInt(sc.nextLine());
				ok = true;
			}
			catch (NumberFormatException e) {
				System.out.print("Error. Introduce un n�mero entero: ");
			}
		}
		
		return entero;
	}
	
	/**
	 * Muestra un mensaje por pantalla y solicita un entero comprendido entre min y max.
	 * Repite la operaci�n hasta que se introduce un n�mero entero comprendido entre min y max.
	 * @param mensaje El mensaje que se mostrar�
	 * @param min El m�nimo entero aceptado
	 * @param max El m�ximo entero aceptado
	 * @return el n�mero introducido por el cliente
	 */
	public static int getEnteroMinMax(String mensaje, int min, int max) {
		int enteroIntroducido = UserDataCollector.getEntero(mensaje); 
		while (enteroIntroducido < min || enteroIntroducido > max) {
			System.out.println("Por favor, introduce un n�mero entre " + min + " y " + max);
			enteroIntroducido = UserDataCollector.getEntero(mensaje);
		}
		
		return enteroIntroducido;
	}
	
	public static double getDouble(String mensaje) {
		System.out.print(mensaje + ": ");
		
		double num = 0;
		boolean ok = false;
		
		while (!ok) {
			try {
				num = Double.parseDouble(sc.nextLine());
				ok = true;
			}
			catch (NumberFormatException e) {
				System.out.print("Error. Introduce un número correcto: ");
			}
		}
		
		return num;
	}
	
	/**
	 * Muestra un mensaje por pantalla y solicita una cadena.
	 * Repite la operaci�n hasta que se introduce una cadena v�lida.
	 * @param mensaje El mensaje que se mostrar�
	 * @return La cadena introducida por el usuario
	 */
	public static String getString(String mensaje) {
		String cadena = null;
		
		while (cadena == null || cadena.isBlank()) {
			System.out.print(mensaje + ": ");
			cadena = sc.nextLine();
		}
		
		return cadena;
	}
	
	/**
	 * Muestra un mensaje por pantalla y solicita una cadena que debe
	 * estar comprendida entre una serie de opciones v�lidas
	 * Repite la operaci�n hasta que se introduce una cadena v�lida.
	 * @param mensaje El mensaje que se mostrar�
	 * @param opciones Las opciones aceptadas
	 * @return La cadena introducida por el usuario
	 */
	public static String getStringDeOpciones(String mensaje, String[] opciones) {
		boolean ok = false;
		String opcionElegida = null;
		
		while (!ok) {
			System.out.println(Arrays.toString(opciones));
			opcionElegida = UserDataCollector.getString(mensaje);
			
			for (int i = 0; i < opciones.length && !ok; i++) {
				if (opcionElegida.equalsIgnoreCase(opciones[i])) {
					ok = true;
				}
			}
		
		}
		
		return opcionElegida;
	}
	
	/**
	 * M�todo que muestra un mensaje y simplemente espera que el usuario pulse enter
	 * @param mensaje El mensaje que se mostrar�
	 */
	public static void getTecla(String mensaje) {
		System.out.print(mensaje);
		sc.nextLine();
	}

}
