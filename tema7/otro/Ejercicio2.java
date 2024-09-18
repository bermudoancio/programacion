package tema7.otro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio2 {
    public static void main2(String[] args) {
        Path fichero = Paths.get("./otro/fichero2.txt");
        Pattern lineaValida = Pattern.compile(".*[;:]$");
        Pattern matriculaValida = Pattern.compile("(\\d{4}[B-Z&&[^EIOU]]{3})", Pattern.CASE_INSENSITIVE);
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.map(lineaValida::matcher)
                    .filter(Matcher::matches)
                    .map(m -> matriculaValida.matcher(m.group(0)))
                    .forEach(m -> {
                        while (m.find()){
                            System.out.println(m.group(0));
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./otro/fichero2.txt"))){
            String linea;
            Pattern lineaValida = Pattern.compile(".*[;:]$");
            Pattern matriculaValida = Pattern.compile("(\\d{4}[B-Z&&[^EIOU]]{3})", Pattern.CASE_INSENSITIVE);

            while ((linea = br.readLine()) != null) {
                Matcher mLineaValida = lineaValida.matcher(linea);

                if (mLineaValida.matches()){
                    Matcher mMatriculaValida = matriculaValida.matcher(linea);

                    while (mMatriculaValida.find()){
                        System.out.print(mMatriculaValida.group() + " ");
                    }
                    System.out.println();
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
