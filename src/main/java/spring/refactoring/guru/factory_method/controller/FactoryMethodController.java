package spring.refactoring.guru.factory_method.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.refactoring.guru.factory_method.Logistics;
import spring.refactoring.guru.factory_method.RoadLogistic;
import spring.refactoring.guru.factory_method.SeaLogistic;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/factory-method")
public class FactoryMethodController {

    @GetMapping("/road")
    public void runTask() {
        Logistics logistics = new RoadLogistic();
        logistics.planDelivery();
    }

    @GetMapping("/ship")
    public void runShip() {
        Logistics logistics = new SeaLogistic();
        logistics.planDelivery();
    }
}
