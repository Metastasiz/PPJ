package PPJ_01.Z20;

import java.util.Arrays;

public class Three {
    public static void main(String[] arg) {
        int[] c = {1,2,3,4};
        SimpleArrayList a = new SimpleArrayList();
        a = new SimpleArrayList(c);
        System.out.println(a);
        a.trim();
        System.out.println(a);
        a.clear();
        System.out.println(a);
        a = new SimpleArrayList(1);
        System.out.println(a);
        a.insert(1,2);
        System.out.println(a);
        a.append(3);
        System.out.println(a);
        a.append(4);
        System.out.println(a);
        a.append(5);
        System.out.println(a);
        a.append(6);
        System.out.println(a);
        a.append(new int[]{2,2});
        System.out.println(a);
        a = new SimpleArrayList();
        System.out.println(a);
        a.append(new int[]{1,3});
        System.out.println(a);
        a.insert(1,2);
        System.out.println(a);
        a.append(6);
        System.out.println(a);
        a.insert(3,new int[]{4,5});
        System.out.println(a);
        SimpleArrayList b = new SimpleArrayList(a);
        for (int i = 0; i < a.size(); ++i)
            a.set(i,a.get(i)+6);
        System.out.println("b " + b);
        b.append(a);
        System.out.println("b " + b);
        b.append(13);
        System.out.println("b " + b);
        b.trim();
        System.out.println(a);
        System.out.println("b " + b);
    }
}
class SimpleArrayList {
    static final int INITIAL_CAPACITY = 5;
    private int size = 0, cap = INITIAL_CAPACITY;
    private int[] arr = new int[cap];
    public SimpleArrayList(){this.size = 0; this.cap = INITIAL_CAPACITY;}
    public SimpleArrayList(int a){this.size = 1; arr[0] = a;}
    public SimpleArrayList(int[] arr){
        if (arr.length >= 5) { this.arr = arr; }
        else { for (int i = 0; i < arr.length; i++) this.arr[i] = arr[i]; }
        this.size = arr.length;
    }
    public SimpleArrayList(SimpleArrayList a){
        arr = new int[a.arr.length];
        for(int i = 0; i < a.arr.length; i++) arr[i] = a.arr[i];
        size = a.size;
        cap = a.cap;
    }
    public int size(){return size;}
    public void clear(){arr = new int[INITIAL_CAPACITY]; size = 0;}
    public String toString() {return "Cap = " + cap + " Size = " + size + " " + Arrays.toString(arr);}
    public void trim(){
        cap = size;
        int[] out = new int[cap];
        for (int i = 0; i < cap; i++) { out[i] = arr[i]; }
        arr = out;
    }
    public SimpleArrayList insert(int ind, int e) throws IndexOutOfBoundsException{
        if (arr[ind]!=0){
            if (size == cap) {
                cap*=2;
                int[] out = new int[cap];
                for (int i = 0; i < arr.length; i++){out[i] = arr[i];}
                arr = out;
            }
            for (int i = cap-1; i > ind; i--) { arr[i] = arr[i-1]; }
        }
        size++;
        arr[ind] = e;
        return this;
    }
    public SimpleArrayList insert(int ind, int[] a) throws IndexOutOfBoundsException{
        for (int i = 0; i < a.length; i++){ insert(ind+i, a[i]); }
        return this;
    }
    public SimpleArrayList append(int e){
        if (size == cap) {
            cap*=2;
            int[] out = new int[cap];
            for (int i = 0; i < arr.length; i++){out[i] = arr[i];}
            arr = out;
        }
        insert(size, e);
        return this;
    }
    public SimpleArrayList append(int[] a){
        ExpandLength(a.length);
        System.arraycopy(a, 0,arr,size,a.length);
        size+=a.length;
        return this;
    }
    public SimpleArrayList append(SimpleArrayList a){
        int[] out = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {out[i] = a.arr[i];}
        append(out);
        return this;
    }
    public void ExpandLength(int length){
        if (cap-size < length) {
            cap*=2;
            int[] out = new int[cap];
            for (int i = 0; i < arr.length; i++){out[i] = arr[i];}
            arr = out;
        }
    }
    public int get(int ind){
        return arr[ind];
    }
    public SimpleArrayList set(int ind, int val){
        arr[ind] = val;
        return this;
    }
}
//this task is retarded; spend more time understanding the task rather than solving it, i ain't doing it

