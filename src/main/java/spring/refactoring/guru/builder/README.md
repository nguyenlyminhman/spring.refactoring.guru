# Builder Pattern với Lombok (@Builder)

## Giới thiệu
**Builder Pattern** là một *Creational Design Pattern* dùng để xây dựng các đối tượng phức tạp theo từng bước, giúp code dễ đọc, dễ mở rộng và tránh lỗi do constructor quá nhiều tham số.

Trong Java, có **2 cách phổ biến** để áp dụng Builder Pattern:
1. Tự viết Builder thủ công
2. Dùng Lombok `@Builder`

---

## Cách 1: Tự viết Builder (Builder thủ công)

### Ví dụ
```java
public class User {
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
```

### Sử dụng
```java
User user = new User.Builder()
        .name("Man")
        .age(18)
        .address("Hanoi")
        .active(true)
        .build();
```

**Ưu điểm**
- Kiểm soát logic build
- Có thể validate dữ liệu

**Nhược điểm**
- Nhiều boilerplate code

---

## Cách 2: Dùng Lombok `@Builder`

```java
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private int age;
    private String address;
    private boolean active;
}
```

### Sử dụng
```java
User user = User.builder()
        .name("Tony")
        .age(18)
        .address("HCMC")
        .active(true)
        .build();
```

**Ưu điểm**
- Code gọn, dễ đọc
- Ít boilerplate

**Nhược điểm**
- Phụ thuộc Lombok

---

## @Builder.Default
```java
@Builder
public class User {
    private String name;

    @Builder.Default
    private boolean active = true;
}
```

---

## Lưu ý với JPA Entity
Không nên lạm dụng `@Builder` cho Entity. Nên dùng cho DTO / Request / Response.

---

## Kết luận
- Builder thủ công: dùng khi cần logic phức tạp
- Lombok `@Builder`: dùng cho đa số trường hợp

Happy coding 🚀
