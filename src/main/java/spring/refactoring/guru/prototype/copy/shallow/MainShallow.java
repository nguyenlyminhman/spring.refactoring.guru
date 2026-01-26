package spring.refactoring.guru.prototype.copy.shallow;

import spring.refactoring.guru.prototype.copy.Address;

public class MainShallow {
    public static void main(String[] args) throws Exception {
        Address addr = new Address("Tiengiang");
        Human u1 = new Human("Man", addr);

        Human u2 = u1.clone();

        u2.address.city = "Saigon";

        System.out.println("human 1 - address: " + u1.address.city); // Saigon
        System.out.println("human 2 - address: " + u2.address.city); // Saigon
    }
}
