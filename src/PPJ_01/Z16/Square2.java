package PPJ.Z16;

public class Square2 {
    private double side;
    public Square2(double side) {this.side = side;}
    public double getSide() {return side;}
    public double getAreaS() {return side*side;}
    public double getPeriS() {return side*4;}
    public Circle getInC() {return new Circle(side/2);}
    public Circle getCiC() {return new Circle(side*Math.sqrt(2)/2);}
    public static Circle[] getCircle(Square2[] a) {
        Circle[] b = new Circle[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = new Circle(Math.sqrt(a[i].getAreaS()/Math.PI));
        }
        return b;
    }
    @Override
    public String toString() {return "Square [" + side + "]";}

    public static void main(String[] arg) {
        Square2[] sqs = {new Square2(2), new Square2(1),
                new Square2(3), new Square2(4)};
        for (Square2 s : sqs) System.out.print(s + " ");
        System.out.print("\nAreas: "); for (Square2 s : sqs)
            System.out.print(s.getAreaS() + " "); System.out.print("\nPerimeters: ");
        for (Square2 s : sqs)
            System.out.print(s.getPeriS() + " ");
        Circle[] crs = {new Circle(2), new Circle(1),
                new Circle(3), new Circle(4)};
        Square2[] squares = Circle.getSquares(crs); System.out.println( "\nAreas of squares " +
                "from circles: ");
        for (Square2 s : squares)
            System.out.printf("%.2f ", s.getAreaS()); System.out.println();

    }
}
