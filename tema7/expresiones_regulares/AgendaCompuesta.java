package tema7.expresiones_regulares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendaCompuesta {
	public static void main(String[] args) {
		
		File archivo = new File ("./src/tema7/expresiones_regulares/agendaCompuesta.txt");
		
		// Este es el patrón a buscar
		//Pattern p = Pattern.compile("^\\d+:\\w*:\\d{9}$");
		/*
		 * Ojo, que si queremos comprobar nombres con tildes la cosa se complica
		 * Y habría que usar este otro patrón
		 * [a-zA-ZÀ-ÿ\u00f1\u00d1]
		 * 
		 * Aquí encontramos otro elemento más: "?:". Esto, al inicio de un paréntesis,
		 * indica que este grupo no debe capturarse (no vamos a utilizarlo después, solo nos 
		 * hace falta para agrupar elementos que se repiten).
		 * 
		 */
		
		//Pattern p = Pattern.compile("^(\\d+):((?:[a-zA-ZÀ-ÿ\u00f1\u00d1]+\\s*)*(?:[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+)):(\\d{9})$");
		Pattern p = Pattern.compile("^(\\d+):((?:\\p{L}+\\s+)*(?:\\p{L}+)):(\\d{9})$");

		try (FileReader fr = new FileReader (archivo); 
				BufferedReader br = new BufferedReader(fr)) { 
		    String l;
		    while ((l = br.readLine()) != null) {
		    	Matcher m = p.matcher(l);
		    	
		    	/*
		    	 * La función group del objeto Matcher devuelve el match (el contenido del paréntesis)
		    	 * en orden encontrado. Pero, al contrario que en los arrays, el primer elemento encontrado
		    	 * será devuelto en la posición 1. Si llamamos a m.group(0), lo que devolverá será el 
		    	 * match de la línea completa
		    	 */
		    	
		    	if (m.find()) {
		    		String matchDeLinea = m.group(0); // equivale a m.group()
		    		String id = m.group(1);
		    		String nombre = m.group(2);
		    		String telefono = m.group(3);
		    				    		
		    		System.out.println("Match de la línea: " + matchDeLinea);
		    		System.out.println("Id: " + id);
		    		System.out.println("Nombre: " + nombre);
		    		System.out.println("Teléfono: " + telefono);
		    		System.out.println();
		    	}
				    
		    }
		}
		catch (IOException e) {
		    System.out.println("Se ha producido un error: " + e.getMessage());
		}
		
			
		

	}
}
