package boletin_06b_objetos;

import java.util.Scanner;

public class MiEntradaSalida {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int solicitarEntero(String mensaje) {
		// Variable que almacenará el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
		boolean flag = true;
		
		while(flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
				flag = false;
			}
			// Si se lanza la excepción, informamos al usuario de su error.
			catch(NumberFormatException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}
			
		}
		
		return integer;
	}
	
	public static int solicitarEnteroPositivo(String mensaje) {
		// Variable que almacenará el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
		boolean flag = true;
		
		while(flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
				if (integer >= 0) {
					flag = false;
				}
			}
			// Si se lanza la excepción, informamos al usuario de su error.
			catch(NumberFormatException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}
			
		}
		
		return integer;
	}
	
	public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
		// Variable que almacenará el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
		boolean flag = true;
		
		while(flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
				if (integer >= limiteInferior && integer <= limiteSuperior) {
					flag = false;
				}
			}
			// Si se lanza la excepción, informamos al usuario de su error.
			catch(NumberFormatException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}
			
		}
		
		return integer;
	}
	
	public static char solicitarCaracter(String mensaje) {
		char c = '0';
		
		// Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
		boolean flag = true;
		
		while(flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
			try {
				c = sc.nextLine().charAt(0);
				// Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
				flag = false;
			}
			// Si se lanza la excepción, informamos al usuario de su error.
			catch(IndexOutOfBoundsException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}
			
		}
		
		return c;
	}
	
	
	
}
