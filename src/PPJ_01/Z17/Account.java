package PPJ.Z17;

public class Account {
    private double balance;
    private static double interest = 0;
    public void deposit(double a) {balance = balance + a;}
    public void withdraw(double a) {balance = balance - a;}
    public void transfer(Account a, double b) {balance = balance - b; a.balance = a.balance + b;}
    public void addInterest() {balance = balance*(1+interest/100);}
    public static void setInterestRate(double a) {interest = a;}
    public String toString() {return "balance: " + balance;}
    public static void main(String[] arg) {
        Person[] arr = new Person[5];
        arr[0] = new Person ("Alica", 1999);
        arr[1] = new Person ("Alicd", 1998);
        arr[2] = new Person ("Alice", 2004);
        arr[3] = new Person ("Alicf", 2003);
        arr[4] = new Person ("Alia", 2000);
        System.out.println(arr[0].getName());
        System.out.println(arr[0].getBirthYear());
        System.out.println(arr[0].isFemale());
        System.out.println(arr[2].isFemale());
        System.out.println(Person.getOlder(arr[1],arr[0]));
        System.out.println(arr[0].isYounger(arr[1]));
        System.out.println(arr[1].isYounger(arr[0]));
        System.out.println(Person.getOldest(arr));
        System.out.println(Person.getYoungestFemale(arr));

        Person johnP = new Person("John"),
                maryP = new Person("Mary");
        BankCustomer john = new BankCustomer(johnP);
        BankCustomer mary = new BankCustomer(maryP);
        john.getAccount().deposit(1000); mary.getAccount().deposit(2000); john.getAccount().transfer(
                mary.getAccount(),500); mary.getAccount().withdraw(1000);
        System.out.println(john); System.out.println(mary);
        Account.setInterestRate(4.5);
        john.getAccount().addInterest(); mary.getAccount().addInterest();
        System.out.println(john);
        System.out.println(mary);
    }
}
