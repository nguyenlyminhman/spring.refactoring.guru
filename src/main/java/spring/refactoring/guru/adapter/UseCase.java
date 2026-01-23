package spring.refactoring.guru.adapter;

public class UseCase {
    public static void main(String[] args) {
        PaymentService payment = new PaymentAdapter(new OldPaymentSystem());
        payment.pay(100);
    }
}
