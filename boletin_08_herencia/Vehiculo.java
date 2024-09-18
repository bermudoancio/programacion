package boletin_08_herencia;

public class Vehiculo {
  
  /**
   * enumera las distintas categor�as de gamas existentes
   * @author Peter
   *
   */
  public static enum Gama {
    
    //posibles valores para las distintas gamas
    BAJA(30, "Gama baja"), MEDIA(40, "Gama media"), ALTA(50);
    
    //precio asignado a cada gama
    private double precio;
    private String nombreGama;
    
    //constructor
    private Gama(double precio, String nombre) {

      this.precio = precio;
      this.nombreGama = nombre;

    }

    public 
    
    //devuelve el precio asignado a cada gama
    public double getPrecio() {
      return this.precio;
    }
  }
  
  /**
   * enumera los distintos tipos de combustible disponibles
   * @author Peter
   *
   */
  public static enum TipoCombustible { 
	  GASOLINA, DIESEL 
  }
  
  //gama del veh�culo
  private final Gama gama;
  //combustible usado por el veh�culo
  private final TipoCombustible combustibleUsado;
  //matr�cula del veh�culo
  private String matricula;
  
  
  /**
   * Constructor para veh�culo
   *
   */
  public Vehiculo(String matricula, Gama gama, TipoCombustible combustible) throws InvalidValueException {
    //lanza excepci�n si la matr�cula en null, vacia o solo tiene espacios en blanco
    if(matricula == null || matricula.isEmpty() || matricula.isBlank()) {
      throw new InvalidValueException("Matr�cula inv�lida.");
    }
    //lanza excepci�n si gama o combustible son null
    if(gama == null || combustible == null) {
      throw new InvalidValueException(gama == null ? "Gama es null." : "Tipo de combustible es null.");
    }
    
    this.matricula = matricula;
    this.gama = gama;
    this.combustibleUsado = combustible;
  }
  
  
  public Gama getGama() {
    return this.gama;
  }
  
  public TipoCombustible getTipoCombustibleUsado() {
    return this.combustibleUsado;
  }
  
  public double getPrecioBase() {
    //extrae el precio base en funci�n del tipo de gama al que pertenece
    return this.gama.getPrecio();
  }
  
  public String getMatricula() {
    return this.matricula;
  }
  
  
  public double getPrecio(int dias) throws InvalidValueException {
    if(dias <= 0) {
      throw new InvalidValueException("Se debe alquilar por al menos un d�a.");
    }
    
    return this.getPrecioBase() * dias;
  }
}
