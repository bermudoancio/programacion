package boletin_05_2022;


public class ComparandoStringYStringBuilder {

	private static final int NUMERO_DE_VECES = 1000000;

	public static void main(String[] args) {
		String resultado;
		
		//resultado=creandoStringV1();
		//System.out.println(resultado);

        resultado=creandoStringConStringBuilder();
        //System.out.println(resultado);
	}

	private static String creandoStringConStringBuilder() {
		long inicio;
		long fin;
		StringBuilder sbuilder = new StringBuilder();
        
		inicio = System.currentTimeMillis();
        for (int i=0; i<NUMERO_DE_VECES; i++) {
            sbuilder.append("A");
        }
        fin = System.currentTimeMillis();
        System.out.println("Tiempo del StringBuilder: " + (fin-inicio));
        
        return sbuilder.toString();
	}

	private static String creandoStringV1() {
		long inicio, fin;
		String cadena = "";
        inicio = System.currentTimeMillis();
        for (int i=0; i<NUMERO_DE_VECES; i++) {
            cadena=cadena + "A";
        }
        fin = System.currentTimeMillis();
        System.out.println("Tiempo del String: " + (fin-inicio));
        
        return cadena;
	}

}
