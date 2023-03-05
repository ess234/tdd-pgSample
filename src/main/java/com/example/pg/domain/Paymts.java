package com.example.pg.domain;

import java.util.ArrayList;
import java.util.List;

public class Paymts {
    private int totalAmount;
    private String paymtType;
    private List<Paymt> paymtList = new ArrayList<>();

    public void addPaymt(Paymt paymt){
        paymtType = "APROV";

        totalAmount = totalAmount+paymt.amount();
        paymtList.add(paymt);
    }

    public void cancelPaymt(Paymt paymt) {
        paymtType = "CANCEL";

        totalAmount = -1 * (totalAmount+paymt.amount());
        paymtList.add(paymt);
    }

    public Paymt getPaymt(String paymtMeans) {
        Paymt paymt = paymtList.stream()
                .filter(a -> paymtMeans.equals(a.paymtMeans()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return paymt;
    }

    public int totalAmount() {
        return totalAmount;
    }

    public String paymtType(){
        return paymtType;
    }
}
