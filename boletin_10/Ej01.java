package boletin_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej01 {

	public static void main(String[] args) {

		try (BufferedReader flujoEntrada = new BufferedReader(new FileReader("archivos\\ej01.txt"))) {

			long nLineas = flujoEntrada.lines().count();
			System.out.println("El archivo tiene " + nLineas + " líneas.");

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}