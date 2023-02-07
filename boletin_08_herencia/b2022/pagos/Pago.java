package boletin_08_herencia.b2022.pagos;

public abstract class Pago implements IPago {

	private double cantidad;
	private TTipoPago tipo;
	
	public Pago(double cantidad, TTipoPago tipo) {
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	@Override
	public double calcularImporte() {
		return this.cantidad * 1 +(tipo.getIncremento() / 100);
		//return this.cantidad + this.cantidad * tipo.getIncremento() / 100;
	}
	
	@Override
	public double calcularIncremento() {
		return this.cantidad * tipo.getIncremento() / 100;
	}

	@Override
	public TTipoPago getTipoPago() {
		return tipo;
	}

}
