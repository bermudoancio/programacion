package boletin_08_herencia.b2022.pagos;

public enum TTipoPago {
	EFECTIVO(0.0), TARJETA(5.0), ONLINE(3.0);
	
	private double incremento;
	
	private TTipoPago(double incremento) {
		this.incremento = incremento;
	}
	
	public double getIncremento() {
		return incremento;
	}
}
