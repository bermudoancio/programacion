package tema7.java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EjemploTamaño {

	public static void main(String[] args) {
		long size = 0;
		try {
			size = Files.walk(Paths.get("C:\\Desarrollo\\jdk-19\\bin"))
					//.parallel()
					.filter(p -> p.toFile().isFile())
					.mapToLong(p -> p.toFile().length()).sum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tamaño del directorio: " + size);

	}

}
