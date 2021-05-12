package boletin_10;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;


public class Ej07 {
  //Opciones del menú.
  public static final int LIST_DIR_OPTION = 1;
  public static final int LIST_AND_SEARCH_OPTION = 2;
  public static final int LIST_BY_EXTENSION_OPTION = 3;
  public static final int SEARCH_OPTION = 4;
  public static final int SEARCH_RECURSIVE_OPTION = 5;
  public static final int QUIT_OPTION = 6;

  
  /**
   * Método main de la clase
   * @param args - no se usan para nada
   */
  public static void main (String[] args) {
    // Será la opción del menú que escoja el usario.
    int optionSelected = QUIT_OPTION;
    
    // Repite el bucle mientras la opción seleccionada no se corresponda con salir
    do {
      // Muestra el menú
      showMenu();
      // Recoge la opción introducida por el usuario
      optionSelected = UserDataCollector.getEntero(System.lineSeparator() +
          "Introduce una opción: " + System.lineSeparator() ); 
      
      // Filtra y ejecuta la opción seleccionada
      switch (optionSelected) {
        case LIST_DIR_OPTION: 
          listDir();
          break;
        case LIST_AND_SEARCH_OPTION:
          listDirAndSearch();
          break;
        case LIST_BY_EXTENSION_OPTION:
          listByExtension();
          break;
        case SEARCH_OPTION:
          searchFileInDir();
          break;    
        case SEARCH_RECURSIVE_OPTION:
          searchFileInDirRecursive();
          break;
        case QUIT_OPTION:
          break;
        default:
          System.out.println ("Introduce una opción correcta.");
      }
      
    } while (optionSelected != QUIT_OPTION);
    
  }
  
  /**
   * Método para mostrar el menú por consola
   */
  private static void showMenu () {
    System.out.printf ("%n%d. Listar directorio.%n", LIST_DIR_OPTION);
    System.out.printf ("%d. Listar directorio y buscar ficheros que comiencen por una palabra.%n", LIST_AND_SEARCH_OPTION);
    System.out.printf ("%d. Listar archivos con cierta extensión de un directorio.%n", LIST_BY_EXTENSION_OPTION);
    System.out.printf ("%d. Buscar un archivo en un directorio.%n", SEARCH_OPTION);
    System.out.printf ("%d. Buscar recursivamente un archivo en un directorio.%n", SEARCH_RECURSIVE_OPTION);
    System.out.printf ("%d. Salir.%n", QUIT_OPTION);
  }
  
  
  /**
   * Muestra los archivos contenidos en el directorio
   */
  private static void listDir () {
    // Pide la ruta del directorio al usuario
    String input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce la ruta completa al directorio:" + System.lineSeparator());
    
    // Guarda la ruta al directorio como un objeto file
    File file = new File (input);
    
    // Si la ruta lleva a un archivo existente, es un directorio y se puede leer...
    if (file.exists() && file.isDirectory() && file.canRead()) {
      
      // Entonces recorre todos los archivos contenidos en el directorio
      for (File f: file.listFiles()) {
        //E imprime su nombre y su peso en KB (length devuelve el peso en bytes, por lo que se divide entre 1024 para pasarlo a KB). Si es un directorio, no se muestra el peso
        System.out.printf ("Nombre archivo: %s\t%s%n", f.getName(), (f.isDirectory() ? "" : (f.length()/1024) + " KB"));
      }
    }
    else {
      // Se muestra un mensaje de error si la ruta dada no es correcta
      System.out.println ("La ruta indicada no lleva a un directorio existente o no se puede leer.");
    }
  }
  
  
  
  /**
   * Lista los archivos de un directorio que empiecen por el nombre indicado 
   */
  private static void listDirAndSearch () {
    // Pide la ruta del directorio al usuario
    String input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce la ruta completa al directorio:" + System.lineSeparator());
    // Guarda la ruta al directorio como un objeto file
    File file = new File (input);
    // Pide al usuario el nombre del fichero que quiere buscar
    input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce el comienzo del nombre del fichero a buscar:" + System.lineSeparator());
    // Se guarda como final para que pueda ser usado en la declaración de la clase anónima (FilenameFilter filter...)
    final String comienzo = input;
    
    // Si la ruta lleva a un archivo existente, es un directorio y se puede leer...
    if (file.exists() && file.isDirectory() && file.canRead()) {
      
      // Se declara la clase que será usada para filtrar los nombres
      FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String fileName) {
          return fileName.startsWith(comienzo);
        }   
      };
      
      // Se usa el filtro en el método listFiles para que solo liste los archivos que cumplan con el requisito: Que su nombre empiece por el String "comienzo"
      for (File f: file.listFiles(filter)) {   
        System.out.printf ("Nombre archivo: %s\t%s%n", f.getName(), (f.isDirectory() ? "" : (f.length()/1024) + " KB"));
      }
    }
    else {
      System.out.println ("La ruta indicada no lleva a un directorio existente o no se puede leer.");
    }
  }
  
  
  
  /**
   * Lista los archivos de un directorio que terminen por el String indicado.
   */
  private static void listByExtension () {
    
    //Es exactamente la misma lógica que la del método ListDirAndSearch, con la única diferencia estando en el filtro.
    
    String input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce la ruta completa al directorio:" + System.lineSeparator());
    
    File file = new File (input);
    
    input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce el final del nombre del fichero a buscar:" + System.lineSeparator());
    final String terminacion = input;
    
    if (file.exists() && file.isDirectory() && file.canRead()) {
      
      FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String fileName) {
          // Acepta los Strings que terminen por el String "terminacion"
          return fileName.endsWith(terminacion);
        }   
      };
      
      for (File f: file.listFiles(filter)) {
        
        System.out.printf ("Nombre archivo: %s\t%s%n", f.getName(), (f.isDirectory() ? "" : (f.length()/1024) + " KB"));
      }
    }
    else {
      System.out.println ("La ruta indicada no lleva a un directorio existente o no se puede leer.");
    }
  }
  
  
  /**
   * Busca en un directorio, un archivo con el nombre indicado
   */
  private static void searchFileInDir () {
    String input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce la ruta completa al directorio:" + System.lineSeparator());
    
    File file = new File (input);
    
    input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce el nombre del fichero a buscar:" + System.lineSeparator());
    
    
    if (file.exists() && file.isDirectory() && file.canRead()) {
      // Busca entre los archivos del directorio
      for (File f: file.listFiles()) {
        // Si el archivo no es un directorio y su nombre coindice con el que se está buscando
        if ((!f.isDirectory()) && input.equals(f.getName())) {
          // Imprime la ruta completa del archivo
          System.out.println(f.getAbsolutePath());
          //y sale del bucle for
          break;
        }
      }
    }
    else {
      System.out.println ("La ruta indicada no lleva a un directorio existente o no se puede leer.");
    }
  }
  
  
  /**
   * Busca en el directorio dado, y en todos sus hijos (y a su vez en los hijos de estos... Y así en toda la jerarquía), los
   * archivos que coincidan con el nombre dado, y los muestra por pantalla (su ruta completa)
   */
  private static void searchFileInDirRecursive () {
    // Lista para almacenar los archivos encontrados
    List<File> founds = new ArrayList<File>();
    
    String input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce la ruta completa al directorio:" + System.lineSeparator());
    
    File file = new File (input);
    
    input = UserDataCollector.getString(System.lineSeparator() + 
        "Introduce el nombre del fichero a buscar:" + System.lineSeparator());
    
    
    if (file.exists() && file.isDirectory() && file.canRead()) {
      // Se llama al método recursivo para que busque en los directorios necesarios a partir del dado por parámetro
      searchByName (file, input, founds);
      // Si tras terminar la ejecución, la lista sigue con tamaño 0, entonces es que no se han encontrado archivos con ese nombre
      if (founds.size() == 0) {
        System.out.println ("No se han encontrado ficheros con ese nombre.");
      }
      else {
        //En caso contrario, entonces imprime la ruta completa de todos los archivos encontrados
        System.out.println ("Lista de archivos encontrados:");
        for (File f: founds) {
          System.out.println (f.getAbsolutePath());
        }
      }
    }
    else {
      System.out.println ("La ruta indicada no lleva a un directorio existente o no se puede leer.");
    }
  }
  
  
  /**
   * Método recursivo que busca en un directorio y en todos sus hijos, los ficheros que coincidan
   * con el nombre introducido, y los agrega a la lista dada.
   * @param dir - Directorio inicial donde buscar
   * @param name - Nombre del archivo a buscar
   * @param founds - Lista donde guardar los ficheros que coincidan con el nombre dado 
   */
  private static void searchByName (File dir, String name, List<File> founds) {
    // Recorre todos los ficheros que están contenidos en el directorio actual
    for (File f: dir.listFiles()) {
      // Si el fichero es un directorio y se puede leer, entonces el método se llama a sí mismo con ese directorio como punto de partida
      if (f.isDirectory() && f.canRead()) {
        searchByName (f, name, founds);
      }
      // En caso contrario, si el fichero no es un directorio, y si coincide con el nombre en búsqueda, entonces lo agrega a la lista
      else if (name.equals(f.getName())) {
          founds.add(f);
      }
      
    }
  }
  
}
