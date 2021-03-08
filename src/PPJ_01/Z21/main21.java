package PPJ_01.Z21;

import java.awt.*;
import java.util.Arrays;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

class Person{
    String name = null;
    int year = 0;
    Car car = null;
    Person(String name, int year, Car car){
        this.name = name; this.year = year; this.car = car;
    }
    Person(String name, int year){
        this.name = name; this.year = year;
    }
    Person(String name){
        this.name = name;
    }
    public static Car[] findAllCars(Person[] persons){
        Car[] car = new Car[persons.length];
        for (int i = 0; i < persons.length; i++) {
            car[i] = persons[i].car;
        }
        return car;
    }
    public static Person[] findOwners(Person[] persons, String make) {
        int counter = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].car != null) {if (persons[i].car.make.equalsIgnoreCase(make)) counter++;}
        }
        Person[] r = new Person[counter];
        counter = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].car == null) continue;
            if (persons[i].car.make.equalsIgnoreCase(make)) {
                System.out.print("asd");
                r[counter] = persons[i];
                counter++;
            }
        }
        return r;
    }
    public static Color findColor(Person[] person, String name, int year) {
        for (int i = 0; i < person.length; i ++) {
            if (person[i].name.equalsIgnoreCase(name) && person[i].year == year) {
                return person[i].car.color;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        return name + " " + year + " " + car;
    }
}
class Car{
    String make = null;
    Color color = null;
    Car(String make, int r, int g, int b){
        this.make = make; this.color = new Color(r,g,b);
    }
    Car(String make){
        this.make = make;
    }
    Car(){}
    @Override
    public String toString(){
        return make + " [ " + color + " ]";
    }
}
public class main21{
    public static void main(String[] arg) {
        String filename = "PPJ_Z21_3.txt";
        String temp;
        int counter = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename));
            BufferedReader br2 = Files.newBufferedReader(Paths.get(filename));) {
            while (br2.readLine() != null) {
                counter++;
            }
            Person[] person = new Person[counter];
            System.out.println(counter);
            counter = 0;
            while ((temp = br.readLine()) != null) {
                String[] tmp = temp.split("\\s+");
                if (tmp.length > 3) {
                    Car car = new Car(tmp[2], Integer.valueOf(tmp[3]), Integer.valueOf(tmp[4]), Integer.valueOf(tmp[5]));
                    person[counter] = new Person(tmp[0], Integer.valueOf(tmp[1]), car);
                } else if (tmp.length > 2) {
                    Car car = new Car(tmp[2]);
                    person[counter] = new Person(tmp[0], Integer.valueOf(tmp[1]), car);
                } else {person[counter] = new Person(tmp[0], Integer.valueOf(tmp[1]));}
                counter ++;
            }
            System.out.println(Arrays.toString(person));
            System.out.println(Arrays.toString(Person.findOwners(person, "Mercedes")));
            System.out.println(Person.findColor(person,"John", 1980));
            System.out.println(Arrays.toString(Person.findAllCars(person)));
        } catch (Exception e){System.out.println(e.getMessage());}
    }
}
