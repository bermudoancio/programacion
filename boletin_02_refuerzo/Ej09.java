package boletin_02_refuerzo;

public class Ej09 {

	public static final int x = 5;
	
	public static void main(String[] args) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
