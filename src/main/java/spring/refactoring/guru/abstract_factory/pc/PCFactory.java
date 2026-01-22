package spring.refactoring.guru.abstract_factory.pc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.refactoring.guru.abstract_factory.Computer;
import spring.refactoring.guru.abstract_factory.ComputerAbstractFactory;

@Setter
@Getter
@NoArgsConstructor
public class PCFactory implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, cpu); // Trả về đối tượng PC cụ thể
    }
}
