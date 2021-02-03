package boletin_08_herencia;

public class CuentaCredito extends Cuenta{
  
  private static final double CREDITO_POR_DEFECTO = 100;
  private static final double CREDITO_MAXIMO = 300;
  
  private double credito;
  private double creditoConsumido;
  private int contadorReintegroNoRegistrado;
  private int contadorIngresoNoRegistrado;
  
  
  
  
  public CuentaCredito(String titular) throws CuentaException {
    super(titular);
    this.setCredito(CREDITO_POR_DEFECTO);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }

  
  public CuentaCredito(double saldo, String titular) throws CuentaException {
    super(saldo, titular);
    this.setCredito(CREDITO_POR_DEFECTO);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }
  
  
  public CuentaCredito(double saldo, double credito, String titular) throws CuentaException {
    super(saldo, titular);
    this.setCredito(credito);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }
  
  
  
  public double getCredito() {
    return this.credito;
  }
  
  
  
  private void setCredito(double credito) throws CuentaException {
    if(credito < 0 || credito > CREDITO_MAXIMO) {
      throw new CuentaException("El valor " + credito + " no está aceptado para el crédito.");
    }
    
    this.credito = credito;
  }
  
  
  @Override
  public void realizarReintegro(double monto) throws CuentaException {
    
    if(monto <= 0) {
      throw new CuentaException("Solo se pueden retirar cantidades positivas.");
    }//si el monto es mayor que el saldo del padre + el credito que quede por consumir
    if(monto > (super.getSaldo() + (this.getCredito() - this.creditoConsumido))) {
      throw new CuentaException("Saldo insuficiente.");
    }
    
    double retiro = 0;
    
    //si el saldo del padre es mayor que el monto 
    if(super.getSaldo() >= monto) {
      //entonces lo puede retirar el padre sin problemas
      retiro = monto;
    }
    /* si el saldo del padre es menor que el saldo, entonces hay que comprobar si tiene crédito suficiente 
     * es decir: el saldo del padre es mayor o igual que el monto a retirar menos el crédito restante
     */
    else { 
      //se retira una cantidad igual al saldo, para que quede a cero
      retiro = super.getSaldo();
      //se calcula el crédito consumido con la operación
      this.creditoConsumido += monto - super.getSaldo();
    }
    
    /*
     * se realiza el retiro en la clase padre, pero se filtra el valor del 0 para no lanzar excepción en el padre...
     */
    if(retiro != 0) {
      super.realizarReintegro(retiro);
    }
    else {
      /*
       * Al filtrar el cero no se está llamando al método del padre, y por tanto no se está incrementando el número de 
       * reintegros, así que hace falta llevar un conteo adicional en la clase hija (esta) de los reintegros no registrados
       * en la clase padre.
       */
      this.contadorReintegroNoRegistrado++;
    }
  }
  
  
  @Override
  public int getContadorReintegros() {
    return super.getContadorReintegros() + this.contadorReintegroNoRegistrado;
  }
  
  
  /*
  
  //TODO: hacer
  public void realizarIngreso(double ingreso) throws CuentaException {
    if(ingreso <= 0) {
      throw new CuentaException("Solo pueden ingresarse cantidades positivas.");
    }
    
    if(this.getSaldo() < 0) {
      
      if(ingreso + this.creditoConsumido < )
    }
    
  }
  */
  
  /**
   * El saldo del padre menos el credito consumido hasta el momento
   */
  @Override
  public double getSaldo() {
    return super.getSaldo() - this.creditoConsumido;
  }
  
  
  
  //TODO: quitar saldo padre
  @Override
  public String toString() {
    return String.format("Titular: %s.%nSaldo padre: %.2f%nSaldo: %.2f€%nCrédito total: %.2f%n"
        + "Crédito consumido: %.2f%nReintegros realizados: %d%n", this.getTitular(), 
        super.getSaldo(), this.getSaldo(), this.getCredito(), this.creditoConsumido, this.getContadorReintegros());
  }
}
