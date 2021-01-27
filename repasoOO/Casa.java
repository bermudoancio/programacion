package repasoOO;

public class Casa {
	
	private String calle;
	private int numero;
	private Electrodomestico[] electrodomesticos;
	
	private static double precioM2 = 30;
	private static int numeroCasasConstruidas = 0;
	private static int casasMaximas = 100;
	
	public static void main(String[] args) {
		Casa c = new Casa("Real", 101);
		
		
		for (Electrodomestico el: c.getElectrodomesticos()) {
			try {
				el.encender();
				Thread.sleep(2000);
				el.apagar();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(c.getDineroAPagarPorElectricidad(11.03));
	}
	
	public Casa(String calle, int numero) {
		this.calle = calle;
		this.numero = numero;
		Casa.numeroCasasConstruidas++;
		Casa.casasMaximas--;
		
		this.electrodomesticos = new Electrodomestico[2];
		this.electrodomesticos[0] = new Estufa(1500, "Mi estufa del alma", 3);
		this.electrodomesticos[1] = new Frigorifico(500, "Comilón");
		
	}
	
	public Electrodomestico[] getElectrodomesticos() {
		return this.electrodomesticos;
	}
	
	public static int getNumeroCasasConstruidas() {
		return Casa.numeroCasasConstruidas;
	}
	
	public double getDineroAPagarPorElectricidad(double precioKWh) {
		double totalAPagar = 0;
		
		for (int i = 0; i < this.electrodomesticos.length; i++) {
			
			if (this.electrodomesticos[i] instanceof Estufa) {
				((Estufa) this.electrodomesticos[i]).imprimeEstufa();
			}
			
			double precioAPagarPorEsteElectrodomestico = ((this.electrodomesticos[i].calculaConsumo() / 1000) * precioKWh);
			
			totalAPagar += precioAPagarPorEsteElectrodomestico;
		}
		
		return totalAPagar;
	}
	
}
