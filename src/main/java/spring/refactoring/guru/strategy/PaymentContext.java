package spring.refactoring.guru.strategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int amount) {
        strategy.pay(amount);
    }
}
