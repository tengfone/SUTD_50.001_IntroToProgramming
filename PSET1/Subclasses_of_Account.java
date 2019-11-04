public class CheckingAccount extends Account{
    private int id;
    private double balance;
    
    @Override
    public void withdraw(double money){
        if(this.getBalance() - money < -5000)
            System.out.println("over limit");
        else
            super.withdraw(money);
    }
    
    
    public CheckingAccount(){
    }
    
    public CheckingAccount(int id, double balance){
        super(id,balance);
    }
}
