package tema7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EjemploLectura3 {
	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(".\\src\\tema7\\xanadu.txt"));
			outputStream = new PrintWriter(new FileWriter(".\\src\\tema7\\characteroutput.txt"));
			String l;
			while ((l = inputStream.readLine()) != null) {
				System.out.println(l);
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}