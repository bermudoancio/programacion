package boletin_08_herencia.b2022.pagos;

public class PagoEfectivo extends Pago implements IPago {
	
	public PagoEfectivo(double cantidad) {
		super(cantidad, TTipoPago.EFECTIVO);
	}

}
