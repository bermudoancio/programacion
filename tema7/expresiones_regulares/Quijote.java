package tema7.expresiones_regulares;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quijote {

    public static void main(String[] args) {
        System.out.println("    \\t     d   ".split("[\\s\\t]+").length);
    }

    public static void main2(String[] args) {
        File f = new File("./expresiones_regulares/quijote.txt");
        File f2 = new File("./expresiones_regulares/quijote2.txt");

        Pattern p = Pattern.compile("\\b(\\p{L}+)\\d*\\b");
        Pattern p2 = Pattern.compile("(\\b\\p{L})(\\p{L}*\\d*\\b)");
        Pattern p3 = Pattern.compile("\\p{L}+");

        try(BufferedReader br = new BufferedReader(new FileReader(f));
        PrintWriter pw = new PrintWriter(f2)){
            String linea;
            while ((linea = br.readLine()) != null){
                Matcher m = p.matcher(linea);
                if(m.results().count() > 15){
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
