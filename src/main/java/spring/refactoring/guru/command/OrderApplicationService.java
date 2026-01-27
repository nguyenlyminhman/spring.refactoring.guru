package spring.refactoring.guru.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.command.CommandPipeline;
import spring.refactoring.guru.command.dto.OrderDto;

@Service
public class OrderApplicationService {

    @Autowired
    private CommandPipeline pipeline;

    public void placeOrder(OrderDto order) {
        try {
            pipeline.run(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
