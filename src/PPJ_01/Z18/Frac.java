package PPJ.Z18;

public class Frac {
    private int num = 0, denom = 1;
    public Frac(int num, int denom){this.num = num; this.denom = denom; GCD();}
    public Frac(int num){this.num = num; GCD();}
    public Frac(){GCD();}
    private void GCD(){
        if(this.denom == 0) throw(new ArithmeticException("Denom = 0"));
        int temp = 1, a = num / temp, b = denom / temp, neg = 1;
        if (a<0&&!(b<0) || !(a<0)&&b<0) neg = -neg;
        while (a!=0 && b!=1) {
            a = num / temp; b = denom / temp;
            a = a<0?-a:a;
            b = b<0?-b:b;
            while (a != b) {
                if (a > b) a = a - b;
                else b = b - a;
            }
            temp *= b;
        }
        a = num / temp; b = denom / temp;
        a = a<0?neg*-a:neg*a;
        b = b<0?-b:b;
        this.num = a; this.denom = b;
    }
    public static Frac mul(Frac a, Frac b){
        if(a.denom==0||b.denom == 0) throw(new ArithmeticException("Denom = 0"));
        return new Frac(a.num*b.num,a.denom*b.denom);
    }
    public Frac mul(Frac other){
        if(other.denom == 0) throw(new ArithmeticException("Denom = 0"));
        return new Frac(this.num*other.num,this.denom*other.denom);
    }
    public static Frac add(Frac a, Frac b){return new Frac(b.denom*a.num+a.denom*b.num,a.denom*b.denom);}
    public Frac add(Frac other){return new Frac(other.denom*this.num+this.denom*other.num,this.denom*other.denom);}
    public static Frac sub(Frac a, Frac b){return new Frac(b.denom*a.num-a.denom*b.num,a.denom*b.denom);}
    public Frac sub(Frac other){return new Frac(other.denom*this.num-this.denom*other.num,this.denom*other.denom);}
    public static Frac div(Frac a, Frac b){return new Frac(a.num*b.denom,a.denom*b.num);}
    public Frac div(Frac other){return new Frac(this.num*other.denom,this.denom*other.num);}
    public static void main(String[] arg){
        Frac x = new Frac(0,1);
        Frac a = new Frac(20,4), b = new Frac(1,-2),
                c = new Frac(-14,-4), d = new Frac(-8,-4),
                f = new Frac(4), m = new Frac(-1);
        Frac f2 = Frac.add(Frac.mul(d,c),
                new Frac(10).mul(b));
        Frac f4 = Frac.add(Frac.mul(Frac.mul(a,b),
                new Frac(-2)),m);
        Frac zz = d.add(a).add(f.mul(Frac.mul(b,c)));
        Frac ww = Frac.div(f2,f4).sub(b).sub(c);
        System.out.println(x + " " + f2 + " " + f4 + " " + zz + " " + ww);
    }
    @Override
    public String toString(){if (denom == 1||num == 0) return Integer.toString(num); return num + "/" + denom;}
    public boolean equals(Frac other){
        if (this.num==other.num&&this.denom==other.denom) return true;
        return false;
    }
    public int hashCode(){
        int r = 17;
        String a = "/";
        r = 31 * r + num;
        if (denom != 1) {
            r = 31 * r + a.hashCode();
            r = 31 * r + denom;
        }
        return r;
    }
}
