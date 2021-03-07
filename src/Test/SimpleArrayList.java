import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignatureProperties;
import java.util.Arrays;

public class SimpleArrayList {
    private int size, cap;
    private int[] arr;
    static private int INITIAL_CAPACITY = 10;

    public SimpleArrayList(){
        this.size = 0;
        this.cap = INITIAL_CAPACITY;
        arr = new int[INITIAL_CAPACITY];
    }
    public SimpleArrayList(int e){
        super();
        size +=1;
        this.cap = INITIAL_CAPACITY;
        arr = new int[cap];
        arr[0] = e;
    }
    public SimpleArrayList(int[] a){
        this.size = a.length;
        this.cap = a.length + INITIAL_CAPACITY;
        arr = new int[cap];
        for(int x=0;x<a.length;x++){
           arr[x] = a[x];
        }
    }

    public SimpleArrayList(SimpleArrayList simp){
        this.size = simp.size;
        this.cap = simp.size + INITIAL_CAPACITY;
        arr = new int[cap];
        for(int x =0; x<size;x++){
            arr[x] = simp.arr[x];
        }
    }
    public int size() {
       return this.size;
    }

    public void clear(){
        this.size = 0;
        this.cap = INITIAL_CAPACITY;
        this.arr = new int[cap];
    }

    public void trim(){
        int[] pat;
        pat = new int[this.size];
        System.arraycopy(this.arr, 0, pat, 0, this.size);
        this.cap = this.size;
        this.arr = pat;

    }

    public SimpleArrayList insert(int ind, int[] aoe) throws IndexOutOfBoundsException{
        if((ind > this.size)||(ind<0)) throw new IndexOutOfBoundsException();

        if (aoe.length > this.cap - this.size){ //Checking if it'll fit and resizing if necessary
            int[] lng = new int[(this.size + aoe.length)*2];
            System.arraycopy(this.arr, 0, lng, 0, this.size);
            this.arr = lng;
            this.cap = lng.length;
        }

        if (ind < this.size){//Checking if stuff needs to be shifted and shifts if so
           int[] shft = new int[this.size() - ind];
           System.arraycopy(this.arr, ind, shft, 0, shft.length);
           System.arraycopy(aoe, 0,arr,ind,aoe.length);
           System.arraycopy(shft, 0,arr,ind+aoe.length, shft.length);
        }else{
            System.arraycopy(aoe, 0,arr,ind,aoe.length);
        }
        this.size = this.size() + aoe.length;
        return this;
    }

    public SimpleArrayList insert(int ind, int e){
        return this.insert(ind, new int[]{e});
    }
    public SimpleArrayList append(int[] a){
        System.out.println(this.size());
        return this.insert(this.size(),a);
    }
    public SimpleArrayList append(int e){
        int[] na = {e};
        return this.append(na);
    }
    public SimpleArrayList append(SimpleArrayList sal){
        sal.trim();
        return append(sal.arr);
    }
    public int get(int ind) throws IndexOutOfBoundsException{
        if(ind>=this.size) throw new IndexOutOfBoundsException();
        return this.arr[ind];
    }
    public SimpleArrayList set(int ind, int val){
        if(ind>=this.size) throw new IndexOutOfBoundsException();
        this.arr[ind] = val;
        return this;
    }
    public String toString(){
        return "AL of cap: "+this.cap+", this size: "+this.size()+" and such elements:"+ Arrays.toString(this.arr);
    }

    public static void main(String[] aa){
      //  SimpleArrayList c = new SimpleArrayList().insert(0,new int[]{1,3,4});
      //  System.out.println(c);
      //  c.insert(1,new int[]{2,2,2,2,2,2});
      //  System.out.println(c);
      //  c.insert(9,new int[]{9});
      //  System.out.println(c);
      //  c.insert(9,new int[]{9});
      //  System.out.println(c);
      //  c.insert(5,25);
      //  System.out.println(c);
      //  c.append(new int[]{1,2,3});
      //  System.out.println(c);
      //  c.append(44);
      //  System.out.println(c);
      //  SimpleArrayList d = new SimpleArrayList().insert(0,new int[]{11,22,33});
      //  c.append(d);
      //  System.out.println(c);
      //  c.append(d);
      //  System.out.println(c);
      //  c.append(d);
      //  System.out.println(c);

        SimpleArrayList a = new SimpleArrayList().append(new int[]{1,3});
        System.out.println("a ->" + a);
        a.insert(1,2);
        System.out.println("a ->" + a);
        a.append(6).insert(3,new int[]{4,5});
        System.out.println("a ->" + a);
        SimpleArrayList b = new SimpleArrayList(a);
        for(int i = 0;i<a.size();i++){
            a.set(i,a.get(i)+6);}
        System.out.println("aaaaa"+a+"\n"+b);
        b.append(a).append(13).trim();
        System.out.println("a ->" + a);

        System.out.println("b ->" + b);
    }
}
