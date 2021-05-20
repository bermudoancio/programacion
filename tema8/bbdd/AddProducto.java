package tema8.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AddProducto {
	
	private static final int OPCION_SALIR = 2;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		String usuario="root";
		String password="root";
		
		int opcion;
		
		try (Connection con = DriverManager.getConnection(url,usuario,password)) {
			do {
				opcion = mostrarMenu();
				tratarMenu(opcion, con);

			} while (opcion != OPCION_SALIR);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static int mostrarMenu() {
		int op = 0;
		do {
			System.out.println("Menú vehículos:");
			System.out.println("1.-Nuevo Producto");
			System.out.println(OPCION_SALIR + ".-Nuevo Producto");
			try {
				op = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un número de 1 al " + OPCION_SALIR);
			}
		} while (op < 1 || op > OPCION_SALIR);

		return op;
	}
	
	private static void tratarMenu(int opcion, Connection con) {
		
		switch (opcion) {
		case 1: {
			nuevoProducto(con);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}

	private static void nuevoProducto(Connection con) {
		System.out.println("Introduce la información del nuevo producto");
		String nombre = UserDataCollector.getString("Nombre del producto");
		String codigo = UserDataCollector.getString("Introduce el código");
		String descripcion = UserDataCollector.getString("Introduce la descripcion");
		double precio = UserDataCollector.getDouble("Introduce el precio de venta");
		double msrp = UserDataCollector.getDouble("Introduce el precio de venta recomendado");
		String escala = UserDataCollector.getString("Introduce la escala (ej. 1:40)");
		String proveedor = UserDataCollector.getString("Introduce el proveedor");
		int stock = 10;
		String categoria;
		
		String queryContarCategorias = "select count(productLine) from productlines";
		String[] opcionesCategorias = null;
		
		// Ahora insertamos el producto
		StringBuilder sbQuery = new StringBuilder("insert into products ");
		sbQuery.append("(productName, productCode, productDescription, productLine, buyPrice, MSRP, productScale, productVendor, quantityInStock) ");
		sbQuery.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		try (Statement consultaContarCategorias = con.createStatement();
				Statement consultaCategorias = con.createStatement();
				PreparedStatement consultaInsert = con.prepareStatement(sbQuery.toString());) {
			
			ResultSet resultadoContarCategorias = consultaContarCategorias.executeQuery(queryContarCategorias);
			
			while (resultadoContarCategorias.next()) {
				opcionesCategorias = new String[resultadoContarCategorias.getInt(1)];
			}
			
			// Ahora preguntamos la categoría
			String queryCategorias = "select productLine from productlines";
			
			ResultSet resultadosCategorias = consultaCategorias.executeQuery(queryCategorias);
			
			int indice = 0;
			while (resultadosCategorias.next()) {
				opcionesCategorias[indice++] = resultadosCategorias.getString("productLine");
			}
			
			categoria = UserDataCollector.getStringDeOpciones("Selecciona la categoría", opcionesCategorias);
			
			// Ahora asignamos los valores al prepared Statement
			consultaInsert.setString(1, nombre);
			consultaInsert.setString(2, codigo);
			consultaInsert.setString(3, descripcion);
			consultaInsert.setString(4, categoria);
			consultaInsert.setDouble(5, precio);
			consultaInsert.setDouble(6, msrp);
			consultaInsert.setString(7, escala);
			consultaInsert.setString(8, proveedor);
			consultaInsert.setInt(9, stock);
			
			if (consultaInsert.executeUpdate() > 0) {
				System.out.println("El producto se ha insertado con éxito");
			}
			else {
				System.out.println("Ha ocurrido un error al insertar");
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
