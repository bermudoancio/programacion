package boletin_06b_objetos;

public class MainProducto {

	public static void main(String[] args) {
		try {
			Producto p1 = new Producto("Gambas", 16.50);
			System.out.println(p1);
		}
		catch (ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}

	}

}
