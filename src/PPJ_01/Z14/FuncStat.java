package PPJ_01.Z14;

import java.util.Scanner;

public class FuncStat {
    public int t = 0;
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.print("Select task number: ");
        int task = scan.nextInt();
        if (task == 1) {
            int[] a = {1,2,3,7,5,3};
            for (int i = 0; i < 10; i++) System.out.print(fiboR(i) + " ");
            System.out.println();
            for (int i = 0; i < 10; i++) System.out.print(fiboI(i) + " ");
            System.out.println();
            System.out.println(factR(5));
            System.out.println(factI(6));
            System.out.println(gcdR(520, 45));
            System.out.println(gcdI(520, 45));
            System.out.println(maxElem(a, 5));
        }
    }
    public static int fiboR(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (0 <= n && n < 2) return 1;
        return (fiboR(n-1)+fiboR(n-2));
    }
    public static int fiboI(int n) {
        if (n < 0) throw new IllegalArgumentException();
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static int factR(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (0 <= n && n < 1) return 1;
        return n*factR(n-1);
    }
    public static int factI(int n) {
        if (n < 0) throw new IllegalArgumentException();
        int c = 1;
        for (int i = 1; i <= n; i++) c *= i;
        return c;
    }
    public static int gcdR(int a, int b) {
        int c;
        if (a > b) {
            c = a; a = b; b = c;
        }
        if (b%a==0) return a;
        return gcdR(b%a, a);
    }
    public static int gcdI(int a, int b) {
        int c;
        while(a != 0){
            c = b; b = a; a = c%a;
        }
        return b;
    }
    public static int maxElem(int[] a, int b) {
        a[b+1] = a[b] > a[b+1] ? a[b] : a[b+1];
        if (b+1 == a.length-1) return a[b+1];
        b++;
        return maxElem(a, b);
    }
    public static int numEven(int[] a, int b) {
        int c = 0;
        if (a[b]%2==0) c++;
        if (b == a.length-1) return c;
        b++;
        return c + numEven(a, b);
    }
    public static void reverse(int[] a, int b) {
        if (!(b < a.length-b)) return;
        int temp = a[b]; a[b] = a[a.length-1-b]; a[a.length-1-b] = temp;
        b++;
        reverse(a, b);
    }
    public static boolean isPalindrom(String s) {
        if (s.charAt(0)!=s.charAt(s.length()-1)) return false;
        if (s.length()<3) return true;
        s = s.substring(1,s.length()-1);
        return isPalindrom(s);
    }

}
