package PPJ.Z14;

public class Square {
    private double a, b;
    public Square(double a, double b) {
        this.a = a; this.b = b;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public static void cal(Square p) {
        System.out.println("The side of first square is " + p.a + ", the side of second square is " + p.b);
        System.out.print("The side of \"a square which the surface area equal to the sum of areas of the two squares\" is " +
                Math.sqrt(p.a*p.a + p.b*p.b));
    }
}
