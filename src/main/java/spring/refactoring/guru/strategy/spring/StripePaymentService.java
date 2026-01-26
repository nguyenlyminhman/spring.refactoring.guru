package spring.refactoring.guru.strategy.spring;

import org.springframework.stereotype.Service;

@Service("STRIPE")
public class StripePaymentService implements PaymentService{

    @Override
    public void pay(int amount) {
        System.out.println("Stripe: pay " + amount + "$");
    }
}
