package boletin_08_herencia;

public class FurgonetaCarga extends Vehiculo {

  //precio de cada kilo de peso máximo autorizado (PMA)
  private static final double INCREMENTO_POR_PMA = 0.5;
  
  //precio máximo autorizado
  private double pma;
  
  
  public FurgonetaCarga(String matricula, Gama gama, TipoCombustible combustible, double pma) throws InvalidValueException {
    super(matricula, gama, combustible);
    
    if(!FurgonetaCarga.isValidPMA(pma)) {
      throw new InvalidValueException("El Peso Máximo Permitido debe ser positivo.");
    }
    
    this.pma = pma;
  }
  
  
  public double getPMA() {
    return this.pma;
  }
  
  
  @Override
  public double getPrecioBase() {
    //se calcula el precio base en función del Peso Máximo Autorizado
    return super.getPrecioBase() + (this.getPMA() * INCREMENTO_POR_PMA);
  }
  
  public static boolean isValidPMA(double pma) {
	  return pma > 0;
  }

}
