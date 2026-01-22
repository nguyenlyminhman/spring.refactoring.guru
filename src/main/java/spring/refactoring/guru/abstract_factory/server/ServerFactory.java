package spring.refactoring.guru.abstract_factory.server;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.refactoring.guru.abstract_factory.Computer;
import spring.refactoring.guru.abstract_factory.ComputerAbstractFactory;

@Setter
@Getter
@NoArgsConstructor
public class ServerFactory implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu); // Trả về đối tượng PC cụ thể
    }
}
