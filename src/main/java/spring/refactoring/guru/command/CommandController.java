package spring.refactoring.guru.command;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.refactoring.guru.command.dto.OrderDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/command")
public class CommandController {

    @Autowired
    private OrderApplicationService service;

    @PostMapping("/execute")
    public void execute(@RequestBody OrderDto order) {
        service.placeOrder(order);
    }
}
