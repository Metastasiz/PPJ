package PPJ.Z20;

import java.util.Arrays;

public class Three {
    public static void main(String[] arg) {
        int[] b = {1,2,3,4};
        SimpleArrayList a = new SimpleArrayList();
        a = new SimpleArrayList(b);
        System.out.println(a);
        a.clear();
        System.out.println(a);
    }
}
class SimpleArrayList {
    static final int INITIAL_CAPACITY = 5;
    private int size = 0 , cap;
    private int[] arr = new int[size];
    public SimpleArrayList(){this.size = INITIAL_CAPACITY; this.cap = INITIAL_CAPACITY;}
    public SimpleArrayList(int size){this.size = size;}
    public SimpleArrayList(int[] arr){this.size = arr.length; this.arr = arr;}
    public int size(){return size;}
    public void clear(){this.size = INITIAL_CAPACITY; this.cap = INITIAL_CAPACITY;}
    public String toString() {return "Cap = " + cap + " Size = " + size + " " + Arrays.toString(arr);}
}

