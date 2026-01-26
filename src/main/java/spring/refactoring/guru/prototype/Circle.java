package spring.refactoring.guru.prototype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle implements Prototype {
    private String name;
    private int radius;

    @Override
    public Prototype clone() {
        return new Circle(this.name, this.radius);
    }

    public String toString() {
        return  name + " with radius: " + radius;
    }
}
