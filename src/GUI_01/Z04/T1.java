package GUI_01.Z04;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class T1 {
    public static void main(String[] arg){
        Person smith = new Person("Oliver", "Smith");
        Person jones = new Person("Jack", "Jones");
        Person harry = new Person("Harry", "Williams");
        Person jacob = new Person("Jacob", "Brown");
        Car skoda1 = new Car("WA00001", Car.Brand.SKODA);
        Car skoda2 = new Car("SC36010", Car.Brand.SKODA);
        Car mazda1 = new Car("WA01234", Car.Brand.MAZDA);
        Car mazda2 = new Car("DW01ASD", Car.Brand.MAZDA);
        Car bmw = new Car("WA12690", Car.Brand.BMW);
        Car volvo = new Car("KR60606", Car.Brand.VOLVO);

        Map<Person, Car> info = new HashMap<>();
        info.put(smith, skoda1);
        info.put(jones, mazda1);
        info.put(harry, volvo);
        info.put(jacob, null);

        for (Map.Entry<Person, Car> e : info.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
}
class Person{
    String name, surname;
    Person(String a, String b){name = a; surname = b;}
    @Override
    public String toString(){return name + " " + surname;}
}
class Car{
    int INIT_PLATE = 0;
    String plate = "";
    Brand brand;
    enum Brand {MAZDA, BMW, VOLVO, SKODA, pepega}
    Car(){setBrand(""); setPlate();}
    Car(String brand){setBrand(brand); plate += INIT_PLATE++;}
    Car(String a, Brand b){plate = a; brand = b;}
    public void setPlate(){
        String tmp = "";
        tmp += INIT_PLATE;
        int temp = 6-tmp.length();
        tmp = "";
        for (int i = temp; i > 0; i--)
            tmp += 0;
        plate += tmp + INIT_PLATE;
        System.out.println(plate);
    }
    public void setBrand(String name){
        name = name.toUpperCase(Locale.ROOT);
        switch (name) {
            case "MAZDA": brand = Brand.MAZDA; break;
            case "BMW": brand = Brand.BMW; break;
            case "VOLVO": brand = Brand.VOLVO; break;
            case "SKODA": brand = Brand.SKODA; break;
            default : brand = Brand.pepega; break;
        }
    }
    @Override
    public String toString(){
        return brand + " " + plate;
    }
}
