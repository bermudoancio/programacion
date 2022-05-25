package tema7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploLectura2 {
	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;
		try {
			inputStream = new FileReader(".\\src\\tema7\\xanadu.txt");
			
			outputStream = new FileWriter(".\\src\\tema7\\outagain.txt");
			int c;
			while ((c = inputStream.read()) != -1) {
				System.out.println(c);
				outputStream.write(c);
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