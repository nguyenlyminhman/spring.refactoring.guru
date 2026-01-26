package spring.refactoring.guru.facade;

public class OrderFacade {
    private AuthService auth = new AuthService();
    private PaymentService payment = new PaymentService();
    private NotificationService notification = new NotificationService();

    public void placeOrder() {
        auth.authenticate();
        payment.pay();
        notification.sendEmail();
    }
}
