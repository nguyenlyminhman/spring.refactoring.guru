# Adapter Pattern (Design Patterns)

## 📌 Adapter Pattern là gì?
**Adapter Pattern** là một *Structural Design Pattern* cho phép các class có **interface không tương thích** có thể làm việc với nhau thông qua một class trung gian gọi là **Adapter**.

👉 Adapter hoạt động giống như một “bộ chuyển đổi”, giúp client sử dụng được code cũ hoặc thư viện bên ngoài mà **không cần sửa code gốc**.

---

## 🎯 Vấn đề cần giải quyết
- Client mong đợi một interface cụ thể
- Nhưng class có sẵn (legacy / third-party) lại có interface khác
- Không thể thay đổi class cũ

➡️ **Adapter Pattern** giúp chuyển đổi interface cũ sang interface mà client cần.

---

## 🧩 Cấu trúc
Adapter Pattern gồm các thành phần:

- **Target**: Interface mà client mong đợi
- **Adaptee**: Class có sẵn (interface không tương thích)
- **Adapter**: Lớp trung gian, implements Target và wrap Adaptee
- **Client**: Sử dụng Target

---

## 📦 Ví dụ minh họa (Java)

### 1️⃣ Target Interface
```java
public interface PaymentService {
    void pay(int amount);
}
```

### 2️⃣ Adaptee (Hệ thống cũ)
```java
public class OldPaymentSystem {
    public void makePayment(double money) {
        System.out.println("Paying " + money + " using old payment system");
    }
}
```

### 3️⃣ Adapter
```java
public class PaymentAdapter implements PaymentService {

    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void pay(int amount) {
        oldPaymentSystem.makePayment((double) amount);
    }
}
```
### 2️⃣ Adaptee (Hệ thống cũ)
```java
public class Main {
    public static void main(String[] args) {
        PaymentService paymentService =
                new PaymentAdapter(new OldPaymentSystem());

        paymentService.pay(100);
    }
}
```
## ✅ Ưu điểm
- Tái sử dụng code cũ
- Không cần sửa đổi class đã tồn tại
- Giảm phụ thuộc giữa client và hệ thống cũ
- Dễ tích hợp thư viện bên thứ ba

---

## ❌ Nhược điểm
- Tăng số lượng class
- Lạm dụng Adapter có thể làm code phức tạp

---

## 🕒 Khi nào nên dùng Adapter Pattern?
- ✔️ Khi muốn dùng lại code legacy
- ✔️ Khi tích hợp API hoặc thư viện bên ngoài
- ✔️ Khi interface không tương thích
- ✔️ Khi không thể hoặc không nên sửa code cũ

