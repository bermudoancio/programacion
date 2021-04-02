package tema7.java_nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LecturaLineaALinea {

	public static void main(String[] args) {
		Path path = Paths.get("./ejemplos_de_clase/java_nio/fichero.txt");
		try (
			Stream<String> stream = Files.lines(path)
		) {
			stream.forEach( s ->System.out.println(s));
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}

}
