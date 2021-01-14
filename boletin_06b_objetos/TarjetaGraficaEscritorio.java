package boletin_06b_objetos;

public class TarjetaGraficaEscritorio extends TarjetaGrafica {

	private int numeroSlotsPCIE;
	
	public TarjetaGraficaEscritorio(String marca, String modelo, int numeroNucleos, 
			float velocidad, int memoria, int numSlotsPCIE) {
		
		 super(marca, modelo, numeroNucleos, velocidad, memoria);
		 this.numeroSlotsPCIE = numSlotsPCIE;
	}
}
