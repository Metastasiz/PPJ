package PPJ_01.Z16;

public class MyString {
    private String str = "";
    public MyString(){}
    public MyString(String str){this.str = str;}
    public int getLength() {return str.length();}
    public char getChar(int n) {
        if (n>getLength()||n<0) throw new IllegalArgumentException("out of range");
        else return str.charAt(n);
    }
    public void append(String s) {str += s;}
    public void append(int rep, String s) {
        for (int i = 0; i < rep; i++) str += s;
    }
    public void prepend(String s) {str = s + str;}
    public void insert(int pos, String s) {
        if (pos>getLength()||pos<0) throw new IllegalArgumentException("out of range");
        String a = "";
        for (int i = 0; i < str.length(); i++) {
            a += str.charAt(i);
            if (i == pos) a += s;
        }
        str = a;
    }
    public void reset(String s) {str = s;}
    @Override
    public String toString() {return str;}

    public static void main(String[] arg) {
        MyString d = new MyString();
        System.out.println(d);
        MyString a = new MyString("something");
        System.out.println(a);
        System.out.println(a.getLength());
        System.out.println(a.getChar(2));
        a.append("Append");
        System.out.println(a);
        a.append(2,"Times");
        System.out.println(a);
        a.prepend("Prepend");
        System.out.println(a);
        a.insert(4, "Insert");
        System.out.println(a);
        a.reset("something");
        System.out.println(a);
    }
}
