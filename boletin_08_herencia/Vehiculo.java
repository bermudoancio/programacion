package boletin_08_herencia;

public class Vehiculo {
  
  /**
   * enumera las distintas categorías de gamas existentes
   * @author Peter
   *
   */
  public static enum Gama {
    
    //posibles valores para las distintas gamas
    BAJA(30), MEDIA(40), ALTA(50);
    
    //precio asignado a cada gama
    private double precio;
    
    //constructor
    private Gama(double precio) {
      this.precio = precio;
    }
    
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
  
  //gama del vehículo
  private final Gama gama;
  //combustible usado por el vehículo
  private final TipoCombustible combustibleUsado;
  //matrícula del vehículo
  private String matricula;
  
  
  /**
   * Constructor para vehículo
   *
   */
  public Vehiculo(String matricula, Gama gama, TipoCombustible combustible) throws InvalidValueException {
    //lanza excepción si la matrícula en null, vacia o solo tiene espacios en blanco
    if(matricula == null || matricula.isEmpty() || matricula.isBlank()) {
      throw new InvalidValueException("Matrícula inválida.");
    }
    //lanza excepción si gama o combustible son null
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
    //extrae el precio base en función del tipo de gama al que pertenece
    return this.gama.getPrecio();
  }
  
  public String getMatricula() {
    return this.matricula;
  }
  
  
  public double getPrecio(int dias) throws InvalidValueException {
    if(dias <= 0) {
      throw new InvalidValueException("Se debe alquilar por al menos un día.");
    }
    
    return this.getPrecioBase() * dias;
  }
}
