package clase.herencia;

public abstract class Coche extends VehiculoMotorizado implements Comparable<Coche> {
	
	private int numeroPuertas;
	private int caballosPotencia;
	private TColores color;
	
	public enum TColores {
		NEGRO, GRIS
	}
	
	public Coche(int numeroRuedas, int numeroPasajeros, int numeroPuertas, TColores color) {
		super(numeroRuedas, numeroPasajeros);
		this.numeroPuertas = numeroPuertas;
		this.color = color;
	}
	
	public int getNumeroPuertas() {
		return this.numeroPuertas;
	}
	
	public int compareTo(Coche c) {
		if (this.caballosPotencia > c.getCaballos()) {
			return 1;
		}
		else if (this.caballosPotencia < c.getCaballos()) {
			return -1;
		}
		else {
			return 0;
		}
		// return this.caballosPotencia - c.getCaballos();
	}
	
	public int getCaballos() {
		return this.caballosPotencia;
	}
		
	private void meterLlave() {
		System.out.println("Llave dentro");
	}
	
	public void claxon() {
		String a;
		//super.claxon();
		System.out.println("Claxon en coche");
	}
	
	public void tocarClaxonPropio() {
		this.claxon();
	}
	
	public void tocarClaxonPadre() throws ParametroInvalidoException {
		super.claxon();
	}
	
	public TColores getColor() {
		return color;
	}
	
}
