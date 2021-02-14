package PPJ_01.Z24;

import java.util.Scanner;

public class main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String temp;
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0;
        while (!(temp = scan.nextLine()).equalsIgnoreCase("q")) {
            String[] tmp = temp.split(" ");
            boolean endPunc = false, noNum = true, intRange = false, email = false, date = false;
            int intRangeMin = 34, intRangeMax = 56;
            if (temp.charAt(temp.length()-1) == '!') endPunc = true;
            for (int i = 0; i < temp.length(); i++) {
                if (Character.isDigit(temp.charAt(i))) noNum = false;
            }
            for (String a : tmp) {
                int b;
                boolean emailE = false;
                //
                try { b = Integer.parseInt(a); }
                catch (Exception e) { b = 0; }
                if (b >= intRangeMin && b <= intRangeMax) {intRange = true;}
                //
                String[] checkEmail = a.split("@");
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) == '.'&& checkEmail.length==2) emailE = true;
                }
                if (checkEmail.length==2 && emailE) email = true;
                //
                String[] checkDate = a.split("-");
                if (checkDate.length == 3) {
                    int y, m ,d;
                    try { y = Integer.parseInt(checkDate[0]); }
                    catch (Exception e) { y = 0; }
                    try { m = Integer.parseInt(checkDate[1]); }
                    catch (Exception e) { m = 0; }
                    try { d = Integer.parseInt(checkDate[2]); }
                    catch (Exception e) { d = 0; }
                    if (m > 12) {m = 0;}
                    if (d > 31) {d = 0;}
                    if (y > 0 && m > 0 && d > 0) {date = true;}
                }
            }
            if (endPunc) {counter1++;}
            if (noNum) {counter2++;}
            if (intRange) {counter3++;}
            if (email) {counter4++;}
            if (date) {counter5++;}
            System.out.println("Ending with punc:" + endPunc + ", no number:" + noNum + ", within range:" + intRange + ", has email:" + email + ", has date:" + date);
        }
        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter3);
        System.out.println(counter4);
        System.out.println(counter5);
    }
}
class test24{
    public static void main(String[] arg){
        String a = "23";
        String b = "af";
        int c = 0;
        c = Integer.parseInt(a);
        int d = 0;

        System.out.print(c + " " + d);

    }
}
