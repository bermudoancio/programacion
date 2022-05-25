package tema7;
import java.io.*;
 
/**
 * This program demonstrates how to use RandomAccessFile to read ID3 tags of
 * a MP3 file.
 *
 * @author www.codejava.net
 */
public class ReadMP3Tags {
 
    static void testReadMP3(String filePath) {
        try {
 
            String mode = "r";
            RandomAccessFile randomFile = new RandomAccessFile(filePath, mode);
 
            long length = randomFile.length();
 
            randomFile.seek(length - 128);
 
            byte[] byteArray = new byte[3];
 
            randomFile.read(byteArray);
 
            String tag = new String(byteArray);
 
            if (!"TAG".equals(tag)) {
                System.out.println("This file doesn't support ID3v1");
                System.exit(0);
            }
 
            byteArray = new byte[30];
            randomFile.read(byteArray);
 
            String songName = new String(byteArray);
 
            System.out.println("Song name: " + songName);
 
            randomFile.read(byteArray);
 
            String artist = new String(byteArray);
 
            System.out.println("Artist: " + artist);
 
            randomFile.read(byteArray);
 
            String album = new String(byteArray);
 
            System.out.println("Album: " + album);
 
            byteArray = new byte[4];
            randomFile.read(byteArray);
 
            String year = new String(byteArray);
 
            System.out.println("Year: " + year);
            
            byteArray = new byte[30];
            randomFile.read(byteArray);
            
            String comment = new String(byteArray);
            System.out.println("Comment: " + comment);
 
            randomFile.close();
 
        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex);
        }
 
    }
 
    public static void main(String[] args) {

        String filePath = "./src/tema7/0103. Fun Time - AShamaluevMusic.mp3";
        testReadMP3(filePath);
    }
}