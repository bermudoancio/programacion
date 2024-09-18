package tema7.boletin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ej1 {
    public static void main(String[] args) {
        Path path = Paths.get("./boletin/fichero.txt");
        try (
                Stream<String> stream = Files.lines(path)
        ) {
            System.out.printf("El fichero tiene %d lineas", stream.count());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
