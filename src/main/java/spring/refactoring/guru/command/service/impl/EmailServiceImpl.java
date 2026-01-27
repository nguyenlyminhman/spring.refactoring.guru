package spring.refactoring.guru.command.service.impl;

import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendOrderEmail(String orderId) {
        System.out.println("Gửi email xác nhận cho order " + orderId);
    }
}
