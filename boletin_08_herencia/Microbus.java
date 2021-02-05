package boletin_08_herencia;

public class Microbus extends Vehiculo{

  private static final double PRECIO_POR_PLAZA = 5;
  
  //numero de plazas
  private int plazas;
  
  
  public Microbus(String matricula, Gama gama, TipoCombustible combustible, int numPlazas) throws InvalidValueException {
    super(matricula, gama, combustible);
    
    //TODO: se podría limitar a un rango de valores apropiado
    if(!Microbus.isValidPlazas(numPlazas)) {
      throw new InvalidValueException("El número de plazas debe ser positivo.");
    } 
    
    this.plazas = numPlazas;   
  }
  
  
  public int getPlazas() {
    return this.plazas;
  }
  
  public static boolean isValidPlazas(int plazas) {
	  return plazas > 0 && plazas < 21;
  }
  
  
  @Override
  public double getPrecioBase() {
    //se calcula el precio base en función del númer de plazas y el precio de cada una
    return super.getPrecioBase() + (this.getPlazas() * PRECIO_POR_PLAZA);
  }
}
