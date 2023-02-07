package boletin_08_herencia.b2022.pagos;

public class PagoOnline extends Pago implements IPago {

	public PagoOnline(double cantidad) {
		super(cantidad, TTipoPago.ONLINE);
	}

}
