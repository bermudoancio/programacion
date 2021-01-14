package boletin_06b_objetos;

public class PlacaBase {
	private String marca;
	private String socket;
	private String chipset;
	
	public PlacaBase(String marca, String socket, String chipset) {
		super();
		this.marca = marca;
		this.socket = socket;
		this.chipset = chipset;
	}
	
	public boolean esCompatibleProcesador(Microprocesador micro) {
		return this.socket.equals(micro.getSocket());
	}

	@Override
	public String toString() {
		return "PlacaBase [marca=" + marca + ", socket=" + socket + ", chipset=" + chipset + "]";
	}
}
