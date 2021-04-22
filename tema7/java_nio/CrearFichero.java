package tema7.java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrearFichero {

	public static void main(String[] args) {
		Path emptyFile = Paths.get("./ejemplos_de_clase/java_nio/emptyFile.txt");
		if (Files.notExists(emptyFile)) {
		    try {
				emptyFile = Files.createFile(emptyFile);
				System.out.println("Se ha creado el fichero correctamente");
			}
		    catch (IOException e) {
		    	System.out.println("Error: " + e.getMessage());
			}
		}
		else {
			System.out.println("El fichero ya existía.");
		}

	}

}
