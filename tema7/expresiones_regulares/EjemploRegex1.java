package tema7.expresiones_regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjemploRegex1 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[01]+");
		Matcher m = p.matcher("01041001010");
		if (m.lookingAt())
			System.out.println("Si, contiene el patrón");
		else
			System.out.println("No, no contiene el patrón");

	}

}
