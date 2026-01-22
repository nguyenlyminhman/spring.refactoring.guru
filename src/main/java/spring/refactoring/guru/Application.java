package spring.refactoring.guru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.refactoring.guru.abstract_factory.*;
import spring.refactoring.guru.abstract_factory.pc.PCFactory;
import spring.refactoring.guru.abstract_factory.server.ServerFactory;

@SpringBootApplication(scanBasePackages = {"spring.refactoring.guru"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
