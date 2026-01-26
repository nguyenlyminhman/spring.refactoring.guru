package spring.refactoring.guru.prototype.copy.shallow;

import spring.refactoring.guru.prototype.copy.Address;

public class Human implements Cloneable {
    String name;
    Address address;

    public Human(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Human clone() throws CloneNotSupportedException {
        return (Human) super.clone(); // shallow copy
    }
}