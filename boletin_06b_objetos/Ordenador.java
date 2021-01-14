package boletin_06b_objetos;

public class Ordenador {
	private PlacaBase placa;
	private Microprocesador micro;
	private DiscoDuro hd;
	private TarjetaGrafica grafica;
	
	public Ordenador(PlacaBase placa, Microprocesador micro, DiscoDuro hd, 
			TarjetaGrafica grafica) throws ParametroInvalidoException {
		
		if (placa.esCompatibleProcesador(micro)) {
			this.placa = placa;
			this.micro = micro;
			this.hd = hd;
			this.grafica = grafica;
		}
		else {
			throw new ParametroInvalidoException("La placa base no es compatible con el microprocesador");
		}
		
	}

	@Override
	public String toString() {
		return "Ordenador [placa=" + placa + ", micro=" + micro + ", hd=" + hd + ", grafica=" + grafica + "]";
	}
	
	
}
