package tema7;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasoAMayusculas {
    public static void main(String[] args) {
        String rutaFichero = "C:\\Desarrollo\\Workspace\\Boletines\\src\\tema7\\expresiones_regulares\\quijote.txt";
        String rutaSalida = "C:\\Desarrollo\\Workspace\\Boletines\\src\\tema7\\expresiones_regulares\\quijoteCap.txt";

        File ficheroOrigen = new File(rutaFichero);
        File ficheroDestino = new File(rutaSalida);

        if (!ficheroOrigen.exists()) {
            System.out.println("No existe el fichero de origen");
            return;
        }

        if (!ficheroDestino.exists()){
            try {
                ficheroDestino.createNewFile();
            } catch (IOException e) {
                System.out.println("No se puede crear el fichero de destino");
            }
        }

        Pattern p = Pattern.compile("\\p{L}+");

        try (
                FileReader fr = new FileReader(ficheroOrigen);
             BufferedReader br = new BufferedReader(fr);
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ficheroDestino)))
             ) {
            String l;

            while ((l = br.readLine()) != null){
                p.matcher(l).results().forEach(m -> pw.write(m.group()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
