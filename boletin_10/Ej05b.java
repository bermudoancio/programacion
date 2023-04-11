package boletin_10;

import java.io.File;
import java.io.IOException;

public class Ej05b {

	public static void main(String[] args) {
				
		int opcion = 0;
		
		while (opcion != 5) {
			opcion = Ej05b.menu();
			try {
				switch (opcion) {
				case 1:
					crearDirectorio();
					break;
				case 2:
					crearFicheroDeTexto();
					break;
				case 3:
					borrarFicheroDeTexto();
					break;
				case 4:
					mostrarFicherosDeCarpeta();
					break;
				case 5:
					System.out.println("Adiós");
					break;
				default:
					System.out.println("Opción incorrecta");
				}
			} 
			catch (IOException e) {
				System.out.println(e.getMessage());
			}

			
		}

	}

	private static void crearDirectorio() throws IOException {
		
//		File currentDir = new File(".");
//		
//		String fichero = UserDataCollector.getString("Introduce la ruta relativa al directorio (directorio actual: " + currentDir.getAbsolutePath() + ")");
//
//		File dir = new File(currentDir, fichero);
		
		String fichero = UserDataCollector.getString("Introduce la ruta absoluta al directorio");

		File dir = new File(fichero);

		if (dir.exists()) {
			throw new IOException("Ya existe dicha ruta");
		}

		try {
			if (dir.mkdirs()) {
				System.out.println("El directorio se ha creado correctamente");
			}
			else {
				System.out.println("No se ha podido crear el directorio");
			}
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void mostrarFicherosDeCarpeta() throws IOException {
		String ruta = UserDataCollector.getString("Introduce la ruta completa al directorio");

		File dir = new File(ruta);

		if (!dir.exists() || !dir.isDirectory()) {
			throw new IOException("La ruta introducida no es un directorio válido");
		}

		listaFicheros(dir);

	}
	
	private static void listaFicheros(File directorio) {
		try {
			for(File file: directorio.listFiles()){
				String salida = "";
				if (file.isDirectory()) {
					salida += "D - ";
					listaFicheros(file);
				}
				else {
					salida += "F - ";
				}
				System.out.println(salida + file.getName()); 
			}
			
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void borrarFicheroDeTexto() throws IOException {
		String ruta = UserDataCollector.getString("Introduce la ruta completa al fichero");

		File fichero = new File(ruta);

		if (!fichero.exists() || !fichero.isFile()) {
			throw new IOException("El fichero no existe o no es un fichero regular");
		}

		try {
			if (fichero.delete()) {
				System.out.println("El fichero se ha borrado correctamente");
			}
			else {
				System.out.println("No se ha podido borrar el fichero");
			}
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void crearFicheroDeTexto() throws IOException {
		String ruta = UserDataCollector.getString("Introduce la ruta completa al fichero");

		File fichero = new File(ruta);

		if (fichero.exists()) {
			throw new IOException("Ya existe dicha ruta");
		}

		try {
			if (fichero.createNewFile()) {
				System.out.println("El fichero se ha creado correctamente");
			}
			else {
				System.out.println("No se ha podido crear el fichero");
			}
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int menu() {
		System.out.println("Menú");
		System.out.println("1. Crear directorio");
		System.out.println("2. Crear fichero de texto");
		System.out.println("3. Borrar fichero de texto");
		System.out.println("4. Mostrar ficheros de una carpeta");
		System.out.println("5. Salir");

		return UserDataCollector.getEnteroMinMax("Selecciona una opción", 1, 5);
	}

}
