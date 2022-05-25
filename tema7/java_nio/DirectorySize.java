package tema7.java_nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectorySize {

	public static void main(String[] args) {
		Path directorio = Paths.get("./src/tema7/java_nio");
		if (Files.exists(directorio) && Files.isDirectory(directorio)) {
		    try {
		    	long size = Files.walk(directorio)
		    			//.filter(p -> p.toFile().isFile())
		    			.filter(p -> Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS))
		    	        .mapToLong(p -> p.toFile().length()).sum();
//		    			.mapToLong(p -> {
//		    				try {
//		    					return Files.size(p);
//		    				}
//		    				catch (IOException e) {
//		    					return 0;
//		    				}
//		    			}).sum();
		    	System.out.println("Tamaño en bytes del directorio: " + size);
		    	
		    	long count = Files.walk(directorio).parallel().filter(p -> Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS)).count();
		    	System.out.println("Total de ficheros: " + count);
			}
		    catch (IOException e) {
		    	System.out.println("Error: " + e.getMessage());
			}
		}
		else {
			System.out.println("El directorio no existe.");
		}

	}

}
