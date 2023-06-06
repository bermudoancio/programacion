package boletin1;

//ExecuteQuery solo para el select se hace con un resultset(hayq ue llamar a next().
//ExecuteUpdate insert update y delete y se guardan en un int(nimero de filas afectadas).

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dataBaseConnection.DataBaseConnection;

public class Ej10 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /* -Primer ejercicio/metodo-
        if (insertarProducto()) {
            System.out.println("El producto se ha insertado con exito");
        } else {
            System.out.println("Hubo un error al insertar el producto");
        }
        */

        realizarPedido();

    }

    public static boolean insertarProducto() {
        try (Connection con = DataBaseConnection.getInstance().getCon();
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
                if (!resultadoCodigos.next()) {
                    consultaPreparada.setString(1, codigoProducto);
                    salida = true;
                } else {
                    System.out.println("El código que intentas introducir ya existe en la base de datos");
                }
            } while (!salida);

            System.out.println("Inserte el nombre del producto: ");
            String nombreProducto = sc.nextLine();
            consultaPreparada.setString(2, nombreProducto);

            ResultSet listadoCategorias = consultaCategorias.executeQuery();
            ArrayList<String> arrayCategorias = new ArrayList<>();
            while (listadoCategorias.next()) {
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

            if (consultaPreparada.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean realizarPedido() {


        try (Connection con = DataBaseConnection.getInstance().getCon();
             PreparedStatement consultaInsertarPedido = con.prepareStatement
                     ("INSERT INTO Orders values (?,now(),date_add(NOW(),interval 7 DAY),null,'In Process',null,?)");
             Statement seleccionNumPedidoMax = con.createStatement();
             PreparedStatement consultaLineaPedidos = con.prepareStatement
                     ("SELECT * FROM orderdetails where orderNumber = ? and productCode = ?");
             PreparedStatement updatePedido = con.prepareStatement
                     ("UPDATE orderdetails SET quantityOrdered = quantityOrdered + ? where orderNumber = ? and productCode = ?");
             PreparedStatement insertIntoPedido = con.prepareStatement
                     ("INSERT INTO orderdetails VALUES (?,?,?,?,?)");
             PreparedStatement updateStock = con.prepareStatement
                     ("UPDATE products SET quantityInStock = quantityInStock - ? WHERE productCode = ?");
             PreparedStatement updateCreditLimit = con.prepareStatement
                     ("UPDATE customers SET creditlimit = creditlimit - ? WHERE customerNumber = ?");
        ) {

            try {
                int numCliente = getNumeroCliente(con);
                double creditoCliente = getCreditoCliente(con, numCliente);
                String continuar = "Si";

                if (creditoCliente == 0) {
                    System.out.println("El cliente no dispone de crédito para realizar pedidos");
                } else {
                    //Esta es una transaccion , para que cada consulta que haga se mande al servidor, de modo que cada vez
                    // que se añada un producto se actualice en el servidor
                    con.setAutoCommit(false);

                    ResultSet rsNumPedido = seleccionNumPedidoMax.executeQuery("SELECT MAX(orderNumber) from orders");
                    rsNumPedido.next();
                    int numPedido = rsNumPedido.getInt(1) + 1;

                    consultaInsertarPedido.setInt(1, numPedido);
                    consultaInsertarPedido.setInt(2, numCliente);
                    if (consultaInsertarPedido.executeUpdate() != 1) {
                        con.rollback();
                        return false;
                    }

                    int contadorNumLineas = 1;

                    while (continuar.equalsIgnoreCase("Si")) {
                        String categoria = getCategoria(con);
                        String codProducto = getCodProducto(con, categoria);
                        int cantidad = getCantidadProducto(con, codProducto);
                        if (cantidad > 0) {
                            double precio = getPrecioProducto(con, codProducto);
                            if (cantidad * precio < creditoCliente) {
                                creditoCliente = creditoCliente - (cantidad * precio);

                                //Consultamos el num de pedido y cod de producto, para a continuacion comprobar que no
                                // está duplicado ya que daria error por ejemplo si añadimos 10 del producto A y a
                                // continuacion volvemos a añadir otros 10 del producto A
                                consultaLineaPedidos.setInt(1, numPedido);
                                consultaLineaPedidos.setString(2, codProducto);

                                ResultSet rsLineaPedidos = consultaLineaPedidos.executeQuery();

                                //Si encuentra un registro ya introducido lo actualiza, en caso contrario inserta uno nuevo
                                if (rsLineaPedidos.next()) {
                                    updatePedido.setInt(1, cantidad);
                                    updatePedido.setInt(2, numPedido);
                                    updatePedido.setString(3, codProducto);

                                    int resultadoUpdate = updatePedido.executeUpdate();

                                } else {
                                    insertIntoPedido.setInt(1, numPedido);
                                    insertIntoPedido.setString(2, codProducto);
                                    insertIntoPedido.setInt(3, cantidad);
                                    insertIntoPedido.setDouble(4, precio);
                                    insertIntoPedido.setInt(5, contadorNumLineas++);

                                    int resultadoInsert = insertIntoPedido.executeUpdate();
                                }

                                updateStock.setInt(1, cantidad);
                                updateStock.setString(2, codProducto);
                                int resultadoUpdateStock = updateStock.executeUpdate();

                                updateCreditLimit.setDouble(1, cantidad * precio);
                                updateCreditLimit.setInt(2, numCliente);
                                int resultadoUpdateCreditLimit = updateCreditLimit.executeUpdate();

                                System.out.println("El producto ha sido añadido al carrito");

                            } else {
                                System.out.println("No dispone de suficiente credito");
                            }
                        }

                        continuar = UserDataCollector.getStringDeOpciones("¿Quiere continuar?", new String[]{"Si", "No"});

                    }
                    con.commit();
                    System.out.println("Gracias por su compra");
                }

            } catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("Ha ocurrido el error: " + e.getMessage());
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido realizar la conexion");
        }

        return true;
    }

    /**
     * Este método pide un numero de cliente al usuario, comprobando si existe en la BD y devolviendolo
     *
     * @param con - Conexion a la base de datos que tenemos que proporcionar.
     * @return - numero del cliente
     */
    public static int getNumeroCliente(Connection con) {
        try (Statement consultaClientes = con.createStatement()) {

            //Consultamos los numeros y nombres de todos los clientes
            ResultSet resultadoClientes = consultaClientes.executeQuery("SELECT customerNumber, customerName from customers");

            //Creamos un HasMap para guardar los numeros de cliente de nuestros clientes, y así posteriormente acceder
            // rapidamente al nombre del cliente segun su numero de cliente

            HashMap<Integer, String> arrayClientes = new HashMap<>();

            while (resultadoClientes.next()) {
                System.out.printf("%d : %s\n", resultadoClientes.getInt("customerNumber"),
                        resultadoClientes.getString("customerName"));

                //Anhadimos al HasMap el num de cliente de todos los clientes y el nombre asociado.
                arrayClientes.put(resultadoClientes.getInt("customerNumber"),
                        resultadoClientes.getString("customerName"));
            }

            int numCliente = -1;
            //Mientras que el HasMap no contenga el numero de cliente escrito por teclado sigue pidiendolo
            do {
                System.out.println("Elija uno de los clientes");
                numCliente = Integer.parseInt(sc.nextLine());

                //Mientras que el array no contenga el cliente escrito por teclado saltará el siguiente mensaje
                if (!arrayClientes.containsKey(numCliente)) {
                    System.out.println("El cliente introducido no se encuentra en la base de datos");
                } else {
                    //Al pedirle la clave numCliente nos devuelve el valor asociado a esa clave, en este caso el nombre.
                    System.out.println("Se ha seleccionado el cliente numero " + arrayClientes.get(numCliente));
                }
            } while (!arrayClientes.containsKey(numCliente));

            return numCliente;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Este metodo nos muestra todas las categorias y nos pide que introduzcamos una
     *
     * @param con
     * @return
     */
    public static String getCategoria(Connection con) {

        try (Statement consultaCategorias = con.createStatement()) {

            ResultSet listadoCategorias = consultaCategorias.executeQuery("SELECT productline , textDescription from productLines");

            HashMap<String, String> mapCategorias = new HashMap<>();

            while (listadoCategorias.next()) {
                System.out.printf("%s : %s\n", listadoCategorias.getString("productline"),
                        listadoCategorias.getString("textDescription"));

                //Anhadimos al HasMap el num de cliente de todos los clientes y el nombre asociado.
                mapCategorias.put(listadoCategorias.getString("productline"),
                        listadoCategorias.getString("textDescription"));
            }

            String nombreCategoria;
            //Mientras que el HasMap no contenga el numero de cliente escrito por teclado sigue pidiendolo
            do {
                System.out.println("Elija una de las siguientes categorias: ");
                nombreCategoria = sc.nextLine();

                //Mientras que el array no contenga el cliente escrito por teclado saltará el siguiente mensaje
                if (!mapCategorias.containsKey(nombreCategoria)) {
                    System.out.println("La categoria introducida no se encuentra en la base de datos");
                } else {
                    //Al pedirle la clave numCliente nos devuelve el valor asociado a esa clave, en este caso el nombre.
                    System.out.println("Se ha seleccionado la categoria " + nombreCategoria);
                }
            } while (!mapCategorias.containsKey(nombreCategoria));

            return nombreCategoria;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Este metodo nos mostrará los productos de una categoria pedida por parametro,
     * y luego nos pedira el cod producto de uno de los productos
     *
     * @param con       - conexion a la BD
     * @param categoria - Categoria a la que van a pertenecer los productos
     * @return - devuelve el cod de producto seleccionado
     */
    public static String getCodProducto(Connection con, String categoria) {

        try (PreparedStatement consultaProductos = con.prepareStatement
                ("SELECT productCode, productName, MSRP from products WHERE productLine = ?")) {

            consultaProductos.setString(1, categoria);
            ResultSet listadoProductos = consultaProductos.executeQuery();

            ArrayList<String> arrayProductos = new ArrayList<>();

            while (listadoProductos.next()) {
                System.out.printf("%s : %s : %s \n", listadoProductos.getString("productCode"),
                        listadoProductos.getString("productName"),
                        listadoProductos.getString("MSRP"));


                arrayProductos.add(listadoProductos.getString("productCode"));
            }

            String codProducto;
            //Mientras que el array no contenga el numero de producto escrito por teclado sigue pidiendolo
            do {
                System.out.println("Introduzca el codigo del producto: ");
                codProducto = sc.nextLine();

                //Mientras que el array no contenga el codigo de producto escrito por teclado saltará el siguiente mensaje
                if (!arrayProductos.contains(codProducto)) {
                    System.out.println("El codigo de producto introducido no se encuentra en la base de datos");
                }

            } while (!arrayProductos.contains(codProducto));

            return codProducto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Este método nos devuelve la cantidad en Stock que hay de un producto, buscándolo por su codProducto
     *
     * @param con
     * @param codProducto
     * @return
     */
    public static int getCantidadProducto(Connection con, String codProducto) {

        int cantidadProducto = 0;

        try (PreparedStatement consultaStock = con.prepareStatement
                ("SELECT quantityInStock from products WHERE productCode = ?")) {

            consultaStock.setString(1, codProducto);
            ResultSet stockProductos = consultaStock.executeQuery();

            //No necesitamos un While ya que únicamente nos va a devolver 1 fila.
            stockProductos.next();
            int stock = stockProductos.getInt("quantityInStock");
            System.out.printf("Stock que queda del producto: %d\n", stock);

            //Comprobamos que haya stock. En caso afirmativo pedimos cuantos productos desea comprar el cliente y
            // controlamos que no pida más productos que los que hay en Stock y tampoco pida una cantidad negativa.
            if (stock == 0) {
                System.out.println("No quedan unidades del producto");
            } else {
                do {
                    System.out.println("Introduzca la cantidad del producto que desea comprar:");
                    cantidadProducto = Integer.parseInt(sc.nextLine());
                    if (cantidadProducto > stock) {
                        System.out.println("No queda suficiente Stock del producto");
                    }
                    if (cantidadProducto < 0) {
                        System.out.println("Debe comprar al menos una unidad del producto");
                    }
                } while (cantidadProducto > stock || cantidadProducto < 0);
            }

            return cantidadProducto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Este método devuelve el crédito de un cliente según su numCliente
     *
     * @param con
     * @param numCliente
     * @return
     */
    public static double getCreditoCliente(Connection con, int numCliente) {

        try (PreparedStatement consultaCredito = con.prepareStatement
                ("SELECT creditLimit from customers WHERE customerNumber = ?")) {

            consultaCredito.setInt(1, numCliente);
            ResultSet creditoCliente = consultaCredito.executeQuery();
            creditoCliente.next();
            double credito = creditoCliente.getDouble(1);

            return credito;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Método que nos devuelve el precio de un producto según su código
     *
     * @param con
     * @param codProducto
     * @return
     */
    public static double getPrecioProducto(Connection con, String codProducto) {
        double precioProducto = 0;

        try (PreparedStatement consultaPrecio = con.prepareStatement
                ("SELECT MSRP from products WHERE productCode = ?")) {

            consultaPrecio.setString(1, codProducto);
            ResultSet rsPrecioProductos = consultaPrecio.executeQuery();

            //No necesitamos un While ya que únicamente nos va a devolver 1 fila.
            rsPrecioProductos.next();
            precioProducto = rsPrecioProductos.getDouble(1);

            return precioProducto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}