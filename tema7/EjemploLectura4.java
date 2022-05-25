package tema7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.IOException;

public class EjemploLectura4 implements Serializable{
	private transient String password;
	
	public static void main(String[] args) throws IOException {
		File archivo = new File(".\\src\\tema7\\xanadu.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		PrintWriter os = new PrintWriter(new FileWriter(".\\src\\tema7\\salida4.txt", true));
		/*
		 * A partir de Java 9: observa que podemos declarar el objeto anteriormente y
		 * simplemente añadirlo al bloque try with resources
		 */
		try (fr; br; os) {
			String l;
			while ((l = br.readLine()) != null) {
				os.println(l);
			}
		} catch (IOException e) {
			System.out.println("Se ha producido un error: " + e.getMessage());
		}
	}
}