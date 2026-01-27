package spring.refactoring.guru.command.service.impl;

import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void processOrder(String orderId) {
        System.out.println("Order: " + orderId + " đã được tạo");
    }
}
