package tema8.bbdd;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		String usuario="root";
		String password="root";
		try (Connection con = DriverManager.getConnection(url,usuario,password)) {
			
			mostrarProductosPrecioMinimo(con, 60);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void mostrarProductosPrecioMinimo(Connection con, double precioMinimo) {
		
		String query = "SELECTa productCode, productName, buyPrice "
				+ "FROM products "
				+ "WHERE buyPrice <= ? and productName like ?";
		
		if (con != null) {
			try (PreparedStatement consulta = con.prepareStatement(query)) {
				consulta.setDouble(1, precioMinimo);
				consulta.setString(2, "T%");
				ResultSet resultados = consulta.executeQuery();
				
				//ResultSet resultados = consulta.getResultSet();
				while (resultados.next()) {
					String codigo = resultados.getString("productCode");
					String nombre = resultados.getString("productName");
					double precio = resultados.getDouble("buyPrice");
					//Blob a = resultados.getBlob("col");
					
					String queryUpdate = "update products set productName = lower(?) where productCode = ?";
					try (PreparedStatement consultaUpdate = con.prepareStatement(queryUpdate)) {
						consultaUpdate.setString(1, nombre);
						consultaUpdate.setString(2, codigo);
						
						if (consultaUpdate.executeUpdate() > 0) {
							System.out.println("consulta ejecutada con éxito");
						}
						else {
							System.err.println("Se ha producido un error");
						}
					}
					catch (SQLException ex) {
						System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
						System.err.println(ex.getMessage());
					}
					
				}
				
			} catch (SQLException ex) {
				System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
				System.err.println(ex.getMessage() + " - " + ex.getSQLState() + " - " + ex.getErrorCode());
			}
		}
	}

}
