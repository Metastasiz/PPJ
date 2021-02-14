package PPJ.Z14;

import java.util.Arrays;

public class NotString {
    public static void main (String[] args) {
        String[] arr = {"Kate", "Beb", "Mary", "Bea", "Zoe"};
        System.out.println(Arrays.toString(arr)); sortSel(arr); System.out.println(Arrays.toString(arr));
    }
    public static boolean isLess(String a, String b) {
        if (a.length() == b.length()) return (a.compareTo(b) > 0);
        return (a.length() > b.length());
    }

    static void sortSel(String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j=i+1; j < a.length; j++) {
                String temp = a[i];
                if (isLess(a[i],a[j])) {a[i] = a[j]; a[j] = temp;}
            }
        }
    }
}
