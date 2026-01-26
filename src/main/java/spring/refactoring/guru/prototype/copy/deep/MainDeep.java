package spring.refactoring.guru.prototype.copy.deep;

import spring.refactoring.guru.prototype.copy.Address;

public class MainDeep {
    public static void main(String[] args) throws Exception {
        Address addr = new Address("Tien giang");
        Person p1 = new Person("Man", addr);

        Person p2 = p1.deepCopy();

        p2.address.city = "Saigon";

        System.out.println("person 1 - address: " + p1.address.city); // Tien giang
        System.out.println("person 2 - address: " + p2.address.city); // Saigon
    }
}
