package boletin_05_2022;

import java.util.Scanner;

public class OrdenarCadenas {

	private static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		
		String cadena1, cadena2,cadena3;
		cadena1= solicitarCadena("Introduce el primer nombre completo (apellidos, nombre):");
		cadena2= solicitarCadena("Introduce el segundo nombre completo (apellidos, nombre):");
		cadena3= solicitarCadena("Introduce el tercer nombre completo (apellidos, nombre):");
		
		mostrarOrdenadoAlfabeticamente(cadena1, cadena2, cadena3);
	}
	private static String solicitarCadena(String msg) {
		
		String cadena;
		System.out.println(msg);
		cadena=teclado.nextLine();
		
		return cadena;
	}
	/**
	 * Este metódo muestra por consola las tres cadenas ordenadas lexicográficamente
	 * de menor a mayor
	 * @param cadena1
	 * @param cadena2
	 * @param cadena3
	 */
	public static void mostrarOrdenadoAlfabeticamente(String cadena1, String cadena2, String cadena3) {
		
		String cadenaAuxiliar;
		
		if (cadena1.compareTo(cadena2) > 0) { //cadena1 > cadena2. La intercambiamos
			cadenaAuxiliar=cadena1;
			cadena1=cadena2;
			cadena2=cadenaAuxiliar;
		}
		
		//Aqui seguro que cadena1 es menor que cadena2. 
		//Ahora comparo cadena3
		
		if ( cadena3.compareTo( cadena1) < 0 ) { //cadena3 < cadena1 . Orden 3 1 2
		
			System.out.println(cadena3);
			System.out.println(cadena1);
			System.out.println(cadena2);
		}else {
			if (cadena3.compareTo(cadena2)< 0) { //cadena3 < cadena2.El orden es 1 3 2 
				
				System.out.println(cadena1);
				System.out.println(cadena3);
				System.out.println(cadena2);
				
			}
			else { // orden 1 2 3
				
				System.out.println(cadena1);
				System.out.println(cadena2);
				System.out.println(cadena3);
			}
		}
		
		
		
		
		
	}

}
