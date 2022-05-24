package boletin12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio02 {
	
	public static void main(String[] args) {
		File archivo = new File("./src/boletin12/archivo.txt");
		String palabra = "Hola";
		
		try (
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				PrintWriter os = new PrintWriter(
						new FileWriter("./src/boletin12/BuscandoPalabra"+palabra+".txt"));
			) 
		{
			String l;
			int linea = 0;
			while((l = br.readLine()) != null) {
				linea++;
				if(l.matches(".*"+palabra+".*")) {
					int columna = l.indexOf(palabra);
					os.append("Encontrada en línea "+linea+" columna "+columna);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
