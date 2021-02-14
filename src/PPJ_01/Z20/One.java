package PPJ_01.Z20;

class CalculatingDevice{
    private String name;
    public CalculatingDevice(String name) {
        this.name = name;
    }
    public String calculate(double x, double y) {
        return name+": "+x+'+'+y+'='+(x+y);
    }
    public static void printRes(CalculatingDevice[] a, double x, double y){
        for(CalculatingDevice n : a) {
            System.out.println(n.calculate(x,y));
        }
    }
}
class Calculator extends CalculatingDevice{
    public Calculator(String name) {
        super(name);
    }
    public String calculate(double x, double y) {
        return super.calculate(x,y)+"; "+x+'-'+y+'='+(x-y);
    }
}
class Computer extends Calculator{
    public Computer(String name) {
        super(name);
    }
    public String calculate(double x, double y) {
        return super.calculate(x,y)+"; "+x+"*"+y+"="+(x*y)+"; "+x+"/"+y+"="+(x/y)+";";
    }
}
public class One {
    public static void main (String[] args) {
        CalculatingDevice[] arr = {
                new Computer("Cray"),
                new CalculatingDevice("Abacus"),
                new Calculator("HP")
        };
        CalculatingDevice.printRes(arr, 21, 7);
    }
}