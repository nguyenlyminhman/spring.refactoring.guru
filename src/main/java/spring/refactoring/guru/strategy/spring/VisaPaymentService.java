package spring.refactoring.guru.strategy.spring;

import org.springframework.stereotype.Service;

@Service("VISA")
public class VisaPaymentService implements PaymentService{
    @Override
    public void pay(int amount) {
        System.out.println("Visa: pay " + amount + "$");
    }
}
