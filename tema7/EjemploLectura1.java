package tema7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploLectura1 {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(".\\xanadu.txt");
		FileOutputStream out = new FileOutputStream(".\\outagain.txt");
		try (in; out) {
			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
		}
	}
}