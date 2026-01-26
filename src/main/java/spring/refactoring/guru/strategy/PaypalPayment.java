package spring.refactoring.guru.strategy;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paypal: pay " + amount + "$");
    }
}
