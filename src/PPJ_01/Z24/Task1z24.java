package PPJ.Z24;

import java.util.Scanner;

public class Task1z24 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        String temp;
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
        while (!(temp = scan.nextLine()).equalsIgnoreCase("q")) {
            boolean c1 = false, c2 = false, c3 = false, c4 = false, c5 = false, c6 = false;
            //letter+ + punctuation
            // letter end w/ punc
            if (temp.matches("\\p{L}+\\p{P}")) {counter1++;c1 = true;}
            // Non-digit
            if (temp.matches("\\D*")) {counter2++;c2 = true;}
            // \b + 3letter + \s+ + 3letter + \s+ + 3letter + \b
            // 3 at least 3-letter

            // >>>> ask this
            if (temp.matches("\\b\\p{L}{3,}\\s+\\p{L}{3,}\\s+\\p{L}{3,}\\b")) {counter3++;c3=true;}

            // \s+ 10-79 | 07|7-9 | 80-88 \s+
            // 7-88
            if (temp.matches("\\b(0*[789]|[1-7]\\d|8[0-8])\\b")) {counter4++;c4=true;}
            // \w+ + @ + [letter+ + .]+ + letter+
            // Email
            if (temp.matches("[\\p{L}+[.]?]+[@][\\p{L}+[.]]+\\p{L}+")) {counter5++;c5=true;}
            // yyyy-mm-dd
            if (temp.matches("\\b\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])\\b")) {counter6++;c6 = true;}

            System.out.println(temp);
            System.out.print("Letter end w/ punc: " + c1);
            System.out.print(", Non-digit: " + c2);
            System.out.print(", 3 at least 3-letter: " + c3);
            System.out.print(", 7-88: " + c4);
            System.out.print(", Email: " + c5);
            System.out.print(", yyyy-mm-dd: " + c6);
            System.out.println();
        }
        System.out.println("q");
        System.out.println("Letter end w/ punc: " + counter1);
        System.out.println("Non-digit: " + counter2);
        System.out.println("3 at least 3-letter: " + counter3);
        System.out.println("7-88: " + counter4);
        System.out.println("Email: " + counter5);
        System.out.println("yyyy-mm-dd: " + counter6);
    }
}
class SingLList{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        SingLList list = SingLList.arrayToList(arr);
        list.showList();
        list.removeOdd();
        list.showList();
        list.addFront(1);
        list.addBack(8);
        list.showList();
        System.out.println("contains 3? "+list.contains(3)); System.out.println("contains 8? "+list.contains(8));
        list.clear();
        list.showList();
    }
    private static class Node{
        int data;
        Node next;
        Node(int i){data = i;}
        Node(int i, Node n){data = i; next = n;}
    }
    Node head = null;
    SingLList(){}
    public void addFront(int d){
        head = new Node(d, head);
    }
    public void addBack(int d){
        Node temp = head;
        if (head == null) addFront(d);
        else {
            while (temp.next!=null){temp=temp.next;}
            temp.next = new Node(d);
        }
    }
    public void removeOdd(){
        Node temp = head;
        System.out.println();
        while (temp.next != null) {
            if (temp.next.data % 2 !=0) {temp.next = temp.next.next;}
            else {temp = temp.next;}
            }
        if (head.data % 2 != 0) head = head.next;
    }
    public boolean contains(int d){
        Node temp = head;
        while (temp != null) {
            if (temp.data == d) return true;
            temp = temp.next;
        }
        return false;
    }
    public void showList(){
        Node temp = head;
        if (temp == null) System.out.print("Empty List");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void clear(){
        head = null;
    }
    public static SingLList arrayToList(int[] a){
        SingLList temp = new SingLList();
        for (int i = 0; i < a.length; i++) {
            temp.addBack(a[i]);
        }
        return temp;
    }
}
