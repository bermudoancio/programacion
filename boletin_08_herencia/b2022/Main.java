package boletin_08_herencia.b2022;

import boletin_08_herencia.b2022.EntradaSalida.Lectora;
import java.util.Arrays;


public class Main {
    private static final int MAX_VEHICULOS = 200;
    //Le pongo final para que sea inmutable, ya que main solo lanza y no necesito un constructor.
    private static final Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];

    public static void main(String[] args) {
        int opciones;
        do {
            System.out.println(menu());
            opciones = Lectora.leerEnteroDeRango("Introduce la opción deseada. ", 5, 0);
            opciones(opciones);
        } while (opciones != 4);
    }

    public static void opciones(int opciones) {
        switch (opciones) {
            case 1:
                //Llamada al método darDealtaVehiculo.
                try {
                    darDeAltaVehiculo();
                } catch (AlquilerVehiculosException e) {
                    System.err.println("Error al ingresar vehiculo, algo falló. ");
                    e.printStackTrace();
                }
                break;
            case 2:
                //Llamada a método calcularPrecioVehiculo.
                try {
                    calcularPrecioVehiculo();
                } catch (IllegalArgumentException e) {
                    System.err.println("Error al calcular precio del vehiculo, algo falló. ");
                    e.printStackTrace();
                }
                break;
            case 3:
                imprimir();
                break;
        }
    }

    public static void darDeAltaVehiculo() throws AlquilerVehiculosException {

        boolean correcto = false;
        String tipoVehiculo = "";
        /*
        Pedimos al usuario que seleccione un tipo de vehículo, de los que hemos cuesto en el switch.
         */
        while (!correcto) {
            tipoVehiculo = Lectora.solicitarCadenaMinus("Indica el tipo de vehiculo que quieres dar " +
                    "de alta [ coche, microbús, furgoneta ]");
            switch (tipoVehiculo) {
                case "coche":
                case "microbus":
                case "furgoneta":
                    correcto = true;
            }
        }

        /*
        Pedimos al usuario que introduzca una matricula.
         */
        correcto = false;
        String matricula = "";
        while (!correcto) {
            //Creamos un try Catch para contemplar que no contenga ningún carácter nulo
            try {
                matricula = Lectora.solicitarCadenaMayus("Introduce la matricula del vehiculo. ");
                verificarMatricula(matricula);
                if (!matricula.trim().isEmpty()) {
                    correcto = true;
                }
            } catch (AlquilerVehiculosException e) {
                System.err.println("Algo salió mal al introducir la matricula");
            }
        }

        /*
        Pedimos al usuario que ingrese la gama de vehiculo.
         */
        correcto = false;
        Vehiculo.GamaCoche gamaVehiculo = null;
        String gama;
        while (!correcto) {
            gama = Lectora.solicitarCadenaMayus("Introduce la gama de vehiculo a elegir " +
                    Arrays.toString(Vehiculo.GamaCoche.values()));
            /*
            Creamos el try catch con IllegalArgumentException, para comprobar que no hemos metido un argumento inválido
            esta clase de excepción está predefinida en Java y nos lo indica en la documentación del valueOf.
             */
            try {
                gamaVehiculo = Vehiculo.GamaCoche.valueOf(gama);
                correcto = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Error el valor introducido es incorrecto");
            }
        }
        /*
         Pedimos al usuario que introduzca el tipo de carburante deseado.
         */
        correcto = false;
        Vehiculo.Carburante tipoCarburante = null;
        String carburante;
        /*
        Mientras no sea correcto pedimos al usuario el tipo de carburante, esto lo evaluamos lanzando una excepción
        IllegalArgumentExceptio, quiere decir que si el valor pasado mediante el valueOf no está en el enum entonces
        no es un argumento válido como puede ser un espacio u otro nombre que no sea los contemplados.
         */
        while (!correcto) {
            carburante = Lectora.solicitarCadenaMayus("Introduce el tipo de carburante del vehiculo. " +
                    Arrays.toString(Vehiculo.Carburante.values()));
            try {
                tipoCarburante = Vehiculo.Carburante.valueOf(carburante);
                correcto = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Error el valor introducido es incorrecto");
            }

        }
        /*
        Creamos un switch que dependiendo el tipoVehiculo que le hemos pasado hará unas cosas en cada caso.
        Caso coche: hacemos un new de Vehículo, pero como esta es una clase abstracta tenemos que poner Vehículo v = new
        Coche, si no nos daria un error al generarlo y tampoco nos estaríamos refiriendo a nada, si no recuerdo mal se llamaba
        upCasting
        Caso microbús: nos pide el número de plazas que tiene que tener el bus una vez hemos verificado que es correcto
        el número de plazas vamos a generar el microbús y lo añadiremos a la lista.
        Caso de furgoneta: Nos indica que introduzcamos el precio máximo una vez introducido revisamos que es correcto
        y añadimos el vehículo en cuestión.
         */
        switch (tipoVehiculo) {
            case "coche":
                Vehiculo coche = new Coche(gamaVehiculo, tipoCarburante, matricula);
                addVehiculo(coche);
                break;
            case "microbus":
                correcto = false;
                int numPlazas = 0;
                while (!correcto) {
                    numPlazas = Lectora.leerEnteroPositivo("Introduce el número de plazas del micro bus el" +
                            "el maximo es 16.");
                    if (Microbus.validarPlazas(numPlazas)) {
                        correcto = true;
                    }
                }
                Vehiculo microBus = new Microbus(gamaVehiculo, tipoCarburante, matricula, numPlazas);
                addVehiculo(microBus);
                break;
            case "furgoneta":
                correcto = false;
                int pma = 0;
                while (!correcto) {
                    pma = Lectora.leerEnteroPositivo("Introduce el peso máximo autorizado siendo 3500 el máximo.");
                    if (Furgoneta.validarPma(pma)) {
                        correcto = true;
                    }
                }
                Vehiculo furgoneta = new Furgoneta(gamaVehiculo, tipoCarburante, matricula, pma);
                addVehiculo(furgoneta);
                break;
        }
    }

    /**
     * Este método verifica si hay una matrícula igual a la que le hemos pasado por para metro ya introducido.
     *
     * @param matricula
     * @throws AlquilerVehiculosException
     */
    public static void verificarMatricula(String matricula) throws AlquilerVehiculosException {
        /*
        Hacemos un doble for para verificar todos y cada uno de los espacios de la lista.
        Si hubiera solo un for, solo contemplaría que el primero no sea igual a la matrícula introducida.
        Por lo tanto, si introducimos después del primer vehículo dos más, se podría repetir contraseña
         */
        for (int j = 0; j < listaVehiculos.length; j++) {
            for (int i = 0; i < listaVehiculos.length; i++) {
                if (listaVehiculos[j] != null) {
                    if (listaVehiculos[j].getMatricula().equals(matricula)) {
                        throw new AlquilerVehiculosException("No puedes introducir dos vehiculos con la misma matricula");
                    }
                }
            }
        }
    }

    /**
     * Este método se encarga de calcular el precio del alquiler por dia de los vehículos existente en la  lisita.
     */
    public static void calcularPrecioVehiculo() {

        boolean correcto = false;
        String matricula = "";
        Vehiculo v = null;
        //Si la matricula es correcta el while se acaba.
        while (!correcto) {
            matricula = Lectora.solicitarCadenaMayus("Introduce la matricula del vehiculo. ");
            //Verificamos que la matrícula sea correcta y exista dentro de la lista de vehículos.
            try {
                v = vehiculoBuscado(matricula);
                correcto = true;
            } catch (AlquilerVehiculosException e) {
                System.err.println("Introduce un vehiculo existente. ");
            }
        }
        //Indicamos el número de dias que va a alquilar el coche.
        int numDias = Lectora.leerEnteroPositivo("Introduce el número de dias del alquiler. ");

        System.out.println(v.getPrecioTotal(numDias));

    }

    /**
     * Método al que utilizamos para añadir un vehículo a la lista
     *
     * @param vehiculo
     */
    public static void addVehiculo(Vehiculo vehiculo) {

        boolean espacio = false;
        for (int i = 0; i < listaVehiculos.length && !espacio; i++) {
            if (listaVehiculos[i] == null) {
                espacio = true;
                listaVehiculos[i] = vehiculo;
            }

        }
    }


    //Imprimimos la lista.
    public static void imprimir() {
        String vehiculo = "";
        for (int i = 0; i < listaVehiculos.length; i++) {
            if (!(listaVehiculos[i] == null)) {
                System.out.println(listaVehiculos[i]);
            }
        }
    }

    /**
     * Método que nos busca el vehículo por matrícula.
     *
     * @param matricula
     * @return
     * @throws AlquilerVehiculosException
     */
    public static Vehiculo vehiculoBuscado(String matricula) throws AlquilerVehiculosException {
        boolean encontrado = false;
        Vehiculo vehiculoBuscado = null;
        /*
        Recorremos dos veces el array de vehículos para comparar las matrículas y que no solo nos encuentre el primero.
        Cuando el valor es nulo, es decir no hay ninguna coincidencia con la matrícula lanzaremos una excepción.
         */
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos.length && !encontrado; j++) {
                if (listaVehiculos[i] != null) {
                    if (listaVehiculos[i].getMatricula().equals(matricula)) {
                        vehiculoBuscado = listaVehiculos[i];
                        encontrado = true;
                    }
                } else {
                    throw new AlquilerVehiculosException("Introduce un vehiculo existente.");
                }
            }
        }
        return vehiculoBuscado;
    }

    public static String menu() {
        StringBuilder string = new StringBuilder();
        string.append("Elige una opción: ").append("\n");
        string.append("1. Alta vehiculo. ").append("\n");
        string.append("2. Cálculo del precio del alquiler. ").append("\n");
        string.append("3. Imprimir lista de vehículos. ").append("\n");
        string.append("4. Salir. ");
        return string.toString();
    }
}