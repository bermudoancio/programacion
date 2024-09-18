package tema7.expresiones_regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(abc)");
        String a = ".....";
        Matcher m = p.matcher(a);

        if (m.find()) {
            System.out.println("Si, contiene el patrón");
            System.out.println(m.start());
            System.out.println(m.end());
        }
        else
            System.out.println("No, no contiene el patrón");

        String[] partes = a.split("[,.]");
        System.out.println(partes.length);
        for (String par: partes){
            System.out.println(par);
        }
    }
}
