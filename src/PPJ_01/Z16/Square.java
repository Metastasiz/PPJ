package PPJ.Z16;

public class Square {
    private double side = 1;
    public Square(){}
    public Square(double side) {this.side = side;}
    public double getSide() {return side;}
    public double getArea() {return side*side;}
    public double getDiagonal() {return side*Math.sqrt(2);}
    public double getPerimeter() {return side*4;}
    public Square getDoubled() {return new Square(side*2);}
    public static double getTotalArea(Square[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i].getArea();
        return sum;
    }
    public static Square getMax(Square[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) if (a[max].getSide() < a[i].getSide()) max = i;
        return a[max];
    }
    @Override
    public String toString() {return "Square [" + side + "]";}
    public static void main(String[] args) {
        Square s2 = new Square(2);
        Square s1 = new Square();
        System.out.println(s2 + " " + s1);
        System.out.println("Side " + s2.getSide());
        System.out.println("Area " + s2.getArea());
        System.out.println("Diag " + s2.getDiagonal());
        System.out.println("Perim " + s2.getPerimeter());
        System.out.println("Doubled " + s2.getDoubled());
        Square[] sqs = {s1, s2, new Square(3)};
        System.out.println("Total area: " + Square.getTotalArea(sqs));
        System.out.println("Greatest : " + Square.getMax(sqs));
    }
}
