package com.example.TestAcc;

import java.util.Date;

//starting code
public class Account implements Comparable<Account>{
    private String id;
    private double balance;
    private Date dateCreated;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString(){
        return "Account:" + this.id;
    }

    @Override
    public int compareTo(Account account) { // use IDE to generate, compareTo() is the first unnatural sort
        return Double.compare(this.balance,account.balance);
        // another way is to if(this.balance > account.balance) return 1, < return -1, else return 0
    }
}

