package boletin_08_herencia;

import java.util.Scanner;

import boletin_08_herencia.Vehiculo.TipoCombustible;

public class EmpresaAlquiler {
	
	public static final int MAX_VEHICULOS = 200;
	private static Scanner sc;
	
	private Vehiculo[] vehiculos;
	
	public EmpresaAlquiler() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
		
		if (sc == null) {
			sc = new Scanner(System.in);
		}
	}
	
	public boolean altaVehiculo() throws InvalidValueException {
		// Representa el vehículo que será dado de alta
		Vehiculo v = null;
		
		String tipoVehiculo = "";
		boolean respuestaCorrecta = false;
		
		while (!respuestaCorrecta) {
			System.out.println("¿Qué vehículo quieres introducir: Coche, Microbus o Furgoneta?");
			tipoVehiculo = EmpresaAlquiler.sc.nextLine().toLowerCase();
			
			switch (tipoVehiculo) {
			case "coche":
			case "microbus":
			case "furgoneta":
				respuestaCorrecta = true;
			}
		}
		
		respuestaCorrecta = false;
		String matricula = "";
		while (!respuestaCorrecta) {
			System.out.print("¿Qué matrícula tendrá?: ");
			matricula = EmpresaAlquiler.sc.nextLine().toUpperCase();
			// TODO: comprobar validez matrícula
			if (matricula.length() > 0) {
				respuestaCorrecta = true;
			}
		}
		
		respuestaCorrecta = false;
		Vehiculo.Gama gama = null;
		while (!respuestaCorrecta) {
			System.out.print("¿Qué tipo de gama quiere?: ");
			for (Vehiculo.Gama valor: Vehiculo.Gama.values()) {
				System.out.print(valor + ", ");
			}
			String tipoGama = EmpresaAlquiler.sc.nextLine().toUpperCase();
			
			try {
				gama = Vehiculo.Gama.valueOf(tipoGama);
				respuestaCorrecta = true;
			}
			catch (IllegalArgumentException e) {
				System.out.println("Introduce un valor correcto");
			}
		}
		
		
		Vehiculo.TipoCombustible combustible = null;
		respuestaCorrecta = false;
		while (!respuestaCorrecta) {
			System.out.print("¿Qué tipo de combustible quiere?: ");
			for (Vehiculo.TipoCombustible valor: Vehiculo.TipoCombustible.values()) {
				System.out.print(valor + ", ");
			}
			
//			Vehiculo.TipoCombustible[] combustibles = Vehiculo.TipoCombustible.values();
//			for (int i = 0; i < combustibles.length; i++) {
//				Vehiculo.TipoCombustible valor = combustibles[i];
//				System.out.print(valor + ", ");
//			}
			
			
			String tipoCombustible = EmpresaAlquiler.sc.nextLine().toUpperCase();
			
			try {
				combustible = Vehiculo.TipoCombustible.valueOf(tipoCombustible);
				respuestaCorrecta = true;
			}
			catch (IllegalArgumentException e) {
				System.out.println("Introduce un valor correcto");
			}
		}
		
		/*
		 * Voy a coger los datos específicos de cada vehículo
		 */
		switch (tipoVehiculo) {
		case "coche":
			// Asigno el nuevo coche a v
			v = new Coche(matricula, gama, combustible);
			break;
		case "microbus":
			int asientos = 0;
			respuestaCorrecta = false;
			while (!respuestaCorrecta) {
				System.out.print("¿Cuántos asientos va a tener?: ");
				
				try {
					asientos = Integer.parseInt(sc.nextLine());
					if (Microbus.isValidPlazas(asientos)) {
						respuestaCorrecta = true;
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Introduce un valor correcto");
				}
			}
			// Asignamos el microbús a v
			v = new Microbus(matricula, gama, combustible, asientos);
			break;
		case "furgoneta":
			double pma = 0;
			respuestaCorrecta = false;
			while (!respuestaCorrecta) {
				System.out.print("¿Qué PMA tendrá?: ");
				
				try {
					pma = Double.parseDouble(sc.nextLine());
					if (FurgonetaCarga.isValidPMA(pma)) {
						respuestaCorrecta = true;
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Introduce un valor correcto");
				}
			}
			v = new FurgonetaCarga(matricula, gama, combustible, pma);
			break;
		}
		
		return this.addVehiculo(v);
		
	}
	
	private boolean addVehiculo(Vehiculo v) {
		boolean enc = false;
		int i = 0;
		
		while (i < this.vehiculos.length && !enc) {
			if (this.vehiculos[i] == null) {
				enc = true;
				this.vehiculos[i] = v;
			}
			i++;
		}
		
		return enc;
	}
	
	
	public static void main(String[] args) {
		
		
		
		if (sc != null) { // sc instanceof Scanner
			EmpresaAlquiler.sc.close();
		}
	}

}
