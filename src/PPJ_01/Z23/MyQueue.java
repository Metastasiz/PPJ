package PPJ_01.Z23;

class MyQueue{
     static class Node {
        Task data;
        MyQueue.Node next = null;

        Node(Task d) {
            data = d;
        }
    }
    MyQueue.Node head, tail;
    public MyQueue() {
        head = tail = null;
    }
    public void enqueue(Task s) {
        if (head == null)
            head = tail = new MyQueue.Node(s);
        else
            tail = tail.next = new MyQueue.Node(s);
    }
    public Task dequeue() {
        Task s = head.data;
        if ((head = head.next) == null) tail = null; return s;
    }
    public boolean empty() {
        return head == null; }

    static class Task{
        double x, y;
        char op;
        public Task(double a, double b) { x = a;
            y = b;
        }

        public double execute() {
            switch (op){
                case '+': return x+y;
                case '/': return x/y;
                case '-': return x-y;
                case '*': return x*y;
            }
            throw new UnsupportedOperationException();
        }
        public static Task getInstance(String oper, double a, double b) {
            Task t = new Task(a, b);
            t.op = oper.charAt(0);
            return t;
        }
    }
}
