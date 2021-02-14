package PPJ_01.Z20;

public class Two {
    public static void main(String[] args) {
        Car20 car = new Car20();
        while (true) {
            try {
                car.drive100km();
            } catch (NotEnoughGas e) {
                System.out.println("catched");
                System.err.println(e.getMessage());
                car.fill();

            }
        }
    }
}

class Car20{
    public static int fuel = 35, distance = 0;
    public void fill() throws Explosion {
        if((int)(Math.random()*10+1)==1){ throw new Explosion();}
        else{ fuel += (int)(Math.random() * 20 + 15); }
        System.out.println("After filling " + fuel);
    }

    public void drive100km() throws NotEnoughGas{
        if(fuel < 10){ throw new NotEnoughGas(); }
        else{ fuel -= 10; distance += 100; }
        System.out.println(distance + "km driven, " + fuel + " litres left");
    }
}

class NotEnoughGas extends Exception {
    NotEnoughGas() {super();}
    public String getMessage(){return "Only " + Car20.fuel + " liters. Must fill the tank";}
}

class Explosion extends RuntimeException {
    Explosion() {
        super("Exploded: BOOOM or something");
    }
}
