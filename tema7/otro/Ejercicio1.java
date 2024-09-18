package tema7.otro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {
        Path fichero = Paths.get("./otro/fichero.txt");
        Pattern p = Pattern.compile("(\\p{L}+)");
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.forEach(l -> {
                System.out.printf("%d: %s\n", l.split(" ").length, l);
            });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
