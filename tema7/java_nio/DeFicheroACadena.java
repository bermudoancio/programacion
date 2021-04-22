package tema7.java_nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DeFicheroACadena {

	public static void main(String[] args) {
		Path path = Paths.get("./src/tema7/java_nio/fichero.txt");
		
		String content = null;
		try {
			content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(content);


	}

}


