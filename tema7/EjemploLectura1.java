package tema7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploLectura1 {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(".\\src\\tema7\\xanadu.txt");
			out = new FileOutputStream(".\\src\\tema7\\outagain.txt");
			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}