package boletin_05_2022;

import boletin_05_objetos.MiEntradaSalida;

public class Principal {

	public static void main(String[] args) {
		double altura = MiEntradaSalida.leerDouble("Introduce la altura");
		double anchura = MiEntradaSalida.leerDouble("Introduce la anchura");
		Rectangulo r1 = new Rectangulo((int) altura, (int) anchura);
		System.out.println("Área: " + r1.area());

	}

}
