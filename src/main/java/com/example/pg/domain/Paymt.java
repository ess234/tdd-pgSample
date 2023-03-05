package com.example.pg.domain;

public class Paymt {
    private int amount;
    private String paymtMeans;

    public Paymt(int amount, String paymtMeans) {
        this.amount = amount;
        this.paymtMeans = paymtMeans;
    }

    public static Paymt cardPay(int amount){
        return new Paymt(amount, "CARD");
    }

    public static Paymt easyPay(int amount){
        return new Paymt(amount, "EASY");
    }

    public static Paymt acctPay(int amount){
        return new Paymt(amount, "ACCT");
    }

    public int amount() {
        return amount;
    }

    public String paymtMeans() {
        return paymtMeans;
    }

    @Override
    public boolean equals(Object object) {
        Paymt paymt = (Paymt) object;
        Paymt paymt2 = (Paymt) object;


        return this.amount == paymt.amount
                && paymtMeans().equals(paymt.paymtMeans());
    }
}
