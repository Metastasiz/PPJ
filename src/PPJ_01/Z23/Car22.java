package PPJ_01.Z23;

class Car22 {
    public static void main(String[] arg) {
        String name1 = "name", name2 = "adf";
        int price1 = 1, price2 = 3;
        Car22 c = new Car22(name1, price1);
        //Sysc.getMake();
        Car22 b = new Car22(name2, price2, c);
        //b.getMake();
        b.showCars();
    }

    String make;
    int price;
    Car22 next;

    public Car22(String m, int p, Car22 n) {
        make = m;
        price = p;
        this.next = n;
    }

    public Car22(String m, int p) {
        make = m;
        price = p;
    }

    public String getMake() {
        return make;
    }

    public int getPrice() {
        return price;
    }

    public Car22 getNext() {
        return next;
    }

    public void showCars() {
        Car22 output = this;
        while (output != null) {
            System.out.println(output.make + " " + output.price);
            output = output.next;
        }
    }

    static class Person22 {
        String name;
        Car22 car = null;
    }
}
