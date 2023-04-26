package tema7.java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ListaRecursivaNIO {

	public static void main(String[] args) {
		List<Path> dirs;
		try {
			dirs = Files.walk(Paths.get("C:\\Desarrollo\\jdk-19"))
					.filter(Files::isDirectory)
					.map(x -> x.toAbsolutePath())
			        .collect(Collectors.toList());
			for (Path dir : dirs) {
			    System.out.println("Ruta del directorio: " + dir.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
