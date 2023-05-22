package tema8.bbdd;

import tema8.db.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio9 {

    /**
     * Crea un programa que acepte como parámetro el nombre de un cliente, y borre
     * de la base de datos todos los datos relativos al mismo, incluyendo los
     * pedidos si hubiese. Realizado con transacciones.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Conecta a la base de datos
        try (Connection con = DataBaseConnection.getInstance().getConnection();
             // Consultas:
//				PreparedStatement consultaFinal = con.prepareStatement("");
             PreparedStatement consultaExisteCliente = con
                     .prepareStatement("SELECT customernumber FROM customers WHERE customerName = ?");
             // El Statement se puede reutilizar creando solo uno
             Statement consultaBorrar = con.createStatement();
             Statement consultaSeleccionaPedidosCliente = con.createStatement();
        		Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduzca el nombre del cliente: ");
            String nombreCliente = sc.nextLine();
            // Sustituye el "?" por el nombre del cliente
            consultaExisteCliente.setString(1, nombreCliente);

            // Marcar que estamos en una transacción.
            con.setAutoCommit(false);
            // Devuelve el resultado de la consulta
            ResultSet resultadoExisteCliente = consultaExisteCliente.executeQuery();
            if (!resultadoExisteCliente.next()) {
                System.out.println("No existe ningún cliente con ese nombre");
                // Anula todo lo que hemos hecho, al no existir el cliente
                con.rollback();
                return;
            }

            try {
                // Recuperamos lo que devolvió la consulta
                int customerNumber = resultadoExisteCliente.getInt(1);
                // Primero vamos a borrar los pagos:
                consultaBorrar.executeUpdate("DELETE FROM payments WHERE customerNumber = " + customerNumber);
                ResultSet resultadoNumeroPedidoDeCliente = consultaSeleccionaPedidosCliente
                        .executeQuery("SELECT ordernumber FROM orders where customerNumber = " + customerNumber);

                while (resultadoNumeroPedidoDeCliente.next()) {
                    consultaBorrar.executeUpdate(
                            "DELETE FROM orderdetails where ordernumber = " + resultadoNumeroPedidoDeCliente.getInt(1));
                }

                consultaBorrar.executeUpdate("DELETE FROM orders WHERE customerNumber = " + customerNumber);
                consultaBorrar.executeUpdate("DELETE FROM customers WHERE customerNumber = " + customerNumber);
                // Todas las consultas de la transacción intermedias se ejecutan
                con.commit();

            } catch (SQLException e) {
                System.out.println("No se ha podido ejecutar la consulta: " + e.getMessage());
                con.rollback();
            }

        } catch (SQLException e) {

        }
    }

}
