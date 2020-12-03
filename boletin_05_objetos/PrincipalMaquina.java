package boletin_05_objetos;

import java.util.Scanner;

public class PrincipalMaquina {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Maquina m1 = new Maquina();
		
		int opcion;
		
		do {
			System.out.println(m1.mostrarMenu());
			System.out.print("Seleccione una opción: ");
			opcion = Integer.parseInt(sc.nextLine());
			
			
			switch (opcion) {
			case Maquina.OPCION_CAFE:
			case Maquina.OPCION_LECHE:
			case Maquina.OPCION_CAFE_LECHE:
				pedirDinero(opcion);
				m1.servirProducto(opcion);
				break;
			case Maquina.OPCION_ESTADO:
				System.out.println(m1);
				break;
			case Maquina.OPCION_APAGAR:
				break;
			default:
				System.out.println("Opción no válida");
			}
		
		} while (opcion != Maquina.OPCION_APAGAR);
	}
	
	public static double pedirDinero(int opcion) {
		switch (opcion) {
		case Maquina.OPCION_CAFE:
			System.out.print("Introduce " + Maquina.PRECIO_CAFE + "€");
			break;
		case Maquina.OPCION_LECHE:
			System.out.print("Introduce " + Maquina.PRECIO_LECHE + "€");
			break;
		case Maquina.OPCION_CAFE_LECHE:
			System.out.print("Introduce " + Maquina.PRECIO_CAFE_LECHE + "€");
			break;
		}
				
		return Double.parseDouble(sc.nextLine());
	}

}
