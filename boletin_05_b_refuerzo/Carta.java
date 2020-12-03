package boletin_05_b_refuerzo;

public class Carta {
	public static final String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
	public static final int NUMERO_MINIMO = 1;
	public static final int NUMERO_MAXIMO = 12;
	
	private String palo;
	private int numero;
	
	public Carta(String palo, int numero) {
		if (encuentraPalo(palo)) {
			this.palo = palo;
		}
		
		if (numero >= NUMERO_MINIMO && numero <= NUMERO_MAXIMO) {
			this.numero = numero;
		}
	}
	
	/**
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	
	public static boolean encuentraPalo(String palo) {
		boolean enc = false;
		int i = 0; 
		while (i < Carta.palos.length && !enc) {
			if (Carta.palos[i].equals(palo)) {
				enc = true;
			}
			
			i++;
		}
		
		return enc;
	}

	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", numero=" + numero + "]";
	}
	
	
}
