package PPJ;

import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;

public class PPJz13 {
    //Student name: Thanondrak Arunsangsirinak, s22130, 12c
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.print("PPJ Class 10; Select task number: ");
        int task = scan.nextInt();
        if (task == 1) {
            int x = 2, y = 3, z = 1;
            System.out.println("Max of " + x + ", " + y + ", " + z + " is " + maxOfThree(x, y, z));
            for (int a = 12; a < 16; ++a) System.out.println("Greatest divisor of " + a + " is " + greatestDivisor(a));
            for (int m = 11, n = 5; m >= 3; m -= 2, n += 2)
                if (areRelativelyPrime(m, n)) System.out.println(m + " and " + n + " are relatively prime");
            for (int m = 2; m <= 100; ++m)
                if (isPerfect(m)) System.out.println(m + " is perfect");
        } else if (task==2) {
            System.out.print("Number of rolls: ");
            int n = scan.nextInt();
            int first = 0, nine = 0;
            for (int i = 1; i <= n; i++) {
                if (roll() == 1) first++;
                if (roll() >= 90) nine++;
            }
            double f = 100*(double)first/n;
            double ni = 100*(double)nine/n;
            System.out.println("At first: " + f + "% at " + first + " times \nAt 90 or more: " + ni + "% at " + nine + " times");
        } else if (task==3) {
            int[][][] opers = {
                    { {100, -50, 25}, {150,-300}, {300,-90,100} }, { {90, -60, 250}, {300,20,-100} },
                    { {20, 50}, {300}, {20,-20,40}, {100,-200} }
            };
            int[] a = new int[opers.length];
            for (int i = 0; i < opers.length; i++) {
                for (int j = 0; j < opers[i].length; j++) {
                    for (int k = 0; k < opers[i][j].length; k++) {
                        a[i] += opers[i][j][k];
                    }
                }
            }
            System.out.print(Arrays.toString(a));
        } else if (task==4) {
            String[] isbns = {
                    "960-425-059-0", "80-902744-1-6", "85-359-0277-5", "0-8044-2958-X", "0-943396-04-2", "0-9752298-0-5", "9971-5-02l0-0", "93-8654--21-4", "99921-588-107",
            };
            for (int i = 0; i < isbns.length; ++i)
                checkISBN(isbns[i]);
        }
    }
    static int maxOfThree(int a, int b, int c) {
        return a < b ? (b < c ? c : b) : (a < c ? c : a);
    }
    static int greatestDivisor(int n) {
        int temp = 1;
        if (n%2==0) return n/2;
        for (int i = 3; i <= n/3; i+=2) {
            temp = i;
        }
        return temp;
    }
    static boolean areRelativelyPrime(int a, int b) {
        while (a!=b || a!=1 || b!=1) {
            if (a > b)a -= b;
            if (b > a)b -= a;
        }
        if (a==1||b==1) return true;
        return false;
    }
    static boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i < n; i++) if (n%i==0) sum += i;
        return (sum == n);
    }
    private static int roll() {
        int counter = 0, roll = 0;
        while (roll!=12) {
            roll = 0;
            roll += (int)(6*Math.random()+1) + (int)(6*Math.random()+1); counter++;
        }
        return counter;
    }
    static void checkISBN(String isbn) {
        String b = isbn;
        String er1 = "ERROR: Too many digits", er2 = "ERROR: Too few digits", er3 = "ERROR: Invalid character", er4 = "ERROR: Last digit should be ";
        int a, pos = 10, res = 0, temp;
        System.out.print(b + ": ");
        for (int i = 0; i < b.length(); i++) {
            a = 0; a += (b.charAt(i))-48;
            if (a >= 0 && a <= 9) res += a*pos;
            //System.out.println(res + "," + a + "," + pos + "," + i);

            if (b.charAt(i)=='-') continue;
            if (pos==1&&res%11!=0&&i == b.length()-1) {
                if (!(a >= 0 && a <= 9)) a = 0;
                if (a-res%11>=0) {System.out.print(er4); System.out.print(a-res%11);}
                else if (a+(11-res%11)<=9) {System.out.print(er4); System.out.print(a+(11-res%11));}
                else { System.out.print(er4); System.out.print("X"); }
                break;
            }
            if (pos == 1 && i < b.length()-1){ System.out.print(er1);break; }
            if (pos > 1 && i == b.length()-1) { System.out.print(er2);break; }
            if (a < 0 || a > 9) { System.out.print(er3); System.out.print(" " + b.charAt(i));break; }
            if (pos == 1) System.out.print("OK");

            pos--;
        }
        System.out.println();
    }
}

