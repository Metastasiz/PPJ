package PPJ_01.Z12;

import java.util.Scanner;
import java.util.Arrays;

public class PPJz12 {
    //Student name: Thanondrak Arunsangsirinak, s22130, 12c
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.print("PPJ Class 12; Select task number: ");
        int task = scan.nextInt();
        if (task == 1) {
            System.out.println("task 1:");
            int x = 0;
            do {
                double a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
                System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c +
                        "): hasTwoRoots? " + hasTwoRoots(a, b, c));
                System.out.println("(a, b, c,)=(" + a + ", "+ b + ", " + c + "): monot? " +
                        monot(a,b,c));
                System.out.println("(a, b, c,)=(" + a + ", "+ b + ", " + c + "): maxEl = " +
                        maxEl(a,b,c));
                System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): numPos = " +
                        numPos(a,b,c));
                System.out.print("Enter 0 to exit: ");
                x = scan.nextInt();
            } while (x != 0);
        } else if (task == 2) {
            System.out.println("task 2:");
            int[] a = {1,2,3,4};
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(swapOrder(a)));
        } else if (task == 3) {
            System.out.println("task 3:");
            int[][] b = {
                    {1,2,3,4,5},
                    {2,3,4,5,6},
                    {5,6,7,8,7},
                    {8,9,5,4,8}};
            for (int i = 0; i < b.length; i++) {
                System.out.println(Arrays.toString(b[i]));
            }
            for (int i = 0; i < innerArr(b).length; i++) {
                System.out.println(Arrays.toString(innerArr(b)[i]));
            }
        } else if (task == 4) {
            System.out.println("task 4:");
            final int N = 90;
            final int NUM_OF_SIMULATIONS = 100000;
            int totalBoxes = 0;
            for (int i = 0; i < NUM_OF_SIMULATIONS; i++) {
                totalBoxes += boxesBought(N);
            }
            double aver = totalBoxes/(double)NUM_OF_SIMULATIONS;
            System.out.println("N : " + N);
            System.out.println("NUM_OF_SIMULATIONS : " + NUM_OF_SIMULATIONS);
            System.out.println("Total : " + totalBoxes);
            System.out.println("***** N = " + N);
            System.out.println("Average : " + aver);
            System.out.println("Expected: " + N*harmo(N));
        }
    }
    public static boolean hasTwoRoots(double a, double b, double c) {
        return (a != 0 && ((b * b) - (4 * a * c)) > 0);
    }

    public static boolean monot(double a, double b, double c) {
        return (a < b && b < c)||(a > b && b > c);
    }

    public static double maxEl(double a, double b, double c) {
        return a < b ? (b < c ? c : b) : (a < c ? c : a);
    }

    public static int numPos(double a, double b, double c) {
        //i can do like the upper one but why? why tho? no one can read it
        int temp = 0;
        if (a > 0) temp++;
        if (b > 0) temp++;
        if (c > 0) temp++;
        return temp;
    }
    public static int[] swapOrder(int[] a) {
        int l = 0, h = 0, temp;
        for (int i = 1; i < a.length; i++) {
            if (a[l]>a[i]) l = i;
            if (a[h]<a[i]) h = i;
        }
        temp = a[l]; a[l] = a[h]; a[h] = temp;
        return a;
    }
    public static int[][] innerArr(int[][] a) {
        int[][] out = new int[a.length-2][a[0].length-2];
        for (int i = 1; i < a.length-1; i++) {
            for (int j = 1; j < a[0].length-1; j++) {
                out[i-1][j-1] = a[i][j];
            }
        }
        return out;
    }
    static int boxesBought(int n) {
        boolean[] a = new boolean[n];
        int counter = 0;
        boolean all = false;
        while (!all) {
            int temp = (int) (n*Math.random()); counter++;
            a[temp] = true;
            for (int i = 0; i < n; i++) {
                if (!a[i]) break;
                if (i == n-1) all = true;
            }
        }
        return counter;
    }
    static double harmo(int n) {
        double result = 0;
        for (int i = 1; i <= n; i++) result += 1./i;
        return result;
    }
}

