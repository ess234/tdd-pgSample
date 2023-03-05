package com.example.pg.application;

import com.example.pg.domain.Paymt;

public interface PaymtType {
    void pay(Paymt paymt);
    void complexPay(Paymt... paymt);
    void cancel(Paymt paymt);
}
