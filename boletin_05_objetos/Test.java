package banco;

public class Test {

  public static void main(String[] args) {

    CuentaCredito cuenta;
    
    try {
      cuenta = new CuentaCredito(500, 300, "pepino");
      System.out.println(cuenta);
      sacar(200, cuenta);
      sacar(200, cuenta);
      sacar(200, cuenta);
      sacar(150, cuenta);
      sacar(50, cuenta);
      sacar(0.001, cuenta);
    } catch (CuentaException e) {
      e.printStackTrace();
    }
  }

  
  private static void sacar(double cantidad, CuentaCredito cuenta) throws CuentaException {
    cuenta.realizarReintegro(cantidad);
    System.out.printf("Realizado reintegro de %.2f. El estado de la cuenta es: %n%s%n", cantidad, cuenta);
  }
}
