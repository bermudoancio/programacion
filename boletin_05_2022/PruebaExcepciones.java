package boletin_05_2022;

import boletin_05_objetos.MiEntradaSalida;

public class PruebaExcepciones {

	public static void main(String[] args) {
		double d = MiEntradaSalida.leerDouble("Introduce un número doble");
		System.out.println("El número es " + d);
	}

}
