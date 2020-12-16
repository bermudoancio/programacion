package boletin_07_string;

public class Ej4 {

	public static void main(String[] args) {
		String frase = "shybaoxlna";
		String palabraOculta = "hola";
		boolean encontrado = false;
		
		int indicePalabraOculta = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == palabraOculta.charAt(indicePalabraOculta)) {
				indicePalabraOculta++;
				if (palabraOculta.length() == indicePalabraOculta) {
					encontrado = true;
				}
			}
		}
		
		System.out.println(encontrado ? "Se ha encontrado" : "No se ha encontrado");

	}

}
