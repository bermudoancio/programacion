package boletin_05_2022;

public class Matricula {

	public static void main(String[] args) {
		
		System.out.println(esMatriculaValida("5554mtx"));
		System.out.println(esMatriculaValida("555mtx"));
		System.out.println(esMatriculaValida("5554max"));
		System.out.println(esMatriculaValida("t554mtx"));
	}
	
	public static boolean esMatriculaValida(String matricula) {
		boolean valido = true;
		
		if (matricula.length() != 7) {
			valido = false;
		}
		else {
			String numeroMatricula = matricula.substring(0, 4);
			String letrasMatricula = matricula.substring(4);
			
			for (int i = 0; i < numeroMatricula.length() && valido; i++) {
				if (!Character.isDigit(numeroMatricula.charAt(i))) {
					valido = false;
				}
			}
			String vocales = "aeiou";
			for (int i = 0; i < letrasMatricula.length() && valido; i++) {
				if (!Character.isLetter(letrasMatricula.charAt(i))
						|| vocales.contains(
								String.valueOf(
										Character.toLowerCase(
												letrasMatricula.charAt(i))))) {
					valido = false;
				}
			}
		}
		
		return valido;
	}

}



