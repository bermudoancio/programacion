package boletin_05_objetos;

public class Maquina {
	public static final int MAX_CAFE = 50;
	public static final int MAX_LECHE = 50;
	public static final int MAX_VASOS = 80;
	
	public static final double PRECIO_CAFE = 1;
	public static final double PRECIO_LECHE = .8;
	public static final double PRECIO_CAFE_LECHE = 1.5;
	public static final double MINIMO_MONEDERO = 3;
	
	public static final int OPCION_CAFE = 1;
	public static final int OPCION_LECHE = 2;
	public static final int OPCION_CAFE_LECHE = 3;
	public static final int OPCION_ESTADO = 4;
	public static final int OPCION_APAGAR = 5;
	
	private int dosisCafes;
	private int dosisLeche;
	private int vasosRestantes;
	private double monedero;
	
	public Maquina() {
		this.llenarDepositos();
		this.monedero = MINIMO_MONEDERO;
	}
	
	public Maquina(int dosisCafe, int dosisLeche, int vasosIniciales) throws ParametroNoValidoException {
		this.setDosisCafe(dosisCafe);
		
	}
	
	public void llenarDepositos() {
		this.dosisCafes = MAX_CAFE;
		this.dosisLeche = MAX_LECHE;
		this.vasosRestantes = MAX_VASOS;
	}
	
	private void setDosisCafe(int dosis) throws ParametroNoValidoException{
		
		if (dosis <= 0 || dosis > MAX_CAFE) {
			throw new ParametroNoValidoException("No puedo poner dicha cantidad de dosis de café");
		}
		this.dosisCafes = dosis;
	}
	
	public int getDosisCafes() {
		return dosisCafes;
	}
	
	public int getDosisLeche() {
		return dosisLeche;
	}
	
	public int getVasosRestantes() {
		return vasosRestantes;
	}
	
	public double getMonedero() {
		return monedero;
	}
	
	public void vaciarMonedero() {
		this.monedero = MINIMO_MONEDERO;
	}
	
	@Override
	public String toString() {
		String cad = "Estado de la máquina:"
				+ "\nCafés Restantes: " + this.dosisCafes
				+ "\nDosis de leche restantes: " + this.dosisLeche
				+ "\nVasos restantes: " + this.vasosRestantes
				+ "\nRecaudación: " + this.monedero;
		
		return cad;
	}
	
	public String mostrarMenu() {
		return "1. Café solo (" + PRECIO_CAFE + " €)"
				+ "\n2. Leche (" + PRECIO_LECHE + " €)"
				+ "\n3. Café con leche (" + PRECIO_CAFE_LECHE + " €)"
				+ "\n4. Conocer estado de la máquina"
				+ "\n5. Apagar máquina y salir";
	}
	
	public void servirProducto(int opcion) {
		double precioProducto = 0;
		
		// Restamos un vaso
		this.vasosRestantes--;
		
		switch (opcion) {
		case Maquina.OPCION_CAFE:
			this.dosisCafes--;
			precioProducto = PRECIO_CAFE;
			break;
		case Maquina.OPCION_LECHE:
			this.dosisLeche--;
			precioProducto = PRECIO_LECHE;
			break;
		case Maquina.OPCION_CAFE_LECHE:
			this.dosisCafes--;
			this.dosisLeche--;
			precioProducto = PRECIO_CAFE_LECHE;
			break;
		}
		
		// Actualizamos el monedero
		this.monedero += precioProducto;
	}
}
