package com.example.pg.application;

import com.example.pg.domain.Paymt;
import com.example.pg.domain.Paymts;

public class OrderService implements PaymtType{
    private Paymts paymts;

    @Override
    public void pay(Paymt paymt) {
        paymts = new Paymts();
        paymts.addPaymt(paymt);
    }

    @Override
    public void complexPay(Paymt... paymt) {
        paymts = new Paymts();

        for (Paymt a : paymt) {
            paymts.addPaymt(a);
        }
    }

    @Override
    public void cancel(Paymt paymt) {
        paymts = new Paymts();

        paymts.cancelPaymt(paymt);
    }

    public Paymt getPaymt(String paymtMeans) {
        return paymts.getPaymt(paymtMeans);
    }

    public int totalAmount() {
        return paymts.totalAmount();
    }

    public String paymtType() {
        return paymts.paymtType();
    }
}
