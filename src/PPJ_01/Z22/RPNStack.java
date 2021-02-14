package PPJ.Z22;

import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_NUMBER;
import static java.io.StreamTokenizer.TT_WORD;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;

class main{
    public static void main(String[] arg) {
        RPNStack st = new RPNStack();
        String input = "2 7 5 + * 20 - 1 4 / /";
        String[] data = input.split(" ");
        System.out.print(Arrays.toString(data));
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "+" : st.push(st.pop()+st.pop()); break;
                case "/" : st.push(st.pop()/st.pop()); break;
                case "-" : st.push(st.pop()-st.pop()); break;
                case "*" : st.push(st.pop()*st.pop()); break;
                default: st.push(Integer.parseInt(data[i]));
            }
        }
        while (!st.empty()) System.out.print(st.pop() + " ");
    }
}
public class RPNStack {
    private Node head;
    public RPNStack(){
        this.head = null;
    }
    public void push(double val){
        head = new Node(val, head);
    }
    public void addNextN(double val) {
        if (head == null) {
        push(val);
        return;
        }
        Node tmp = head;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = new Node(val);
    }
    public double pop() {
        double out = head.val;
        this.head = head.next;
        return out;
    }
    public boolean empty() {
        if (head == null) return true;
        return false;
    }
}
class Node{
    double val;
    Node next;
    Node(double val, Node next){
        this.val = val; this.next = next;
    }
    Node(double val){
        this(val,null);
    }
}
