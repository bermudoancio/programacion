package boletin_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Ej04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Path salida = Paths.get("./src/boletin_10/salida.txt");
		
		try (br) {
			String linea;
			while(!(linea = br.readLine()).equals("fin")) {
				linea = linea + System.lineSeparator();
				Files.writeString(salida, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
