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
	
	private static final File fichero = new File ("./src/ej01/quijote.txt");
	
	//private static BufferedReader lector;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		System.out.println("El n�mero total de palabras encontradas es de: " + contarPalabra());
//		System.out.println("El n�mero total de tildes y e�es encontradas es de: " + contarTildes());
//		eliminarNumeros();
//		pasarAMayusculas();
//		imprimirPalabras();
		buscarFrases();
	}

	
	private static int contarPalabra() throws FileNotFoundException, IOException {
		
		int contador = 0;
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){
			
			String linea;
			Pattern patron = Pattern.compile("([Rr]az[�o]n)");
			
			while ((linea = lector.readLine()) != null) {
				Matcher m = patron.matcher(linea);
				contador += m.results().count();
			}
			
			//System.out.println("Razones encontradas: " + contador);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return contador;
		
	}
	
	private static int contarTildes() throws FileNotFoundException, IOException {
		
		int contador = 0;
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero))){
			
			String linea;
			Pattern patron = Pattern.compile("([����������\u00f1\u00d1])");
			
			while ((linea = lector.readLine()) != null) {
				Matcher m = patron.matcher(linea);
				contador += m.results().count();
			}
			
			//System.out.println("Razones encontradas: " + contador);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return contador;
		
	}
	
	public static void eliminarNumeros() throws FileNotFoundException, IOException{
		File nuevoFichero = new File("./src/ej01/quijote2.txt");
		if (!nuevoFichero.exists()) {
			nuevoFichero.createNewFile();
		}
		try(BufferedReader lector = new BufferedReader(new FileReader(fichero));
				PrintWriter pw = new PrintWriter(new FileWriter(nuevoFichero))){
			
			String linea;
			
			while((linea = lector.readLine())!=null) {
				//Se divide la cadena a buscar en dos con los parentsis y se pone el $1 para que deje solo la primera parte de la cadena
				pw.println(linea.replaceAll("([a-zA-Z�-�\u00f1\u00d1]+)([0-9]+)", "$1"));
				
			}
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
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
		
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/ej01/quijote2.txt"));
				PrintWriter out = 
						new PrintWriter(
								new BufferedWriter(
										new FileWriter("./src/boletin_10/xml/quijoteCap.txt")))) {
			String linea;
			
			while ((linea = reader.readLine()) != null) {
				StringBuilder sb = new StringBuilder(linea.length());
				Matcher m = p.matcher(linea);
				
				/*
				 * La primera posici�n desde donde se a�adir� todo aquello que no sea texto.
				 * Comienza en 0 porque si una l�nea comenzara, por ejemplo, con unas comillas, al no
				 * ser estas una palabra no se tendr�an en cuenta y no se a�adir�an al resultado. 
				 */
				int last = 0;
				while (m.find()) {
					/*
					 * A�adimos todo lo que no sea una palabra y que est� entre el �ltimo encontrado y la
					 * palabra actual. Por ejemplo, en el siguiente texto:
					 * Don Quijote, el llamado "matagigantes", era un ...
					 * 
					 * los espacios, las comas, las comillas, etc. no ser�n a�adidas si tan s�lo a�adimos
					 * los resultados del match, que busca �nicamente palabras.
					 */
					sb.append(linea.substring(last, m.start()));
					// A�adimos ahora la palabra en s�, capitalizada
					sb.append(capitalize(m.group()));
					/*
					 * Marcamos d�nde acaba este "match" para poder a�adir, en la siguiente iteraci�n,
					 * todos los caracteres no letras que haya entre esta palabra y la siguiente. En el ejemplo
					 * anterior, despu�s de matagigantes existen una comilla doble, una coma y un espacio.
					 * Estos tres caracteres ser�n a�adidos en el substring de arriba
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
