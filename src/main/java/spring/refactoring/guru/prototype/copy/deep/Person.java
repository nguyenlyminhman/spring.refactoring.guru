package spring.refactoring.guru.prototype.copy.deep;

import spring.refactoring.guru.prototype.copy.Address;

public class Person {
    String name;
    Address address;

    public Person(String name, Address address) {

        this.name = name;
        this.address = address;
    }

    public Person deepCopy() {
        Address newAddress = new Address(this.address.city);
        return new Person(this.name, newAddress);
    }
}