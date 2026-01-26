package spring.refactoring.guru.strategy.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/strategy")
public class StrategyController {

    @Autowired
    private PaymentServiceContext paymentServiceContext;

    @PostMapping("/payment")
    public ResponseEntity<Object> runPayment(@RequestBody PaymentDto dto) throws Exception {
        paymentServiceContext.pay(dto.getType(), dto.getAmount());
        return new ResponseEntity(HttpStatus.OK);
    }
}
