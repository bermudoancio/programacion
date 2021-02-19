/**
 * 
 */
package boletin_08_herencia.ej5;

/**
 * @author Darío
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InvalidValueException 
	 */
	public static void main(String[] args) throws InvalidValueException {
		IEdificio[] edificios = {new Polideportivo(1, 1), new Polideportivo(1, 2), new Polideportivo(1, 3), new EdificioOficinas(4), new EdificioOficinas(5) };

		for (IEdificio e : edificios) {
			// Comprobamos si la clase del objeto actual implementa la interfaz IInstalacionDeportiva.
			if (IInstalacionDeportiva.class.isAssignableFrom(e.getClass())) {
				System.out.println(e + " es una instalación deportiva.");
			}
			else {
				System.out.println(e + " no es una instalación deportiva.");
			}

		}
		
	}

}
