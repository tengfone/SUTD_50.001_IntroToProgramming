import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public int getId(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    //nani?
    public static double getAnnualInterestRate(){
        return Account.annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate){
        Account.annualInterestRate = annualInterestRate;
    }
    // ^^^^^
    public Date getDateCreated(){
        return this.dateCreated;
    }

    public static double getMonthlyInterestRate(){
        return Account.annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return ((Account.annualInterestRate/12)/100)*this.balance;
    }

    public void withdraw(double money){
        this.balance -= money;
    }

    public void deposit(double money){
        this.balance += money;
    }
    
    Account(){

    }

    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }
}
