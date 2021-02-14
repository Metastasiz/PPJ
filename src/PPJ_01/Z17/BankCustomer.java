package PPJ_01.Z17;

public class BankCustomer {
    private Account account = new Account();
    private String name;
    public BankCustomer(Person a) {this.name = a.getName();}
    public Account getAccount() {return account;}
    public String toString() {return "Customer: " + name + ", " + account;}
}
