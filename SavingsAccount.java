package bank;

import bank.*;


public class SavingsAccount extends BankAccount {
    private boolean active;

    public SavingsAccount(double balance, double annualInterestRate) {
        super(balance, annualInterestRate);
        setStatus(); // Initialize account status based on the initial balance
    }
    
    
    @Override
    public void setStatus() {
        active = getBalance() >= 25;
    }
    
    
    public boolean isActive() {
        return active;
    }

    @Override
    public void withdraw(double amount) {
        if (isActive()) {
            super.withdraw(amount);
            if (getBalance() < 25) {
                active = false;
            }
        } else {
            System.out.println("Account is inactive. Withdrawals not allowed.");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (!isActive() && getBalance() >= 25) {
            active = true;
        }
    }

    @Override
    public void monthlyProcess() {
        if (getNumWithdrawals() > 4) {
            double serviceCharge = (getNumWithdrawals() - 4) * 1.0;
            setMonthlyServiceCharges(getMonthlyServiceCharges() + serviceCharge);
        }
        super.monthlyProcess();
        if (getBalance() < 25) {
            active = false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount Status: " + (isActive() ? "Active" : "Inactive");
    }

   

    public int compareTo(BankAccount other) {
        // Compare SavingsAccount objects based on their balances
        return Double.compare(this.getBalance(), other.getBalance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SavingsAccount)) return false;
        SavingsAccount other = (SavingsAccount) obj;
        return this.getBalance() == other.getBalance() &&
               this.getNumDeposits() == other.getNumDeposits() &&
               this.getNumWithdrawals() == other.getNumWithdrawals() &&
               this.getAnnualInterestRate() == other.getAnnualInterestRate() &&
               this.getMonthlyServiceCharges() == other.getMonthlyServiceCharges() &&
               this.isActive() == other.isActive();
    }

  


     public static void main(String [] args) {
    	SavingsAccount  ss=new SavingsAccount(100.00,2.1);
    	 System.out.println("balnce: $" + ss.getBalance()+ "\nInterest: $"
                 + ss.getAnnualInterestRate() + "\n Deposits:" + ss.getNumDeposits()
                 + "\n withdrawals: " + ss.getNumWithdrawals());

    	 
	
    } 
}