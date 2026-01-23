package spring.refactoring.guru.builder;

public class User  {

    private final String name;
    private final int age;
    private final String address;
    private final boolean active;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.active = builder.active;
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;
        private boolean active;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
