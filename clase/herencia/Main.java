package clase.herencia;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Vehiculo v1 = new Vehiculo(4, 5);
		
		//Coche c1 = new Coche(4, 5, 4);
		
		boolean valido = false;
		Coche.TColores colorCoche = null;
		Scanner sc = new Scanner(System.in);
		
		while(!valido) {
			System.out.println("Escoja el color");
			
			for (int i = 0; i < Coche.TColores.values().length; i++) {
				Coche.TColores color = Coche.TColores.values()[i];
				System.out.println((i+1) + ": " + color.toString());
			}
			
			System.out.print("Introduzca el número seleccionado: \n");
			
			try {
				int indice = Integer.parseInt(sc.nextLine());
				
				if (indice > 0 && indice <= Coche.TColores.values().length) {
					valido = true;
					colorCoche = Coche.TColores.values()[indice - 1];
				}
				else {
					System.out.printf("Introduzca un número del %d al %d\n", 1, Coche.TColores.values().length);
				}
//				colorCoche = Coche.TColores.values()[indice - 1];
//				valido = true;
			}
			catch (NumberFormatException ex) {
				System.out.printf("Introduzca un número del %d al %d\n", 1, Coche.TColores.values().length);
			}
			catch (ArrayIndexOutOfBoundsException ex) {
				System.out.printf("Introduzca un número del %d al %d\n", 1, Coche.TColores.values().length);
			}
		}
		
//		while(!valido) {
//			System.out.println("Escoja el color");
//			
//			for (int i = 0; i < Coche.TColores.values().length; i++) {
//				Coche.TColores color = Coche.TColores.values()[i];
//				System.out.println((i+1) + ": " + color.toString());
//			}
//			
//			System.out.print("Introduzca el color seleccionado: \n");
//			
//			String nombreColor = sc.nextLine().toUpperCase();
//			
//			try {
//				colorCoche = Coche.TColores.valueOf(nombreColor);
//				valido = true;
//			}
//			catch (IllegalArgumentException e) {
//				System.out.printf("Introduzca uno de los valorse válidos\n");
//			}
//		}
		
		sc.close();
		
		
		CocheElectrico ce1 = new CocheElectrico(4, 5, 4, colorCoche, 10000);
		
		VehiculoMotorizado v1 = new CocheElectrico(1,2,3,colorCoche,4);
		VehiculoMotorizado v2 = new CocheGasolina(5,6,7,colorCoche);
		
		VehiculoMotorizado[] vehiculos = {v1, v2};
		
		Arrancable[] cosasArrancables = {v1, new Ordenador()};
		
		for (VehiculoMotorizado v: vehiculos) {
			Main.imprimeVehiculo(v);
		}
		
		for (Arrancable a: cosasArrancables) {
			a.arrancar();
		}
		
	}
	
	public static void imprimeVehiculo(Vehiculo v) {
		System.out.println(v);
	}

}
