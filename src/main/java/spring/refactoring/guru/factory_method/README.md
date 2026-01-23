# Factory Method Pattern – Ví dụ Transport / Logistics

## 1. Mục tiêu của ví dụ

Ví dụ này minh họa **Factory Method Pattern (theo GoF)** thông qua một bài toán quen thuộc:

- Hệ thống cần **lên kế hoạch giao hàng (delivery)**
- Có nhiều cách vận chuyển khác nhau:
    - Đường bộ (Truck)
    - Đường biển (Ship)
- Code nghiệp vụ **không phụ thuộc** vào loại phương tiện cụ thể
- Việc quyết định dùng phương tiện nào được giao cho **subclass**

👉 Đây chính là mục đích cốt lõi của **Factory Method Pattern**.

---

## 2. Tổng quan kiến trúc

Các vai trò trong Factory Method:

- **Product**: `Transport`
- **Concrete Products**: `Truck`, `Ship`
- **Creator**: `Logistics`
- **Concrete Creators**: `RoadLogistics`, `SeaLogistics`
- **Client**: code gọi `planDelivery()`

---

## 3. Product – Transport

```java
public interface Transport {
    void deliver();
}
```

### Giải thích

- `Transport` là **interface chung** cho mọi phương tiện vận chuyển
- Khai báo hành vi `deliver()` mà mọi phương tiện phải có
- Code phía trên **không quan tâm** phương tiện là Truck hay Ship

👉 Giúp client làm việc với abstraction thay vì implementation cụ thể.

---

## 4. Concrete Products – Truck và Ship

### 4.1 Truck

```java
public class Truck implements Transport {
    public void deliver() {
        System.out.println("Deliver by land");
    }
}
```

### 4.2 Ship

```java
public class Ship implements Transport {
    public void deliver() {
        System.out.println("Deliver by sea");
    }
}
```

### Giải thích

- `Truck` và `Ship` là **các implementation cụ thể** của `Transport`
- Mỗi class cung cấp cách `deliver()` khác nhau
- Client **không khởi tạo trực tiếp** các class này

---

## 5. Creator – Logistics (chứa Factory Method)

```java
public abstract class Logistics {

    // Factory Method
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
```

### Giải thích chi tiết

- `createTransport()` chính là **Factory Method**
- `Logistics`:
    - Không biết sẽ tạo `Truck` hay `Ship`
    - Chỉ biết nó cần một `Transport`
- `planDelivery()` chứa **logic nghiệp vụ ổn định**

👉 Việc khởi tạo object được **trì hoãn** cho subclass quyết định.

---

## 6. Concrete Creators – Quyết định phương tiện cụ thể

### 6.1 RoadLogistics

```java
public class RoadLogistics extends Logistics {
    public Transport createTransport() {
        return new Truck();
    }
}
```

### 6.2 SeaLogistics

```java
public class SeaLogistics extends Logistics {
    public Transport createTransport() {
        return new Ship();
    }
}
```

### Giải thích

- Mỗi subclass là một **Concrete Creator**
- Chịu trách nhiệm quyết định object cụ thể được tạo
- Đây là **nơi duy nhất** xuất hiện `new Truck()` hoặc `new Ship()`

---

## 7. Client code – Sử dụng hệ thống

```java
Logistics logistics = new RoadLogistics();
logistics.planDelivery();
```

### Luồng chạy thực tế

1. Client gọi `planDelivery()`
2. Method trong `Logistics` được 실행
3. Gọi `createTransport()`
4. Java chọn implementation của `RoadLogistics`
5. Tạo object `Truck`
6. Gọi `deliver()` → in ra `Deliver by land`

👉 Client **không biết và không cần biết** đang dùng Truck hay Ship.

---

## 8. Mở rộng hệ thống (Open / Closed Principle)

Thêm vận chuyển đường hàng không:

```java
class Plane implements Transport {
    public void deliver() {
        System.out.println("Deliver by air");
    }
}

class AirLogistics extends Logistics {
    public Transport createTransport() {
        return new Plane();
    }
}
```

- ❌ Không sửa code cũ
- ✅ Chỉ thêm class mới
- ✅ Tuân thủ **Open / Closed Principle**

---

## 9. Why not Simple Factory?

### 9.1 Simple Factory là gì?

Simple Factory thường được cài đặt bằng một class factory duy nhất, sử dụng `if / else` hoặc `switch` để quyết định object cần tạo.

```java
class TransportFactory {
    public static Transport create(String type) {
        if (type.equals("road")) {
            return new Truck();
        } else if (type.equals("sea")) {
            return new Ship();
        }
        throw new IllegalArgumentException();
    }
}
```

Client sử dụng:

```java
Transport transport = TransportFactory.create("road");
transport.deliver();
```

---

### 9.2 Hạn chế của Simple Factory

- ❌ **Vi phạm Open / Closed Principle**: thêm phương tiện mới phải sửa factory cũ
- ❌ **Phụ thuộc vào điều kiện (if / else)**: factory ngày càng phình to
- ❌ **Không tận dụng tốt đa hình** của OOP

Simple Factory phù hợp cho ví dụ nhỏ hoặc demo nhanh, nhưng không tối ưu cho hệ thống lớn.

---

### 9.3 Vì sao Factory Method tốt hơn?

- Logic nghiệp vụ (`planDelivery()`) **không thay đổi**
- Việc tạo object được **đẩy xuống subclass**
- Mở rộng hệ thống bằng cách **thêm class mới**, không sửa code cũ

👉 Phù hợp với hệ thống cần mở rộng và bảo trì lâu dài.

---

## 10. Kết luận

> **Factory Method Pattern đưa việc khởi tạo object xuống subclass,  
> trong khi logic nghiệp vụ ở class cha vẫn giữ nguyên.**

Ví dụ Transport / Logistics là minh họa kinh điển, dễ hiểu và rất phổ biến khi học Factory Method Pattern.
