package spring.refactoring.guru.strategy.spring;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceContext {

    private final Map<String, PaymentService> services;

//    @Autowired
//    public PaymentServiceContext(Map<String, PaymentService> services) {
//        PaymentServiceContext.services = services;
//    }

    public void pay(EnumType type, int amount) {
        PaymentService service = services.get(type.name());
        if (service == null) {
            throw new IllegalArgumentException("No service for type: " + type);
        }
        service.pay(amount);
    }
}
