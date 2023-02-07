package boletin_05_2022;

import java.util.Scanner;

public class EjemploUsoIndexOf {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		String apellidos, unApellido;
		int posicion, desde=0;
		
		System.out.println("Introduce todos tus apellidos:");
		apellidos= teclado.nextLine();
		
		System.out.println("Introduce un apellido a buscar");
		unApellido=teclado.nextLine();
		
		do {
			posicion=apellidos.indexOf(unApellido, desde);
		
			if ( posicion!=-1)
				System.out.println("Encontrado en posicion " + posicion );
			
			desde= posicion + unApellido.length();
		}while ( posicion!= -1);
		
		
	
		
	}

}
