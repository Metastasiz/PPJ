package PPJ_01.Z19;

import java.lang.*;

public class main19 {
    public static String swap(String a) {
        if (a.length()%2 != 0) throw new ArithmeticException("length is odd");
        String b = "";
        for (int i = 0; i < a.length()/2; i++) b += a.charAt(a.length()/2+i);
        for (int i = 0; i < a.length()/2; i++) b += a.charAt(i);
        return b;
    }
    public static void checkPW(char[] a) {
        System.out.print("Checking ");
        int counter = 0;
        boolean digit = false, upper = false, lower = false, nonal = false;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            boolean type = true;
            if (Character.isDigit(a[i])) digit = true;
            if (a[i]>='a'&&a[i]<='z') lower = true;
            if (a[i]>='A'&&a[i]<='Z') upper = true;
            if (!Character.isLetter(a[i])&&!Character.isDigit(a[i])) nonal = true;
            for (int j = i+1; j < a.length; j++) if (a[i] == a[j]) type = false;
            if (type) counter++;
        }
        System.out.println();
        if (a.length < 8) System.out.println("at least 8 characters");
        if (counter < 6) System.out.println("at least 6 different characters");
        if (!digit) System.out.println("at least 1 digit");
        if (!upper) System.out.println("at least 1 uppercase letter");
        if (!lower) System.out.println("at least 1 lowercase letter");
        if (!nonal) System.out.println("at least 1 non-alphanumeric character");
        if (a.length >= 8 && counter >= 6 && digit && upper && lower && nonal) System.out.println("OK");
        System.out.println();
    }
    public static int simil(String a, String b) {
        int point = 0;
        String s = b, l = a;
        if (a.length()<b.length()) {s = a; l = b;}
        for (int i = 0; i < l.length()-s.length()+1; i++) {
            int tPoint = 0, temp = 0;
            for (int j = 0; j < s.length(); j++) {
                boolean streak = true;
                if (l.charAt(i+j) == s.charAt(j)) temp ++;
                else {streak = false;}
                if (j == s.length()-1||!streak) {
                    tPoint += temp*temp;
                    temp = 0;
                }
            }
            if (point < tPoint) point = tPoint;
        }
        return point;
    }
    public static void main(String[] arg) {
        char[][] passwords = {
                "AbcDe93".toCharArray(),
                "A1b:A1b>".toCharArray(),
                "Ab:Acb<".toCharArray(),
                "abc123><".toCharArray(),
                "Zorro@123".toCharArray()
        };
        for (char[] a : passwords) {
            checkPW(a);
        }
        String a = "AACTACGTC", b = "ACGTA", c = "GCGC", d = "AGGGCA", e = "AGGC", f = "TGCC";
        System.out.println(a + " and " + b + " -> " + simil(a, b));
        System.out.println(c + " and " + d + " -> " + simil(c, d));
        System.out.println(e + " and " + f + " -> " + simil(e, f));
        System.out.println(swap("pepega! you are "));
    }
}
