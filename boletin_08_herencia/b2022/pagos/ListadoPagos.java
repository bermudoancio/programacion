package boletin_08_herencia.b2022.pagos;

public class ListadoPagos {
	
	private IPago[] pagos;
	
	public ListadoPagos(IPago[] pagos) {
		super();
		this.pagos = pagos;
	}
	
	public double calcularTotal() {
		double total = 0;
		for (IPago p: pagos) {
			total += p.calcularImporte();
		}
		return total;
	}
	
	public int contarTipoPago(TTipoPago t) {
		int total = 0;
		for (IPago p: pagos) {
			if (p.getTipoPago() == t) {
				total++;
			}
		}
		return total;
	}
	
	public double calcularTotalIncremento() {
		double total = 0;
		for (IPago p: pagos) {
			total += p.calcularIncremento();
		}
		return total;
	}

	public static void main(String[] args) {
		IPago[] pagos = {
			new PagoEfectivo(34.6),
			new PagoEfectivo(99.2),
			new PagoTarjeta(23),
			new PagoOnline(67.34)
		};
		
		ListadoPagos l = new ListadoPagos(pagos);
		System.out.println(l.calcularTotal());
		System.out.println(l.contarTipoPago(TTipoPago.TARJETA));
		System.out.println(l.calcularTotalIncremento());
	}

}
