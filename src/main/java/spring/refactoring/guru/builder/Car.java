package spring.refactoring.guru.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Car {
    private final String name;
    private final int age;
    private final String address;
    private final boolean active;

    public Car(String name, int age, String address, boolean active) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.active = active;
    }

}
