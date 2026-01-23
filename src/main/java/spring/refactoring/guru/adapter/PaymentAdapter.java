package spring.refactoring.guru.adapter;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentAdapter implements PaymentService{

    @Autowired
    private OldPaymentSystem oldSystem;

    @Override
    public void pay(int amount) {
        oldSystem.makePayment((double) amount);
    }
}
