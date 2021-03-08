package PPJ_01.Z22;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckBrac {
}
class main2{
    public static void main(String[] arg) throws Exception {
        CharStack st = new CharStack();
        BufferedReader br = Files.newBufferedReader(Paths.get("Text2.txt"));
        int line = 1;
        int temp;
        char tmp;
        while ((temp = br.read()) != -1) {
            char c = (char)temp;
            System.out.print(c);
            if (c == '\n') line++;
            switch (c) {
                case '[':
                case '(':
                case '{':
                    st.push(c); break;
                case ']':
                case ')':
                case '}':
                    if (convert(c) != (tmp = st.pop())) {
                    System.out.println();
                    System.out.print("ERROR in line " + line + " " + c + " found, but " + convert(tmp) + " expected");
                    System.out.println(tmp);
                    return;
                } else break;
            }
        }
        if (!st.empty()) {
            System.out.println();
            System.out.print("ERROR in line " + line + " " + convert(st.pop()) + " expected");
            return;
        }
        System.out.println();
        System.out.println("No ERROR well done!");
    }
    public static char convert(char a){
        switch (a) {
            case '[' : return ']';
            case '{' : return '}';
            case '(' : return ')';
            case ']' : return '[';
            case '}' : return '{';
            case ')' : return '(';
        }
        return ' ';
    }
}
class CharStack {
    private Node2 head;
    public CharStack(){
        this.head = null;
    }
    public void push(char val){
        head = new Node2(val, head);
    }
    public void addNextN(char val) {
        if (head == null) {
            push(val);
            return;
        }
        Node2 tmp = head;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = new Node2(val);
    }
    public char pop() {
        char out = head.val;
        this.head = head.next;
        return out;
    }
    public boolean empty() {
        if (head == null) return true;
        return false;
    }
}
class Node2{
    char val;
    Node2 next;
    Node2(char val, Node2 next){
        this.val = val; this.next = next;
    }
    Node2(char val){
        this(val,null);
    }
}