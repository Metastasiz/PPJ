package GUI_01.Z03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T1 {
    public static void main(String[] arg) throws Exception {
        List<Square> squares = new ArrayList<Square>();
        squares.add(new Square(3));
        squares.add(new Square(4));
        squares.add(new Square(3));
        squares.add(new Square(6));
        System.out.println("Original");
        for (Square a : squares){
            System.out.println(a);
        }
        Collections.sort(squares);
        System.out.println("Sorted");
        for (Square a : squares){
            System.out.println(a);
        }
        List<Mobile> devices = new ArrayList<Mobile>();
        devices.add(new Landline() {
            @Override
            public String getManu(){return "Moto";}
            @Override
            public int getPrice(){return 100;}
        });
        devices.add(new MobileP(true) {
            @Override
            public String getManu(){return "BB";}
            @Override
            public int getPrice(){return 200;}
        });
        devices.add(new Game(true) {
            @Override
            public String getManu(){return "Switch";}
            @Override
            public int getPrice(){return 300;}
        });
        devices.add(new SmartP(true, true) {
            @Override
            public String getManu(){return "Apple";}
            @Override
            public int getPrice(){return 400;}
        });
        for (Mobile a : devices){
            System.out.println(a);
        }

    }
}
class Square implements Comparable<Square>, Figure{
    int number, length;
    static int INIT_COUNTER = 1;
    Square(int l) throws Exception {
        if (l > 6) throw new TooBigSquare(max);
        length = l; number = INIT_COUNTER++;}
    public String toString(){return number + " " + getArea();}

    @Override
    public int getArea() {
        return length*length;
    }
    @Override
    public int getPerimetre() {
        return length*4;
    }
    @Override
    public int compareTo(Square o) {
        if (this.getArea() != o.getArea()) return this.getArea()<o.getArea()?-1:1;
        else if (this.number != o.number) return this.number<o.number?-1:1;
        else return 0;
    }
}
interface Figure{
    int max = 6;
    public int getArea();
    public int getPerimetre();
}
class TooBigSquare extends Exception{
    TooBigSquare(int max){super("Maximum length is"+ max);}
}
class Mobile{
    public String getManu() {
        return "Unknown";
    }

    public int getPrice() {
        return 0;
    }

    public boolean calling() {
        return false;
    }

    public boolean sms() {
        return false;
    }

    public boolean game() {
        return false;
    }

    public boolean internet() {
        return false;
    }
    public String toString(){return getManu() + " " + getPrice()
            + "\nCalling: " + calling()
            + " Sms: " + sms()
            + "\nGaming: " + game()
            + " Internet: " + internet();}
}
class Landline extends Mobile{
    Landline(){}
    @Override
    public boolean calling() {
        return true;
    }
}
class MobileP extends Mobile{
    boolean sim = false;
    MobileP(){}
    MobileP(boolean s){sim = s;}
    @Override
    public boolean calling() {
        return true;
    }
    @Override
    public boolean sms(){
        return sim==true?true:false;
    }
}
class Game extends Mobile{
    boolean internet = false;
    Game(){}
    Game(boolean i){internet = i;}
    @Override
    public boolean game(){
        return internet==true?true:false;
    }
    @Override
    public boolean internet(){
        return internet==true?true:false;
    }
}
class SmartP extends Mobile{
    boolean sim = false, internet = false;
    SmartP(){}
    SmartP(boolean s, boolean i){sim = s;internet = i;}
    @Override
    public boolean calling() {
        return true;
    }
    @Override
    public boolean sms(){
        return sim==true?true:false;
    }
    @Override
    public boolean game(){
        return internet==true?true:false;
    }
    @Override
    public boolean internet(){
        return internet==true?true:false;
    }
}

