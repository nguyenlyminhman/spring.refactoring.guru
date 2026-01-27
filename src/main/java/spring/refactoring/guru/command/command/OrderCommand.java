package spring.refactoring.guru.command.command;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.service.OrderService;

@Service
@AllArgsConstructor
public class OrderCommand implements Command {

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(Object context) {
        String orderId = String.valueOf(context);
        orderService.processOrder(orderId);
    }
}