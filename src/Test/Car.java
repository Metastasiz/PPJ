public class Car {
    private int fuel, milage ;

    public Car(){
        this.fuel = 35;
        this.milage=0;
    }

    public void fill(){
        int chance = (int)(Math.random() * 10);
        if (chance < 1) {
            throw new Explosion("boom");
        }else{
         this.fuel += (int)((Math.random()*20)+15);
         System.out.println("Current fuel: "+ this.fuel);
        }
    }
    public void drive100km() throws NotEnoughGas{
        if(this.fuel <10) throw new NotEnoughGas("You outta juice");
        else{
            this.fuel -= 10;
            this.milage += 100;
            System.out.println("Current milage: "+this.milage+"\nCurrent fuel: "+this.fuel);
        }
    }

    public static void main(String[] args){
        Car car = new Car();
        while(true){
            try{
                car.drive100km();
            }catch(NotEnoughGas e){
                System.err.println(e.getMessage());
                car.fill();
            }
        }
    }
}
class NotEnoughGas extends Exception {
    NotEnoughGas(String a) {super(a);}
}

class Explosion extends RuntimeException {
    Explosion(String a) {
        super(a);
    }
}

