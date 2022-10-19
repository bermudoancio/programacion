package boletin_03_java;

import java.util.Random;

public class Ejercicio4 {
	
	private static final int NUM_INICIAL = 1;
	private static final int NUM_FINAL = 100;

	public static void main(String[] args) {
		Random r = new Random();
		//int numAleatorio = r.nextInt(NUM_INICIAL, NUM_FINAL + 1);
		int numAleatorio = r.nextInt(NUM_FINAL) + 1;
		
		System.out.printf("Introduce un número entero entre %d y %d", NUM_INICIAL, NUM_FINAL);

	}

}
