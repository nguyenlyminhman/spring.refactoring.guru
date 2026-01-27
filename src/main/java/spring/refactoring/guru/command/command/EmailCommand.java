package spring.refactoring.guru.command.command;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.refactoring.guru.command.service.EmailService;


@Service
@AllArgsConstructor
public class EmailCommand implements Command {

    @Autowired
    private EmailService emailService;

    @Override
    public void execute(Object context) {
        String email = (String) context;
        emailService.sendOrderEmail(email);
    }
}
