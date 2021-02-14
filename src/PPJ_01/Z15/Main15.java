package PPJ.Z15;

import PPJ.Z15.Person2;
import PPJ.Z15.Car;
import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main15 {
    public static void main (String[] args) {
        Car[] a = new Car[5];
        a[0] = new Car("rolls", 900);
        a[1] = new Car("bmw", 700);
        a[2] = new Car( "bentz", 800);
        a[3] = new Car("ford", 500);
        a[4] = new Car("audi", 600);
        System.out.println(Arrays.toString(a));
        Person2[] b = new Person2[4];
        b[0] = new Person2("pepe", a[2]);
        b[1] = new Person2("ga", null);
        b[2] = new Person2("cu", a[0]);
        b[3] = new Person2("nt", a[4]);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(Person2.getCars(b)));
        System.out.println(Arrays.toString(Person2.expensiveCars(b,600)));
        System.out.println(b[2].getName());
        System.out.println(b[2].getCar());
        System.out.println(b[2].getCar().getCars());
        System.out.println(b[2].getCar().getPrice());
        System.out.println(b[2]);
    }
}
