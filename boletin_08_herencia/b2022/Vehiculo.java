package boletin_08_herencia.b2022;

public abstract class  Vehiculo {

    /*
    Creamos un enum para las gamas de los coches, la cual tiene como atributo el precio por gama, el cual nos sirve
    cuando creamos el constructor le asignamos un valor a cada enumerado.
    y retornamos el precio de la gama el cual después será el precio base.
     */
    public enum GamaCoche{
        BAJA(30), MEDIA(40), ALTA(50);
        //Creamos la variable precioPorGama.
        private double precioPorGama;
        //Creamos un constructor del enum de gamas.
        GamaCoche(double precioPorGama) {
            this.precioPorGama = precioPorGama;
        }
        //Creamos un getter para obtener el precio por gama.
        public double getPrecioPorDia() {
            return precioPorGama;
        }
    }

    /*
    Creamos un enum de carburante, para indicar que tipo de carburante hemos seleccionado.
     */
    public enum Carburante{
        GASOIL(2), GASOLINA(3.5);
        private double precioCarburante;

        Carburante(double precioCarburante){
            this.precioCarburante = precioCarburante;
        }

        public double getPrecioCarburante() {
            return precioCarburante;
        }
    }

    /*
    Creamos los atributos gama, carburante y matricula.
     */

    private static GamaCoche gama;
    private Carburante carburante;
    private String matricula;

    /*
    Creamos el constructor de Vehículo y controlaremos que matricula no sea null o matrícula quitando el espacio o está
    vacío, y después que gama y carburante no sean nulos.
     */
    public Vehiculo(GamaCoche gama, Carburante carburante, String matricula){
        this.gama = gama;
        this.carburante = carburante;
        this.matricula = matricula;
    }

    public GamaCoche getGama() {
        return gama;
    }

    public Carburante getCarburante() {
        return carburante;
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * Método abstracto.
     * @return getPrecioBase();
     */
    public double getPrecioBase(){
        return gama.getPrecioPorDia() + carburante.getPrecioCarburante();
    }

    /**
     * Este método se encarga de calcular el precio por dia
     * @param numDias
     * @return
     * @throws AlquilerVehiculosException
     */
    public double getPrecioTotal(int numDias){
        return getPrecioBase()*numDias;
    }

    @Override
    public String toString() {
        return "gama=" + gama +
                ", carburante=" + carburante +
                ", matricula='" + matricula + '\'';
    }
}
