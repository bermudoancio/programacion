package tema7;

import java.io.*;

/**
 * @author http://ibcomp.fis.edu/binary/Pix.html
 * 
 *         Before running this program you need to make a COPY of the picture,
 *         so you can always look at the original if you need to.
 * 
 *         (1) This program changes a .bmp picture. It will only work with a
 *         .bmp file. It changes each BYTE in the picture. Figure out what it
 *         does to the numbers, and explain why the picture looks the way it
 *         does.
 * 
 *         Change the command: (b ^ 255) to each of the following commands.
 *         After each change you should: (a) run the program to change the
 *         picture (b) VIEW the picture to see the effect (c) use a Hex-Editor
 *         to compare the new numbers to the originals. (d) Explain what has
 *         happened at the bit level, and why it has that visual effect on the
 *         picture. (e) Copy the original picture again, before making the next
 *         change.
 * 
 *         (2) (b & 127)
 * 
 *         (3) (b & 224)
 * 
 *         (4) (b | 128}
 * 
 *         (5) (b | 1)
 * 
 *         (6) (b ^ 1)
 *
 */

public class EjemploRandomAccess {
	public static void main(String[] args) {
		new EjemploRandomAccess();
	}

	public EjemploRandomAccess() {

		try (RandomAccessFile data = new RandomAccessFile("./src/tema7/pradera.bmp", "r");
				FileOutputStream out = new FileOutputStream("./src/tema7/praderaInversa.bmp")) {

			/*
			 * Los primeros 54 bytes corresponden a campos que representan información
			 * sobre la propia imagen. Por tanto, no haremos operaciones matemáticas
			 * con ellos.
			 */
			for (int x = 0; x < 54; x++) {
				byte[] buffer = new byte[1];
				data.seek(x);
				data.read(buffer);
				out.write(buffer);
			}
			
			
			/*
			 * A partir del byte 54 comienza la información propia de la imagen.
			 */
			long size = data.length();
			
			//System.out.println(size - 54);
			/*
			for (int x = 54; x < size; x = x + 3) {
				data.seek(x);
				byte b = data.readByte();
				b = (byte) (b ^ 255);
				
				byte b = data.readByte();
				byte g = data.readByte();
				byte r = data.readByte();
				out.write((byte) 0);
				out.write(g);
				out.write((byte) 0);
			}
			*/
			for (long x = size-1; x >= 54; x--) {
				data.seek(x);
				byte b = data.readByte();
								
				out.write(b);
			}
			
			data.close();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}