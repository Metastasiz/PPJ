package GUI_01.Z01;

public class T1 {
    public static void main(String args[]) {
        Person p1 = new Person("Jan", 50);
        Student s1 = new Student("Jasiek", 20);
        Student s2 = new Student("oi", 20);
        Person p3 = (Person)s1;
        p1.sayHelloTo(p3); //Hi Jasiek!
        p3.sayHelloTo(p1); //Hi Jan!
        Subject s = new Subject("GUI");
        s.setTeacher(p1);
        try { s.addStudent(s1); s.addStudent(s2);}
        catch(TooManyStudentsException e) { e.printStackTrace(); }
        System.out.println(s); //GUI, teacher: Jan, students: Jasiek
    }
}
class Person{
    public String name;
    public int age;
    Person(String name, int age){ this.name = name; this.age = age; }
    Person(){}
    public void sayHelloTo(Person a){
        System.out.println(name + ": Hi, " + a.name);
    }
}
class Student extends Person{
    Student(String name, int age) {
        super(name, age);
    }
}
class Subject extends Person{
    public String subj;
    static private int INITIAL_MAX_NUM = 3;
    Student[] all = new Student[INITIAL_MAX_NUM];
    Subject(String subj){
        super();
        this.subj = subj;
    }
    public void setTeacher(Person a){
        super.name = a.name;
        super.age = a.age;
    }
    public void addStudent(Student a) throws TooManyStudentsException{
        int i = 0;
        while (true){
            if (all[i] == null) {all[i] = a; break;}
            else i++;
        }
    }
    public String allStudents(){
        return allStudents(0);
    }
    public String allStudents(int a){
        if (a >= all.length||all[a] == null) return "";
        return (all[a].name + ", " + allStudents(a+1));
    }
    @Override
    public String toString(){
        return ("Teacher: " + this.name + "; Students: " + allStudents());
    }
}
class TooManyStudentsException extends Exception{
    TooManyStudentsException() {super("TOO MANY STUDENTS");}
}
