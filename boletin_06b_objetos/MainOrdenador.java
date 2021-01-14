package boletin_06b_objetos;

public class MainOrdenador {

	public static void main(String[] args) {
		
		Microprocesador micro = new Microprocesador("Intel", "i7 10500", "LGA-1151", 16, 3.20F);
		PlacaBase placa = new PlacaBase("ASUS", "LGA-1151", "T5000");
		PlacaBase placa2 = new PlacaBase("ASUS", "AM4", "T5000");
		DiscoDuro hd = new DiscoDuro("Seagate", "SSD", 1000);
		TarjetaGrafica grafica = new TarjetaGrafica("Gigabyte", "RTX3800", 16, 3.5F, 16);
		
		try {
			Ordenador o1 = new Ordenador(placa2, micro, hd, grafica);
			System.out.println(o1);
		} 
		catch (ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}

	}

}
