package tema8.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import tema8.db.DataBaseConnection;

public class Ejercicio10 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (insertarProducto()){
            System.out.println("El producto se ha insertado con exito");
        } else {
            System.out.println("Hubo un error al insertar el producto");
        }
    }

    public static boolean insertarProducto() {
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             PreparedStatement consultaPreparada = con.prepareStatement("INSERT INTO products values (?,?,?,?,?,?,?,?,?)");
             PreparedStatement consultaCategorias = con.prepareStatement("SELECT productLine from productLines");
             PreparedStatement consultaCodigos = con.prepareStatement("SELECT productCode from products where productCode = ?");
             Statement consulta = con.createStatement()) {

            // Petición del código del producto
            boolean salida = false;
            do {
                System.out.println("Inserte el codigo del producto: ");
                String codigoProducto = sc.nextLine();
                consultaCodigos.setString(1, codigoProducto);
                ResultSet resultadoCodigos = consultaCodigos.executeQuery();
                if (!resultadoCodigos.next()){
                    consultaPreparada.setString(1, codigoProducto);
                    salida = true;
                } else {
                    System.out.println("El código que intentas introducir ya existe en la base de datos");
                }
            }while(!salida);

            System.out.println("Inserte el nombre del producto: ");
            String nombreProducto = sc.nextLine();
            consultaPreparada.setString(2, nombreProducto);

            ResultSet listadoCategorias = consultaCategorias.executeQuery();
            ArrayList<String> arrayCategorias = new ArrayList<>();
            while(listadoCategorias.next()){
                arrayCategorias.add(listadoCategorias.getString(1));
            }
            String[] listaCategoriasArray = new String[arrayCategorias.size()];
            String categoria = UserDataCollector.getStringDeOpciones("Seleccione una de las categorias siguientes:", arrayCategorias.toArray(listaCategoriasArray));
            consultaPreparada.setString(3, categoria);

            System.out.println("Inserte la escala del producto: ");
            String escalaProducto = sc.nextLine();
            consultaPreparada.setString(4, escalaProducto);

            System.out.println("Inserte el vendedor del producto: ");
            String vendedorProducto = sc.nextLine();
            consultaPreparada.setString(5, vendedorProducto);

            System.out.println("Inserte la descripcion del producto: ");
            String descripcionProducto = sc.nextLine();
            consultaPreparada.setString(6, descripcionProducto);

            System.out.println("Inserte el stock del producto: ");
            int cantidadProducto = Integer.parseInt(sc.nextLine());
            consultaPreparada.setInt(7, cantidadProducto);

            System.out.println("Inserte el precio del producto: ");
            float precioProducto = Float.parseFloat(sc.nextLine());
            consultaPreparada.setFloat(8, precioProducto);

            System.out.println("Inserte el MSRP del producto:");
            float msrp = Float.parseFloat(sc.nextLine());
            consultaPreparada.setFloat(9, msrp);

            return consultaPreparada.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
