package PPJ.Z15;

public class Car {
    private String car;
    private int price;
    public Car(String car, int price) {
        this.car = car; this.price = price;
    }
    public String getCars() {return car;}
    public int getPrice() {return price;}
    @Override
    public String toString() {return car + " at " + price;}
}
