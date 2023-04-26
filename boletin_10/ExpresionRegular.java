package boletin_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionRegular {

	private static final File fichero = new File ("./src/boletin_10/xml/quijoteSinNum.txt");

	//private static BufferedReader lector;

	public static void main(String[] args) throws FileNotFoundException, IOException {

//		System.out.println("El número total de palabras encontradas es de: " + contarPalabra());
//		System.out.println("El número total de tildes y eñes encontradas es de: " + contarTildes());
//		eliminarNumeros();
//		pasarAMayusculas();
		pasarAMayusculas2();
//		imprimirPalabras();
//		buscarFrases();
	}


	private static int contarPalabra() throws FileNotFoundException, IOException {

		int contador = 0;
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){

			String linea;
			Pattern patron = Pattern.compile("([Rr]az[óo]n)");

			while ((linea = lector.readLine()) != null) {
				Matcher m = patron.matcher(linea);
				contador += m.results().count();
				//m.results().forEach(r -> System.out.println("#" + r.group()));
				//contador += m.results().filter(x -> x.group().contains("ó")).count();
			}


			//System.out.println("Razones encontradas: " + contador);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contador;

	}

	private static int contarTildes() throws FileNotFoundException, IOException {

		int contador = 0;
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){

			String linea;
			Pattern patron = Pattern.compile("([áéíóúÁÉÍÓÚ\u00f1\u00d1])");

			while ((linea = lector.readLine()) != null) {
				Matcher m = patron.matcher(linea);
				contador += m.results().count();
			}

			//System.out.println("Razones encontradas: " + contador);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contador;

	}

	public static void eliminarNumeros() throws FileNotFoundException, IOException{
		File nuevoFichero = new File("./src/boletin_10/xml/quijote3.txt");
		if (!nuevoFichero.exists()) {
			nuevoFichero.createNewFile();
		}
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero));
			PrintWriter pw = new PrintWriter(new FileWriter(nuevoFichero))){

			String linea;

			while((linea = lector.readLine())!=null) {
				//Se divide la cadena a buscar en dos con los parentsis y se pone el $1 para que deje solo la primera parte de la cadena
				//pw.println(linea.replaceAll("([a-zA-ZÀ-ÿ\u00f1\u00d1]+)([0-9]+)", "$1"));
				pw.println(linea.replaceAll("(\\p{L}+)([0-9]+)", "$1"));

			}

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void imprimirPalabras() {

		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){

			String linea;

			Pattern p = Pattern.compile("\\p{L}{9,}");


			while((linea = lector.readLine())!=null) {
				Matcher m = p.matcher(linea);
				//find devuelve un boolean de si ha encontrado algo en el matcher
				while (m.find()) {
					// Con group devuelvo todo si hay true en find
					System.out.println(m.group());
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void buscarFrases() {

		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){

			String linea;

			Pattern p = Pattern.compile("\\p{L}+");

			while((linea = lector.readLine())!=null) {
//				Matcher m = p.matcher(linea);
//				if(m.find()) {
//					if(m.results().count() < 18) {
//						System.out.println(linea);
//					}
//				}

				if(linea.split("\\p{L}+").length < 19) {
					System.out.println(linea);
				}
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pasarAMayusculas() throws FileNotFoundException, IOException{
		Pattern p = Pattern.compile("\\p{L}+");

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/boletin_10/xml/quijoteSinNum.txt"));
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pasarAMayusculas2() throws FileNotFoundException, IOException{
		Pattern p = Pattern.compile("\\p{L}+");

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/boletin_10/xml/quijoteSinNum.txt"));
			 PrintWriter out =
					 new PrintWriter(
							 new BufferedWriter(
									 new FileWriter("./src/boletin_10/xml/quijoteCap2.txt")))) {
			String linea;

			while ((linea = reader.readLine()) != null) {

				out.println(linea.replaceAll("(\\p{L})(\\p{L}+)", "$1".toUpperCase() + "$2".toLowerCase()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String capitalize(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.toLowerCase().substring(1);
	}
}