public class Frac1 {
    private double num;
    private double denom;

    public Frac1(double n, double d) {
        this.num = n;
        this.denom = d;
    }

    public Frac1(double n) {
        this(n, 1);
    }

    public Frac1() {
        this(0, 1);
    }

    public static double gcd(double a, double b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static Frac1 add(Frac1 a, Frac1 b) {
        double gcd = Frac1.gcd(a.denom, b.denom);
        double num = ((gcd / a.denom) * a.num) + ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);
    }

    public Frac1 add(Frac1 b) {
        double gcd = Frac1.gcd(this.denom, b.denom);
        double num = ((gcd / this.denom) * this.num) + ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);
    }

    public static Frac1 sub(Frac1 a, Frac1 b) {
        double gcd = Frac1.gcd(a.denom, b.denom);
        double num = ((gcd / a.denom) * a.num) - ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);

    }

    public Frac1 sub(Frac1 b) {
        double gcd = Frac1.gcd(this.denom, b.denom);
        double num = ((gcd / this.denom) * this.num) - ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);
    }

    public static Frac1 mul(Frac1 a, Frac1 b) {
        return new Frac1(a.num * b.num, a.denom * b.denom);
    }

    public Frac1 mul(Frac1 b) {
        return new Frac1(this.num * b.num, this.denom * b.denom);
    }
    public static Frac1 div(Frac1 a, Frac1 b){
        if(b.denom == 0){
            throw(new ArithmeticException());
        }
        double gcd = Frac1.gcd(a.denom, b.denom);
        double num = ((gcd / a.denom) * a.num) / ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);
    }
    public Frac1 div(Frac1 b){
        if(b.denom == 0){
            throw(new ArithmeticException());
        }
        double gcd = Frac1.gcd(this.denom, b.denom);
        double num = ((gcd / this.denom) * this.num) / ((gcd / b.denom) * b.num);
        return new Frac1(num, gcd);
    }
    public boolean Equals(Frac1 a, Frac1 b){
        double gcd = Frac1.gcd(a.denom,b.denom);
        double anum = a.num * (gcd/a.denom);
        double bnum = b.num * (gcd/b.denom);

        if(anum == bnum && gcd == gcd)
            return true;
        else
            return false;
    }
    public String toString(){
        return "fraction: " + this.num + "/"+this.denom;
    }
    public int hashCode(){
        return (int)(this.num / this.denom);
    }
    public static void main(String[] arg){
        Frac1 a = new Frac1(20,4);
        System.out.println(a);
    }
}




