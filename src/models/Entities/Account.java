package models.Entities;

import models.Exceptions.DomainExceptions;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit)  {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainExceptions {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(Double amount) throws DomainExceptions {
        if( amount > withdrawLimit) {
            throw new DomainExceptions("Withdraw error: exceeds withdraw limit");
        }
        else if(amount > balance) {
            throw new DomainExceptions("Withdraw error: not enough balance");
        }
        else {
            System.out.println("New balance " + balance);
        }
    }

}
