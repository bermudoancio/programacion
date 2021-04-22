package boletin_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej02 {

	public static void main(String[] args) {

		try (BufferedReader flujoEntrada = new BufferedReader(new FileReader("archivos\\ej01.txt"))) {
			
			StringBuilder sb = new StringBuilder();
			flujoEntrada.lines().forEach(l -> sb.append(l));
			System.out.println(sb);
			// flujoEntrada.lines().forEach(System.out::print);
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}