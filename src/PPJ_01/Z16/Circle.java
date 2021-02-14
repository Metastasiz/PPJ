package PPJ_01.Z16;

public class Circle {
    private double rad;
    public Circle(double rad) {this.rad = rad;}
    public double getRad() {return rad;}
    public double getAreaC() {return Math.PI*rad*rad;}
    public double getPeriC() {return Math.PI*2*rad;}
    public Square2 getInS() {return new Square2(rad/(2*Math.sqrt(2)));}
    public Square2 getCiS() {return new Square2(rad/2);}
    public static Square2[] getSquares(Circle[] a) {
        Square2[] b = new Square2[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = new Square2(Math.sqrt(a[i].getAreaC()));
        }
        return b;
    }
    @Override
    public String toString() {return "Circle [" + rad + "]";}
}
