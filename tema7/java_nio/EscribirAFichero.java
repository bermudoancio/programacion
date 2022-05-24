package tema7.java_nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EscribirAFichero {
	public static void main(String[] args) {
		Path ficheroSalida = Paths.get("./src/tema7/java_nio/ficheroAEscribir.txt");
		
		String text = "Esto es una cadena de prueba con tíldes mal puestas y eñes.";
		try {
			// Escribe al fichero. Si no existe se creará. Si tiene contenido, se truncará.
//			Files.write(ficheroSalida, text.getBytes(StandardCharsets.UTF_8),
//			        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			
			/*
			 * La línea anterior truncará el fichero si existe. Para añadir el texto al archivo:
			 */
			 Files.write(ficheroSalida, text.getBytes(StandardCharsets.UTF_8),
			        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			 
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


