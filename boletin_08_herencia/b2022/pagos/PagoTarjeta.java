package boletin_08_herencia.b2022.pagos;

public class PagoTarjeta extends Pago implements IPago {

	public PagoTarjeta(double cantidad) {
		super(cantidad, TTipoPago.TARJETA);
	}

}
