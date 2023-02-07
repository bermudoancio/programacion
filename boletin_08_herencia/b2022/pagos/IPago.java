package boletin_08_herencia.b2022.pagos;

public interface IPago {
	public double calcularImporte();
	public double calcularIncremento();
	public TTipoPago getTipoPago();
}
