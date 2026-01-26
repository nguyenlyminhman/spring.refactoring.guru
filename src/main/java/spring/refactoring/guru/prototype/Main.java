package spring.refactoring.guru.prototype;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Neko", 5);

        Circle cloneCircle = (Circle) circle.clone();
        System.out.println("Original: " + circle);
        System.out.println("Clone: " + cloneCircle);
    }
}
