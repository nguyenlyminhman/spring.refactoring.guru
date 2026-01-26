package spring.refactoring.guru.strategy;

public class MainStrategy {
    public static void main(String [] a) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.execute(100);

        context.setStrategy(new PaypalPayment());
        context.execute(200);
    }
}
