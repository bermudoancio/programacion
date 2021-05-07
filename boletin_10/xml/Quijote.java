package boletin_10.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quijote {

	public static void main(String[] args) {
		//capitalizar();

		//buscaPalabrasMasCaracteres(8);
		
		menosDeXPalabras(15);
	}
	
	private static void menosDeXPalabras(int i) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/boletin_10/xml/quijote.txt"))) {
			Pattern p = Pattern.compile("\\p{L}+");
			
			String linea;			
			while ((linea = reader.readLine()) != null) {
				Matcher m = p.matcher(linea);
				
				if (m.find()  ) {
					System.out.println(m.group());
				}
			}

		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void buscaPalabrasMasCaracteres(int i) {
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/boletin_10/xml/quijote.txt"))) {
			Pattern p = Pattern.compile("\\p{L}{" + i + ",}");
			
			String linea;			
			while ((linea = reader.readLine()) != null) {
				Matcher m = p.matcher(linea);
				m.results().map(e -> e.group()).forEach(System.out::println);
			}

		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void capitalizar() {
		Pattern p = Pattern.compile("\\p{L}+");
		
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/boletin_10/xml/quijote.txt"));
				PrintWriter out = 
						new PrintWriter(
								new BufferedWriter(
										new FileWriter("./src/boletin_10/xml/quijoteCap.txt")))) {
			String linea;
			
			while ((linea = reader.readLine()) != null) {
				StringBuilder sb = new StringBuilder(linea.length());
				Matcher m = p.matcher(linea);
				
				/*
				 * La primera posición desde donde se añadirá todo aquello que no sea texto.
				 * Comienza en 0 porque si una línea comenzara, por ejemplo, con unas comillas, al no
				 * ser estas una palabra no se tendrían en cuenta y no se añadirían al resultado. 
				 */
				int last = 0;
				while (m.find()) {
					/*
					 * Añadimos todo lo que no sea una palabra y que esté entre el último encontrado y la
					 * palabra actual. Por ejemplo, en el siguiente texto:
					 * Don Quijote, el llamado "matagigantes", era un ...
					 * 
					 * los espacios, las comas, las comillas, etc. no serán añadidas si tan sólo añadimos
					 * los resultados del match, que busca únicamente palabras.
					 */
					sb.append(linea.substring(last, m.start()));
					// Añadimos ahora la palabra en sí, capitalizada
					sb.append(capitalize(m.group()));
					/*
					 * Marcamos dónde acaba este "match" para poder añadir, en la siguiente iteración,
					 * todos los caracteres no letras que haya entre esta palabra y la siguiente. En el ejemplo
					 * anterior, después de matagigantes existen una comilla doble, una coma y un espacio.
					 * Estos tres caracteres serán añadidos en el substring de arriba
					 */
					last = m.end();
				}
				
				out.println(sb.toString());
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String capitalize(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.toLowerCase().substring(1);
	}

}
