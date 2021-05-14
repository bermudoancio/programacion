package boletin_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjRegex01 {

	private static final File fichero = new File("./src/boletin_10/quijote.txt");

	// private static BufferedReader lector;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println(contarPalabra());
	}

	private static int contarPalabra() throws FileNotFoundException, IOException {

		int contador = 0;
		try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {

			String linea;
			Pattern patron = Pattern.compile("([Rr]az[óo]n)");

			while ((linea = lector.readLine()) != null) {
				Matcher m = patron.matcher(linea);
				contador += m.results().count();
			}

			// System.out.println("Razones encontradas: " + contador);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contador;

	}
}