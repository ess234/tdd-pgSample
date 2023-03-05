package com.example.pg;

import com.example.pg.application.OrderService;
import com.example.pg.domain.Paymt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PayTest {
    @Test
    void payTest(){
        OrderService order = new OrderService();

        Paymt cardPay = Paymt.cardPay(5000);
        order.pay(cardPay);
        assertEquals(Paymt.cardPay(5000), order.getPaymt(cardPay.paymtMeans()));

        Paymt easyPay = Paymt.easyPay(10000);
        order.pay(easyPay);
        assertEquals(Paymt.easyPay(10000), order.getPaymt(easyPay.paymtMeans()));

        Paymt acctPay = Paymt.acctPay(15000);
        order.pay(acctPay);
        assertEquals(Paymt.acctPay(15000), order.getPaymt(acctPay.paymtMeans()));
    }

    @Test
    void equalTest(){
        assertTrue(Paymt.cardPay(5000).equals(Paymt.cardPay(5000)));
        assertFalse(Paymt.cardPay(5000).equals(Paymt.cardPay(6000)));
        assertTrue(Paymt.easyPay(5000).equals(Paymt.easyPay(5000)));
        assertFalse(Paymt.easyPay(5000).equals(Paymt.easyPay(6000)));
        assertTrue(Paymt.acctPay(5000).equals(Paymt.acctPay(5000)));
        assertFalse(Paymt.acctPay(5000).equals(Paymt.acctPay(6000)));

        assertFalse(Paymt.cardPay(5000).equals(Paymt.easyPay(6000)));
    }

    @Test
    void paymtMeansTest(){
        assertEquals("CARD", Paymt.cardPay(5000).paymtMeans());
        assertEquals("EASY", Paymt.easyPay(5000).paymtMeans());
        assertEquals("ACCT", Paymt.acctPay(5000).paymtMeans());
    }

    @Test
    void complexPayTest(){
        OrderService order = new OrderService();

        Paymt cardPay = Paymt.cardPay(5000);
        Paymt easyPay = Paymt.easyPay(10000);
        order.complexPay(cardPay, easyPay);

        assertEquals(15000, order.totalAmount());
        assertEquals(cardPay, order.getPaymt("CARD"));
        assertEquals(easyPay, order.getPaymt("EASY"));
    }

    @Test
    void cancelTest(){
        OrderService orderService = new OrderService();

        Paymt cardPay = Paymt.cardPay(5000);
        orderService.cancel(cardPay);

        assertEquals("CANCEL", orderService.paymtType());
        assertEquals(-5000, orderService.totalAmount());
    }

    @Test
    void test(){
        Object a = new Paymt(1000,"CARD");
        Object b = new Paymt(1000,"ACCT");

        Paymt cardPay = (Paymt) a;
        Paymt cardPay2 = (Paymt) b;

        System.out.println(cardPay.equals(cardPay2));
    }
}
