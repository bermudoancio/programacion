package tema5;

public class PruebaHerenciaB extends PruebaHerenciaA {
	int a;
	
	public PruebaHerenciaB(int a1, int a2) {
		super(a1);
		this.a = a2;
	}
	
	@Override
	public int getA() {
		return a;
	}
	
	public static void main(String[] args) {
		PruebaHerenciaB b = new PruebaHerenciaB(1, 2);
		
		System.out.println(b.getA());
	}
}
