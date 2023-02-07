package tema5;

public class PruebaHerenciaD extends PruebaHerenciaC {

	public PruebaHerenciaD(int a) {
		super(a);
	}
	
	public int calcula(int b) {
		return b* b;
	}
	
	public int llamaACalcula(int b) {
		return this.calcula(b);
	}
	
	public static void main(String[] args) {
		PruebaHerenciaC c = new PruebaHerenciaC(2);
		PruebaHerenciaD d = new PruebaHerenciaD(5);
		
		System.out.println(c.llamaACalcula(4));
		System.out.println(d.llamaACalcula(4));
		
		PruebaHerenciaC c2 = d;
		
		System.out.println(c2.llamaACalcula(4));
	}

}
