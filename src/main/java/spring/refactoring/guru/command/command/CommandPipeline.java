package spring.refactoring.guru.command.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.dto.OrderDto;

@Service
public class CommandPipeline {
    @Autowired
    private OrderCommand orderCommand;

    @Autowired
    private EmailCommand emailCommand;

    public void run(OrderDto order) {
        orderCommand.execute(order.getId());
        emailCommand.execute(order.getCustomerEmail());
    }
}
