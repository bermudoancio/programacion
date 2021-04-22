package boletin_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej01b {
  //Ruta al fichero
  private static String pathToFile = "./src/ej01/ej01.txt";
  
  public static void main (String[] args) {
    //try-withresources
    try (BufferedReader reader = new BufferedReader(new FileReader (pathToFile));
        ) {
      //contador para las líneas
      int linesCounter = 0;
      //Recorre el archivo línea por línea hasta el final. readLine() solo devolverá null al encontrar <eof>
      while ( reader.readLine() != null) {
        //suma por cada línea encontrada
        linesCounter++;
      }
      System.out.println ("Número de líneas leídas: " + linesCounter);
    }
    catch (FileNotFoundException e) {
      System.err.println ("No se ha podido abrir o encontrar el archivo." + System.lineSeparator() + "Información detallada del error:");
      System.err.println( e.getMessage() );
    }
    catch (IOException e) {
      System.err.println( e.getMessage() );
    }
    
  }

}
