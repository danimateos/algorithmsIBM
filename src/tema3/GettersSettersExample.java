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
public class GettersSettersExample {

    public static void main(String[] args) {
        CurrentAccount myaccount = new CurrentAccount("Dani", 1000000);
        System.out.println(myaccount.balance);
        myaccount.balance = -50000;
        System.out.println(myaccount.balance);

        CurrentAccountWithControls mysecureaccount = new CurrentAccountWithControls("Dani", 1000000);
        System.out.println(mysecureaccount.getBalance());
        mysecureaccount.setBalance(50000);
        System.out.println(mysecureaccount.getBalance());
        mysecureaccount.setBalance(-50000);
        System.out.println(mysecureaccount.getBalance());
    }
}

class CurrentAccount {

    String holder;
    int balance;

    public CurrentAccount(String holder, int balance) {
        this.holder = holder;
        this.balance = balance;
    }
}

class CurrentAccountWithControls {

    private String holder;
    private int balance;

    public CurrentAccountWithControls(String holder, int balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new RuntimeException("balance cannot be negative");
        }
    }
}
