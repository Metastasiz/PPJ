package PPJ_01.Z18;

import java.lang.*;

public class StringMisc {;
    public static String norm(String name) {
        String a = "";
        a += Character.toUpperCase(name.charAt(0));
        for (int i = 1; i < name.length(); i++) {
            a += Character.toLowerCase(name.charAt(i));
        }
        return a;
    }
    public static String init(String name) {
        String a = "";
        int b = 0, temp = 0;
        boolean last = false;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                temp++;
                b = i + 1;
                break;
            }
        }
        for (int i = b; i < name.length(); i++) {
            if (last) a += Character.toLowerCase(name.charAt(i));
            if (name.charAt(i) == ' ') {
                temp++;
                last = true;
                a += Character.toUpperCase(name.charAt(i+1));
                i++;
            }
        }
        if (temp > 1) return (Character.toUpperCase(name.charAt(0)) + ". " + Character.toUpperCase(name.charAt(b)) + ". " + a);
        for (int i = b; i < name.length(); i++) {
            if (a == "") a += Character.toUpperCase(name.charAt(i));
            else a += Character.toLowerCase(name.charAt(i));
        }
        return (Character.toUpperCase(name.charAt(0)) + ". " + a);
    }
    public static String tr(String s, String from, String to) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < from.length(); j++) {
                if (s.charAt(i) == from.charAt(j)) {
                    a += to.charAt(j);
                    break;
                }
                if (j == from.length()-1) a += s.charAt(i);
            }
        }
        return a;
    }
    public static void main (String[] args) {
        System.out.println(norm("caravaggio"));
        System.out.println(norm("VERMEER"));
        System.out.println(init("johann sebastian bach"));
        System.out.println(init("i. babeL"));
        System.out.println(init("jorge LUIS BORGES"));
        System.out.println(init("WOLFGANG a. mozart"));
        System.out.println(tr("November 2016","abcdefghijklmnopqrstuvwyz","ABCDEFGHIJKLMNOPQRSTUVWYZ"));
        System.out.println(tr("abcXYZ","aZcX","||Cx"));
    }
}