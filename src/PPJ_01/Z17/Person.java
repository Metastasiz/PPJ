package PPJ.Z17;

public class Person {
    private String name;
    private int year = 1990;
    public Person(String name) {this.name = name;}
    public Person(String name, int year) {this.name = name; this.year = year;}
    public String getName() {return name;}
    public int getBirthYear() {return year;}
    public boolean isFemale() {return name.charAt(name.length()-1) == 'a';}
    public static Person getOlder(Person a, Person b) {return a.year < b.year ? a : b;}
    public boolean isYounger(Person a) {return year > a.year;}
    public static Person getOldest(Person[] a) {
        Person b = a[0];
        for (int i = 0; i < a.length; i++) {if (a[i].year < b.year) b = a[i];}
        return b;
    }
    public static Person getYoungestFemale(Person[] a) {
        Person b = null;
        for (int i = 0; i < a.length; i++) {
            if (a[i].isFemale() && (b == null || a[i].year > b.year)) b = a[i];
        }
        return b;
    }
    @Override
    public String toString() {return name + " born at " + year;}
}
