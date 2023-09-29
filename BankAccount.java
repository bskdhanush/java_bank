package bank;


public abstract class BankAccount {
    private double balance;
    private int numDeposits;
    private int numWithdrawals;
    private double annualInterestRate;
    private double monthlyServiceCharges;

    //Constructor
    
    public BankAccount(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    
    
    //Methods

    public void deposit(double amount) {
        balance += amount;
        numDeposits++;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            numWithdrawals++;
        } else {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        }
    }

    public void calcInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }

    public void monthlyProcess() {
        balance -= monthlyServiceCharges;
        calcInterest();
        numWithdrawals = 0;
        numDeposits = 0;
        monthlyServiceCharges = 0;
    }
    @Override
    public String toString() {
        return "Balance: $" + balance + "\nNumber of Deposits: " + numDeposits + "\nNumber of Withdrawals: " + numWithdrawals;
    }

    
    

    // set methods
   
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setMonthlyServiceCharges(double monthlyServiceCharges) {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }
    
    
    public void setNumDeposits(int numDeposits) {
    		
    	this.numDeposits=  numDeposits;
    }
    
    
    public void setNumWithdrawals(int numWithdrawals) {
    	
    	this.numWithdrawals=numWithdrawals;
    	
    }
    
    
    //GEt methods
    
    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyServiceCharges() {
        return monthlyServiceCharges;
    }
    
    public int getNumWithdrawals() {
    	return numWithdrawals;
    }
    
    public int getNumDeposits() {
    	return numDeposits;
    }

   

    public abstract void setStatus();
}

