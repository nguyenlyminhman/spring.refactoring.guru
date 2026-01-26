# Prototype Pattern (Shallow Copy & Deep Copy)

Prototype Pattern là một **Creational Design Pattern** cho phép tạo object mới bằng cách **clone (nhân bản)** từ một object mẫu (prototype) đã tồn tại, thay vì khởi tạo bằng `new`.

Tài liệu này tập trung vào **2 cách áp dụng Prototype**:
- Prototype với **Shallow Copy**
- Prototype với **Deep Copy**

---

## 1. Khi nào cần Prototype Pattern?

Prototype phù hợp khi:
- Object có cấu trúc **phức tạp**, nhiều field
- Chi phí khởi tạo object cao
- Cần tạo object **runtime**, dựa trên template
- Muốn tránh phụ thuộc trực tiếp vào constructor

Ví dụ thực tế:
- Clone document / slide / shape
- Nhân bản enemy, weapon trong game
- Clone cấu hình mặc định
- Spring Bean scope `prototype`

---

## 2. Cấu trúc Prototype Pattern

Prototype Pattern thường gồm:

1. **Prototype Interface** – khai báo phương thức clone
2. **Concrete Prototype** – implement clone
3. **Client** – sử dụng clone để tạo object mới

---

## 3. Mô hình ví dụ chung

```java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

interface Prototype<T> {
    T clone();
}
```

---

## 4. Trường hợp 1: Prototype với Shallow Copy

### 4.1 Đặc điểm

- Object cha được clone
- Object con **dùng chung reference**
- Clone nhanh, code đơn giản

### 4.2 Cài đặt Shallow Copy Prototype

```java
class User implements Prototype<User>, Cloneable {
    String name;
    Address address;

    User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### 4.3 Sử dụng

```java
Address addr = new Address("Tiengiang");
User prototype = new User("Man", addr);

User user1 = prototype.clone();
User user2 = prototype.clone();

user2.address.city = "Saigon";

System.out.println(user1.address.city); // Saigon
System.out.println(user2.address.city); // Saigon
```

### 4.4 Phân tích

```
prototype.address ─┐
user1.address      ├──> Address("Saigon")
user2.address      ─┘
```

👉 Tất cả bản clone **ảnh hưởng lẫn nhau** khi sửa object con.

### 4.5 Khi nào dùng Shallow Copy Prototype?

- Object con là immutable
- Dữ liệu chỉ đọc
- Ưu tiên hiệu năng

---

## 5. Trường hợp 2: Prototype với Deep Copy

### 5.1 Đặc điểm

- Clone **toàn bộ object graph**
- Mỗi object là một instance độc lập
- An toàn nhưng code phức tạp hơn

### 5.2 Cài đặt Deep Copy Prototype

```java
class User implements Prototype<User> {
    String name;
    Address address;

    User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public User clone() {
        Address newAddress = new Address(this.address.city);
        return new User(this.name, newAddress);
    }
}
```

### 5.3 Sử dụng

```java
Address addr = new Address("Tiengiang");
User prototype = new User("Man", addr);

User user1 = prototype.clone();
User user2 = prototype.clone();

user2.address.city = "Saigon";

System.out.println(user1.address.city); // Tiengiang
System.out.println(user2.address.city); // Saigon
```

### 5.4 Phân tích

```
user1.address ──> Address("TienGiang")
user2.address ──> Address("Saigon")
```

👉 Các object **độc lập hoàn toàn**.

---

## 6. So sánh Shallow vs Deep trong Prototype

| Tiêu chí | Shallow Prototype | Deep Prototype |
|--------|------------------|----------------|
| Object con | Dùng chung | Tạo mới |
| An toàn | Thấp | Cao |
| Hiệu năng | Cao | Thấp hơn |
| Code | Ngắn | Dài |
| Dễ bug | Cao | Thấp |

---

## 7. Lưu ý khi dùng Prototype Pattern

- `Object.clone()` **luôn là shallow copy**
- Deep copy cần implement thủ công
- Đặc biệt cẩn thận với:
    - Collection
    - Quan hệ nhiều tầng
    - Entity JPA

---

## 8. Kết luận

- Prototype Pattern giúp tạo object nhanh và linh hoạt
- **Shallow Copy** phù hợp object đơn giản, immutable
- **Deep Copy** phù hợp object phức tạp, cần an toàn

👉 Khi áp dụng Prototype, **điều quan trọng nhất là hiểu rõ object graph**.

---

Happy cloning 🚀

