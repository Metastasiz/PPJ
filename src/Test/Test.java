package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Test {
    public static void main(String[] arg){
        String reg = "(['\"])[^'\"]*\\1";
        String text = "'abc' xx \"def\" yy \"ghi' zz";
        Matcher m = Pattern.compile(reg).matcher(text);
        while (m.find())
            System.out.println(m.group());
    }
}