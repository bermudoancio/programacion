package tema7.java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EjemploContarFicherosTXT {
	public static void main(String[] args) {
		long parcialCount = 0;
		try {
			parcialCount = Files.walk(Paths.get("C:\\Desarrollo\\jdk-19")).parallel()
			        .filter(p -> p.toString().matches("(?i).+\\.(txt|log|conf|properties)$") && p.toFile().length() > 0L).count();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ficheros que cumplen con el filtro: " + parcialCount);
	}
}
