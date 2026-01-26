package spring.refactoring.guru.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("CreditCard: pay " + amount + "$");
    }
}
