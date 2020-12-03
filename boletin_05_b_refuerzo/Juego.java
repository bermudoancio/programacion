package boletin_05_b_refuerzo;

import java.util.Random;

public class Juego {
	private Carta[] baraja;
	
	public static void main(String[] args) {
		Juego j = new Juego();
		//j.muestraBaraja();
		
		j.barajar();
		j.barajar();
		j.muestraBaraja();
		
		Juego j2 = new Juego();
		
	}
	
	public Juego() {
		baraja = new Carta[Carta.palos.length * Carta.NUMERO_MAXIMO];
		int numCartas = 0;
		
		for (String palo: Carta.palos) {
			for (int i = Carta.NUMERO_MINIMO; i <= Carta.NUMERO_MAXIMO; i++) {
				Carta c = new Carta(palo, i);
				baraja[numCartas++] = c;
			}
		}
		
	}
	
	public void barajar() {
		Carta[] auxiliar = new Carta[Carta.palos.length * Carta.NUMERO_MAXIMO];
		Random r = new Random();
		for (int i = 0; i < this.baraja.length; i++) {
			int numAlea = r.nextInt(Carta.palos.length * Carta.NUMERO_MAXIMO);
			
			while (auxiliar[numAlea] != null) {
				//numAlea = (numAlea + 1) % (Carta.palos.length * Carta.NUMERO_MAXIMO);
				numAlea++;
				if (numAlea == Carta.palos.length * Carta.NUMERO_MAXIMO) {
					numAlea = 0;
				}
			}
			
			auxiliar[numAlea] = baraja[i];
			
		}
		
		this.baraja = auxiliar;
	}
	
	public void muestraBaraja() {
		for (Carta c: this.baraja) {
			System.out.println(c);
		}
	}
}
