/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author dani
 */
public class Exercise11 {
    
}

class Account {
    String holder;
    double balance;
    
    public Account(String holder) {
        this.holder = holder;
        this.balance = 0;
    }
    
    public double withdraw(double amount){
        if (amount > this.balance) {
            throw new OverdraftException(amount,  this);
        }
        this.balance -= amount;
        return amount;
    }
    
    public void deposit(double amount){
        this.balance += amount;
    }
    
    public void transfer(double amount, Account other) {
        other.deposit(this.withdraw(amount));
    }
}

class VipAccount extends Account {
    double maxOverdraft;
    
    public VipAccount(String holder, double maxOverdraft) { 
        super(holder);
        this.maxOverdraft = maxOverdraft;
    }
    
    @Override
    public double withdraw(double amount){ 
        if (amount > this.balance + this.maxOverdraft) {
            throw new OverdraftException(amount,  this);
        }
        this.balance -= amount;
        return amount;
    }
}

class FixedTermAccount extends Account {
    Date expiry;
    
    public FixedTermAccount(String holder, Date expiry) {
        super(holder);
        this.expiry = expiry;
    }
    
    public double withdraw (double amount, Date on) {
        if (!this.isNotExpired(on)) {amount = 1.05 * amount;}
        
        return super.withdraw(amount);
              
    }
    
    private boolean isNotExpired(Date date) {
        return date.getYear() <= this.expiry.getYear() && 
                date.getMonth() <= this.expiry.getMonth() && 
                date.getDay() <= this.expiry.getDay();
    }
    
    
}

class OverdraftException extends RuntimeException {
    double amount;
    Account account;
    
    public OverdraftException(double amount, Account account){
        this.account = account;
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return String.format("Tried to draw %.2f€ from account %s", this.amount, this.account);
    }
}