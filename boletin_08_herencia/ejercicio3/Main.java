package boletin_08_herencia.ejercicio3;

import java.util.Arrays;
import java.util.Scanner;

import boletin_08_herencia.ejercicio3.Personaje.Raza;

public class Main {
	/*
	 * public static void main(String[] args) { Mago m1 = null, m2 = null; Clerigo
	 * c1 = null;
	 * 
	 * try { m1 = new Mago("Jose", Raza.HUMANO, 12, 20, 80); m2 = new
	 * Mago("Gandalf", Raza.ENANO, 14, 19, 90); c1 = new Clerigo("Dar�o", Raza.ELFO,
	 * 19, 17, 70, "Peter");
	 * 
	 * } catch (InvalidValueException e) { System.err.println(e.getMessage()); }
	 * 
	 * System.out.println(m1); System.out.println(m2); System.out.println(c1);
	 * 
	 * try { m1.aprendeHechizo("Suspensos m�ximos");
	 * m1.aprendeHechizo("Habilidad Java"); m2.aprendeHechizo("Congelar");
	 * System.out.println(m1); System.out.println(m2); m1.lanzaHechizo(m2,
	 * "Habilidad Java"); m2.lanzaHechizo(m1, "Congelar"); System.out.println(m1);
	 * System.out.println(m2); c1.curar(m2); m1.lanzaHechizo(m2,
	 * "Suspensos m�ximos"); System.out.println(m1); System.out.println(m2);
	 * System.out.println(c1);
	 * 
	 * } catch (InvalidValueException e) { System.err.println(e.getMessage());
	 * 
	 * }
	 * 
	 * }
	 */
	static Personaje[] personaje = new Personaje[100];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		while (opcion != 7) {
			System.out.println(menu());
			try {
				opcion = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Selecciona una opción correcta.");
				continue;
			}

			switch (opcion) {
			case 1:
				Personaje p = null;
				String nombre = pideNombre();
				Raza raza = pideRaza();
				char tipo = seleccionPersonaje();
				int fuerza = pideFuerza();
				int inteligencia = pideInteligencia();
				int puntosVida = pidePuntosVida();
				try {
					if (tipo == 'C') {
						String dios = pideDios();
						p = new Clerigo(nombre, raza, fuerza, inteligencia, puntosVida, dios);

					} 
					else {
						p = new Mago(nombre, raza, fuerza, inteligencia, puntosVida);

					}
					
					if (addPersonaje(p)) {
						System.out.println("El personaje se ha añadido.");
					} 
					else {
						System.out.println("El personaje no ha podido ser añadido.");
					}
					
				} 
				catch (InvalidValueException e) {
					System.out.println(e.getMessage());
					System.out.println("El personaje no ha podido ser añadido.");
				}
				
				break;
			case 2:
				System.out.print("Introduce el nombre del mago: ");
				Personaje personaje = personajeEncontrado();
				
				if (personaje != null && personaje instanceof Mago) {
					System.out.print("Introduzca el hechizo que desea aprender: ");
					String nombreHechizo = sc.nextLine();
					try {
						((Mago) personaje).aprendeHechizo(nombreHechizo);
					} catch (InvalidValueException e) {
						System.out.println(e.getMessage());
					}
					
				} 
				else {
					System.out.println("El personaje no es un mago.");
				}
				break;
			case 3:
				personajeEncontrado();
				if (personajeEncontrado().getNombre() != personajeEncontrado().getNombre()) {
					System.out.print("Introduce el nombre del hechizo que desea lanzar: ");
					String hechizo = sc.nextLine();
					try {
						personajeEncontrado().lanzaHechizo(personajeEncontrado(), hechizo);
					} catch (InvalidValueException e) {
						System.out.println(e.getMessage());
					}
				}

			}

		}
	}

	public static String menu() {
		return "1.Alta de personaje \n2.Mago aprende hechizo \n3.Mago lanza hechizo \n4.Cl�rigo cura al mago \n5.Mostrar el listado de personajes \n6.Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor \n7.Salir";
	}

	private static char seleccionPersonaje() {
		Scanner sc = new Scanner(System.in);
		char opcionElegida = 't';
		while (opcionElegida != 'M' && opcionElegida != 'C') {
			System.out.println("Introduzca \"M\" para mago y \"C\" para cl�rigo.");
			opcionElegida = sc.nextLine().toUpperCase().charAt(0);
			if (opcionElegida != 'M' && opcionElegida != 'C') {
				System.out.println("Introduzca una opci�n correcta.");
			}
		}

		return opcionElegida;
	}

	private static int pideFuerza() {
		Scanner sc = new Scanner(System.in);
		int fuerza = 0;
		boolean opcionCorrecta = false;
		System.out.print("Introduzca la fuerza del personaje:");
		while (!opcionCorrecta) {
			try {
				fuerza = Integer.parseInt(sc.nextLine());
				opcionCorrecta = true;

			} catch (NumberFormatException e) {
				System.out.println("Seleccione una opci�n correcta.");
			}
		}
		return fuerza;
	}

	private static int pideInteligencia() {
		Scanner sc = new Scanner(System.in);
		int inteligencia = 0;
		boolean opcionCorrecta = false;
		System.out.print("Introduzca la inteligencia del personaje:");

		while (!opcionCorrecta) {
			try {
				inteligencia = Integer.parseInt(sc.nextLine());
				opcionCorrecta = true;

			} catch (NumberFormatException e) {
				System.out.println("Seleccione una opci�n correcta.");
			}
		}
		return inteligencia;
	}

	private static int pidePuntosVida() {
		Scanner sc = new Scanner(System.in);
		int vida = 0;
		boolean opcionCorrecta = false;
		System.out.print("Introduzca los puntos de vida del personaje:");

		while (!opcionCorrecta) {
			try {
				vida = Integer.parseInt(sc.nextLine());
				opcionCorrecta = true;

			} catch (NumberFormatException e) {
				System.out.println("Seleccione una opci�n correcta.");
			}
		}
		return vida;
	}

	private static String pideDios() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el Dios al que le reza:");
		return sc.nextLine();
	}

	private static String pideNombre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el nombre del personaje:");
		return sc.nextLine();
	}

	private static Raza pideRaza() {
		Scanner sc = new Scanner(System.in);
		Raza raza = null;
		boolean correcto = false;
		System.out.print("Introduzca la raza: " + Arrays.toString(Raza.values()));
		while (!correcto) {
			try {
				raza = Raza.valueOf(sc.nextLine().toUpperCase());
				correcto = true;
			} catch (IllegalArgumentException e) {
				System.out.println(
						"Introduzca una raza correcta entre las siguientes: " + Arrays.toString(Raza.values()));
			}
		}
		return raza;
	}

	private static boolean addPersonaje(Personaje p) {
		boolean personajeAdded = false;
		boolean nombreEncontrado = false;
		for (int i = 0; i < Main.personaje.length && !nombreEncontrado; i++) {
			if (Main.personaje[i] != null
					&& Main.personaje[i].getNombre().equalsIgnoreCase(Main.personaje[i].getNombre())) {
				nombreEncontrado = true;
			}
		}
		if (!nombreEncontrado) {
			for (int i = 0; i < Main.personaje.length && !personajeAdded; i++) {
				if (Main.personaje[i] == null) {
					Main.personaje[i] = p;
					personajeAdded = true;
				}
			}
		}

		return personajeAdded;

	}

	private static Personaje personajeEncontrado() {
		Scanner sc = new Scanner(System.in);
		Personaje personaje = null;
		boolean personajeEncontrado = false;

		String nombrePersonaje = sc.nextLine();

		for (int i = 0; i < Main.personaje.length && !personajeEncontrado; i++) {
			if (Main.personaje[i] != null && nombrePersonaje.equalsIgnoreCase(Main.personaje[i].getNombre())) {
				personaje = Main.personaje[i];
				personajeEncontrado = true;
			} else {
				System.out.print("Ese personaje no existe. Introduzca el nombre de un personaje existente: ");
			}

		}
		return personaje;
	}

//	private static Personaje personajeEncontrado() {
//		Scanner sc = new Scanner(System.in);
//		Personaje personaje = null;
//		boolean personajeEncontrado = false;
//		System.out.print("Introduce el nombre del personaje al que quiere lanzar el hechizo: ");
//		while (!personajeEncontrado) {
//			String nombrePersonaje = sc.nextLine();
//			for (int i = 0; i < Main.personaje.length && !personajeEncontrado; i++) {
//				if (Main.personaje[i] != null && nombrePersonaje.equalsIgnoreCase(Main.personaje[i].getNombre())) {
//					personaje = Main.personaje[i];
//					personajeEncontrado = true;
//				} else {
//					System.out.print("Ese personaje no existe. Introduzca el nombre de un personaje existente: ");
//				}
//			}
//		}
//		return personaje;
//	}

}
