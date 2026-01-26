package spring.refactoring.guru.facade;

public class MainFacade {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder();
    }
}
