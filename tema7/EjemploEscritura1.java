package tema7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EjemploEscritura1 {

	public static void main(String[] args) {
		File ficheroSalida = new File(".\\src\\tema7\\salidaconsola.txt");
		
		try (
			PrintWriter salida = new PrintWriter(new FileWriter(ficheroSalida, true));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		) {
			String l;
			
			while (!(l = br.readLine()).equals("fin")) {
				salida.println(l);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
