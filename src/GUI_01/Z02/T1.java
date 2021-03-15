package GUI_01.Z02;
import java.awt.Color;

public class T1 {
    public static void main(String[] arg){
        figure[] fig = {
                new square(3), new square(3, 34, 45, 56),
                new rectangle(3,9), new rectangle(3,4, 34, 45, 56),
                new circle(3), new circle(3, 34, 45, 56),
                new triangle(3,7,9), new triangle(3,4,8, 34, 45, 56),
                new hexagon(3), new hexagon(3, 34, 45, 56),
        };
        for (figure a : fig){
            System.out.println(a);
        }

        Singer s1 = new Singer("Eminem");
        s1.sing("ASDFsadfas");
        s1.sing("AFsadfas");
        Singer s2 = new Singer("Eagles");
        s1.sing("aasdFSFSSDFGSE");
        s1.sing("CUUUNTdafd");
        Singer s3 = new Singer("Simon & Garfunkel");
        s1.sing("asdfasdfASDF");
        s1.sing("SDFGDgdg");
        Singer sp[] = {s1, s2, s3};
        for (Singer s : sp) System.out.println(s);
        System.out.println("\n" + Singer.loudest(sp));

    }
}
abstract class figure{
    int r = 0, g = 0, b = 0;
    abstract public double getArea();
    abstract public double getPerimetre();
    public String getColor(){return "R = " + r + ", G = " + g + ", B = " + b;}
    @Override
    public String toString(){return "Area: " + String.format("%.2f", getArea()) + ", Perimetre: " + String.format("%.2f", getPerimetre()) + ", Colour: " + getColor();}
}
class square extends figure{
    double s;
    square(double s){this.s = s;}
    square(double s, int r, int g, int b){this.s = s; this.r = r; this.g = g; this.b = b;}
    @Override
    public double getArea(){return s*s;}
    @Override
    public double getPerimetre(){return s*4;}
    @Override
    public String toString(){return "Square    -> " + super.toString();}
}
class rectangle extends figure{
    double side1, side2;
    rectangle(double side1, double side2){this.side1 = side1; this.side2 = side2;}
    rectangle(double side1, double side2, int r, int g, int b){this.side1 = side1; this.side2 = side2; this.r = r; this.g = g; this.b = b;}
    @Override
    public double getArea(){return side1*side2;}
    @Override
    public double getPerimetre(){return side1*2+side2*2;}
    @Override
    public String toString(){return "Rectangle -> " + super.toString();}
}
class circle extends figure{
    double radius;
    circle(double radius){this.radius = radius;}
    circle(double radius, int r, int g, int b){this.radius = radius; this.r = r; this.g = g; this.b = b;}
    @Override
    public double getArea(){return Math.PI*radius*radius;}
    @Override
    public double getPerimetre(){return Math.PI*2*radius;}
    @Override
    public String toString(){return "Circle    -> " + super.toString();}
}
class triangle extends figure{
    double side1, side2, side3;
    triangle(double side1, double side2, double side3){this.side1=side1; this.side2=side2; this.side3=side3;}
    triangle(double side1, double side2, double side3, int r, int g, int b){this.side1=side1; this.side2=side2; this.side3=side3; this.r = r; this.g = g; this.b = b;}
    public double getS(){return (side1+side2+side3)/2;}
    @Override
    public double getArea(){return Math.sqrt(getS()*(getS()-side1)*(getS()-side2)*(getS()-side3));}
    @Override
    public double getPerimetre(){return side1+side2+side3;}
    @Override
    public String toString(){return "Triangle  -> " + super.toString();}
}
class hexagon extends figure{
    double side;
    hexagon(double side){this.side = side;}
    hexagon(double side, int r, int g, int b){this.side = side; this.r = r; this.g = g; this.b = b;}
    @Override
    public double getArea(){return 3*Math.sqrt(3)*side*side/2;}
    @Override
    public double getPerimetre(){return side*6;}
    @Override
    public String toString(){return "Hexagon   -> " + super.toString();}
}
class Singer{
    static int INIT_ID = 1;
    String name;
    int id;
    String[] songs = new String[0];
    Singer(String name){this.name = name; id = INIT_ID++;}
    public void sing(String song){
        int temp = songs.length+1;
        String[] out = new String[temp];
        for (int i = 0; i < songs.length; i++){
            out[i] = songs[i];
        }
        out[out.length-1] = song;
        songs = out;
    }
    public static String loudest(Singer[] a){
        Singer out = null;
        int songNr = -1;
        int max = -1;
        for (Singer b : a) {
            for (int i = 0; i < b.songs.length; i++){
                int counter = 0;
                for (int j = 0; j < b.songs[i].length(); j++){
                    if(Character.isUpperCase(b.songs[i].charAt(j))){counter++;}
                }
                if (counter > max){songNr = i; out = b;}
            }
        }
        return out + out.songs[songNr];
    }
    @Override
    public String toString(){
        return id + " " + name + " ";
    }
}
