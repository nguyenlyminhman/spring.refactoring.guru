package spring.refactoring.guru.abstract_factory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.refactoring.guru.abstract_factory.Computer;
import spring.refactoring.guru.abstract_factory.ComputerFactory;
import spring.refactoring.guru.abstract_factory.pc.PCFactory;
import spring.refactoring.guru.abstract_factory.server.ServerFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/abstract-factory")
public class AbstractFactoryController {

    @GetMapping("/run")
    public void reassignTask() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("1", "2", "3"));
        System.out.println("AbstractFactory PC Config::"+pc);

        Computer server = ComputerFactory.getComputer(new ServerFactory("S1", "S2", "S3"));
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
