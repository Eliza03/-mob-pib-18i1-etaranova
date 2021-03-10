package com.company;

public class Operation {

    int number = 0;
    public Account debet;
    public Account credit;
    double money;

    public Operation(int number, Account debet, Account credit, double money)
    {
        this.number = number;
        this.debet = debet;
        this.credit = credit;
        this.money = money;

        number++;
        debet.balance += money;
        credit.balance -= money;
    }

    public Account getDebet() {
        return debet;
    }

    public void setDebet(Account debet) {
        this.debet = debet;
    }

    public Account getCredit() {
        return credit;
    }

    public void setCredit(Account credit) {
        this.credit = credit;
    }
    @Override
    public String toString() {
        return "number - " + number +
                " debet - " + debet.getNumber() +
                " credit - " + credit.getNumber() +
                " money - " + money;
    }
}
