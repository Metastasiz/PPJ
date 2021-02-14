package PPJ.Z15;

import java.util.Arrays;

public class Person1 {
    private String name;
    private int age;
    //con
    public Person1(String name, int age) {
        this.name = name; this.age = age;
    }
    //get
    public String getName() {return name;}
    public int getAge() {return age;}
    @Override
    public String toString() {return name + " " + age;}
    int compareTo(Person1 a) {return age - a.age;}
    public static void sort(Person1[] a) {
        for (int i = 0; i < a.length-1; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i].compareTo(a[j])<0) {
                    Person1 temp = a[i]; a[i] = a[j]; a[j] = temp;
                }
    }
    public static void main(String[] arg) {
        Person1[] a = new Person1[4];
        a[0] = new Person1("as ", 23);
        a[1] = new Person1("dd ", 14);
        a[2] = new Person1("cf ", 34);
        a[3] = new Person1("bg ", 22);
        System.out.println("Getters on [0]: " + a[0].getName() + a[0].getAge());
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
