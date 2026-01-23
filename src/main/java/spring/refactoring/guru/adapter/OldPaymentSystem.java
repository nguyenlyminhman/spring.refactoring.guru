package spring.refactoring.guru.adapter;

import org.springframework.stereotype.Service;

@Service
public class OldPaymentSystem {
    void makePayment(double money) {
        System.out.println("Paying " + money + "$ using old system");
    }
}
