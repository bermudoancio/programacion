package tema5;

public class PruebaHerenciaC {
	private int a;

	public PruebaHerenciaC(int a) {
		this.a = a;
	}
	
	public int calcula(int b) {
		return a * b;
	}
	
	public int llamaACalcula(int b) {
		return this.calcula(b);
	}

}
