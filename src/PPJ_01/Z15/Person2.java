package PPJ_01.Z15;

public class Person2 {
    private String name;
    private Car car;
    public Person2(String name, Car car) {
        this.name = name; this.car = car;
    }
    public String getName() {return name;}
    public Car getCar() {return car; }
    @Override
    public String toString() {return name + " has " + car;}

    public static Car[] getCars(Person2[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) if (a[i].getCar() != null) temp++;
        Car[] b = new Car[temp];
        temp = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i].getCar() != null) {
                b[temp] = a[i].getCar();
                temp ++;
            }
        return b;
    }
    public static Car[] expensiveCars(Person2[] a, int k) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) if (a[i].getCar() != null && a[i].getCar().getPrice() > k) temp++;
        Car[] b = new Car[temp];
        temp = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i].getCar() != null && a[i].getCar().getPrice() > k) {
                b[temp] = a[i].getCar();
                temp ++;
            }
        return b;
    }
}
