package PPJ_01.Z25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Main25 {
}
class RegParen{
    public static void main(String[] arg){
        String str = "Lisboa (Lisbon , Portugal), " +
                "Warszawa (Warsaw,  Poland), and " +
                "Roma (Rome,Italy)";
        String pat = "[(](\\p{L}+).*?[,].*?(\\p{L}+)[)]";
        Matcher m = Pattern.compile(pat).matcher(str);
        while (m.find()) {
            System.out.println(m.group(2) + " --> " + m.group(1));
        }
    }
}
class FirstLast{
    public static void main(String[] arg){
        String text = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("Text.txt"));
            text = new String(bytes, UTF_8);
        }
        catch(IOException e) {
            System.out.println("Problems...");
            System.exit(1);
        }
        text = "Angola, Bahama, Zanzibar, baobab, égalité, ćwierć, pół, Kraśnik";
        String reg = "(?iU)\\b(\\p{L})\\p{L}*?\\1";
        Matcher m = Pattern.compile(reg).matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
class DayMonthYear {
    public static void main(String[] args) {
        String text = "good 2-01-2020 abc \nwrong " + "4/7-2010\ngood 11/11/2011 " +
                "wrong 211/3/1998 jkl\n" +
                "good 13.9.1999 wrong 1.1.20121\n" + "good 11.05.1823, wrong 9_10_2000";
        System.out.println("*** Before\n" + text);
        String r = "\\b(0?[1-9]|[12][0-9]|3[01])(\\p{P})(0?[1-9]|1[012])(\\p{P})(\\d{4})\\b";
        String s = "$5$4$3$2$1";
        text = text.replaceAll(r, s);
        System.out.println("\n*** After\n" + text);
    }
}
class Latex {
    public static void main(String[] args) {
        String text = "Za początek okresu hellenistycznego uznaje się śmierć !emph{Stagiryty}.\\index{Stagiryta} To okres powstania\n" +
                "do dziś żywych koncepcji etycznych: \\emph{epikureizmu} (Epikur,\\index{Epikur} ur. 341, zm. 270 p.n.e.) mówiącego, " +
                "że sensem życia jest doznawanie przyjemności (por. \\emph{hedonizm}) i \\emph{stoicyzmu} (IV wiek p.n.e." +
                "– II n.e.) dającego wzór postawy mędrca wobec śmierci (Zenon z Kition,\\index{Zenon\n" +
                "z Kition} Chryzyp, Seneka, mistrz retoryki Cyceron\n" +
                "i Marek Aureliusz\\index{Marek\n" +
                "Aureliusz}, filozof na tronie). Sceptycy starożytni (Pirron, \\index{Pirron} Sekstus Empiryk)\\index{Sekstus\n" +
                "Empiryk} z pobudek etycznych (uspokojenie umysłu) podawali\n" +
                "w wątpliwość możliwość wszelkiej wiedzy i dali początek wszelkim nurtom sceptycznym. Tomasz z Akwinu\\index{Tomasz z Akwinu} (ur. 1225, zm. 1274)";
        System.out.println("*** Before\n" + text);
        // \command? \index
        String r = "(?s)\\\\index[{](.*?)[}]";
        Matcher m = Pattern.compile(r).matcher(text);
        System.out.println("\n*** After\n");
        while (m.find())
            System.out.println(m.group(1).replaceAll("\\s+", " "));
    }
}
class Test{
    public static void main(String[] arg){
        String text = "asdf something";
        String reg = "\\b\\p{L}+";
        Matcher m = Pattern.compile(reg).matcher(text);
        while (m.find())
            System.out.println(m.group());

    }
}