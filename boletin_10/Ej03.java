package boletin_10;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ej03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter os = new PrintWriter(new FileWriter("./src/boletin_10/salida.txt", true));
		
		try (br; os) {
			String linea;
			while(!(linea = br.readLine()).equals("fin")) {
				os.println(linea);
				//os.flush(); // Fuerza la escritura al fichero
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
