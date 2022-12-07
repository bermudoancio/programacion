package boletin_05_objetos;

import java.util.Scanner;

public class PrincipalMaquina {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Maquina m1 = new Maquina(-1, 2, 1);
		
			
			int opcion;
			
			do {
				System.out.println(m1.mostrarMenu());
				System.out.print("Seleccione una opci�n: ");
				opcion = Integer.parseInt(sc.nextLine());
				
				// Guardamos el dinero introducido por el cliente
				double dineroIntroducido = 0;
				
				switch (opcion) {
				case Maquina.OPCION_CAFE:
				case Maquina.OPCION_LECHE:
				case Maquina.OPCION_CAFE_LECHE:
					if (controlaExistencia(m1, opcion)) {
						procesaOpcion(m1, opcion);
					}
					break;
				case Maquina.OPCION_ESTADO:
					System.out.println(m1);
					break;
				case Maquina.OPCION_APAGAR:
					break;
				default:
					System.out.println("Opci�n no v�lida");
				}
			
			} while (opcion != Maquina.OPCION_APAGAR);
		}
		catch (ParametroNoValidoException ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}
	
	public static double controlarDinero(int opcion) {
		// Comprobamos el dinero introducido
		double dineroIntroducido = 0;
		
		while (dineroIntroducido < getPrecioOpcion(opcion)) {
			if (dineroIntroducido > 0) {
				System.out.printf("Ha introducido %f �\n", dineroIntroducido);
			}
			dineroIntroducido += pedirDinero(opcion);
		}
		
		return dineroIntroducido;
	}
	
	public static double pedirDinero(int opcion) {
		switch (opcion) {
		case Maquina.OPCION_CAFE:
			System.out.print("Introduce " + Maquina.PRECIO_CAFE + "�");
			break;
		case Maquina.OPCION_LECHE:
			System.out.print("Introduce " + Maquina.PRECIO_LECHE + "�");
			break;
		case Maquina.OPCION_CAFE_LECHE:
			System.out.print("Introduce " + Maquina.PRECIO_CAFE_LECHE + "�");
			break;
		}
				
		return Double.parseDouble(sc.nextLine());
	}
	
	public static double getPrecioOpcion  (int opcion) {
		double precioProducto = 0;
		
		switch (opcion) {
		case Maquina.OPCION_CAFE:
			precioProducto = Maquina.PRECIO_CAFE;
			break;
		case Maquina.OPCION_LECHE:
			precioProducto = Maquina.PRECIO_LECHE;
			break;
		case Maquina.OPCION_CAFE_LECHE:
			precioProducto = Maquina.PRECIO_CAFE_LECHE;
			break;
		}
		
		return precioProducto;
	}
	
	/**
	 * 
	 * @param m el objeto que representa la m�quina
	 * @param opcion la opci�n seleccionada
	 * @return el cambio a devolver
	 */
	public static double procesaOpcion(Maquina m, int opcion) {
		double dineroIntroducido = controlarDinero(opcion);
		
		double cambioADevolver = dineroIntroducido - getPrecioOpcion(opcion);
		if (m.getMonedero() < cambioADevolver) {
			System.out.println("No puedo servir porque no tengo cambio");
		}
		else {
			m.servirProducto(opcion);
		}
		
		return cambioADevolver;
	}
	
	public static boolean controlaExistencia(Maquina m, int opcion) {
		boolean hayExistencias = false;
		switch (opcion) {
		case Maquina.OPCION_CAFE:
			hayExistencias = m.getVasosRestantes() > 0 && m.getDosisCafes() > 0;
			break;
		case Maquina.OPCION_LECHE:
			hayExistencias = m.getVasosRestantes() > 0 && m.getDosisLeche() > 0;
			break;
		case Maquina.OPCION_CAFE_LECHE:
			hayExistencias = m.getVasosRestantes() > 0 && m.getDosisLeche() > 0 && m.getDosisCafes() > 0;
			break;
		}
		
		return hayExistencias;
	}

}
