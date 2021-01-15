package boletin_06b_objetos;

public class PruebaEj4 {

	public static void main(String[] args) {
		String mensaje1 = "Introduce un número";
		String mensaje2 = "Introduce un número positivo";
		String mensaje3 = "Introduce un número entre 10 y 20";
		
		System.out.println(MiEntradaSalida.solicitarEntero(mensaje1));
		System.out.println(MiEntradaSalida.solicitarEnteroPositivo(mensaje2));
		System.out.println(MiEntradaSalida.solicitarEnteroEnRango(mensaje3, 10, 20));

	}

}
