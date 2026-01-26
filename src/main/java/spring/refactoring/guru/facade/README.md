# Facade Pattern

## 1. Facade Pattern là gì?

**Facade Pattern** là một **Structural Design Pattern**, dùng để **cung
cấp một interface đơn giản** cho **một hệ thống phức tạp gồm nhiều
subsystem**.

Facade đóng vai trò như một "mặt tiền", giúp client: - Không cần biết hệ
thống bên trong phức tạp ra sao - Chỉ cần gọi một method duy nhất để
thực hiện một nghiệp vụ hoàn chỉnh

> 👉 Mục tiêu chính: **giảm độ phức tạp và giảm coupling cho client**

------------------------------------------------------------------------

## 2. Vấn đề Facade giải quyết

Trong các hệ thống thực tế, một use case thường liên quan đến nhiều
service khác nhau: - Authentication - Validation - Payment -
Notification - Logging - Database

Nếu client phải trực tiếp gọi từng service: - Code phức tạp - Phụ thuộc
nhiều class - Khó bảo trì và refactor

👉 Facade ra đời để **gom các bước này lại thành một điểm truy cập duy
nhất**.

------------------------------------------------------------------------

## 3. Cấu trúc Facade Pattern

    Client
       |
       v
    Facade
       |
       +--> Subsystem A
       +--> Subsystem B
       +--> Subsystem C

------------------------------------------------------------------------

## 4. Ví dụ minh họa (Java)

### Các Subsystem

``` java
class AuthService {
    void authenticate() {
        System.out.println("Authenticating...");
    }
}

class PaymentService {
    void pay() {
        System.out.println("Processing payment...");
    }
}

class NotificationService {
    void notifyUser() {
        System.out.println("Sending notification...");
    }
}
```

### Facade

``` java
class OrderFacade {

    private AuthService authService = new AuthService();
    private PaymentService paymentService = new PaymentService();
    private NotificationService notificationService = new NotificationService();

    public void placeOrder() {
        authService.authenticate();
        paymentService.pay();
        notificationService.notifyUser();
    }
}
```

### Client

``` java
public class Client {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder();
    }
}
```

------------------------------------------------------------------------

## 5. Ưu điểm

-   Đơn giản hóa việc sử dụng hệ thống phức tạp
-   Giảm coupling giữa client và subsystem
-   Dễ thay đổi subsystem mà không ảnh hưởng client
-   Phù hợp để làm API, Service Layer, hoặc wrapper cho thư viện bên thứ
    ba

------------------------------------------------------------------------

## 6. Nhược điểm

-   Facade có thể trở thành **God Object** nếu ôm quá nhiều logic
-   Có thể che giấu thiết kế subsystem kém
-   Không thay thế cho việc thiết kế subsystem tốt ngay từ đầu

------------------------------------------------------------------------

## 7. Khi nào nên dùng Facade?

-   Hệ thống có nhiều class, nhiều bước xử lý
-   Một use case cần điều phối nhiều service
-   Muốn cung cấp API đơn giản cho client
-   Áp dụng trong Service Layer, Use Case, hoặc Application Layer

------------------------------------------------------------------------

## 8. So sánh Facade Pattern vs Builder Pattern

### Builder Pattern là gì?

**Builder Pattern** là một **Creational Pattern**, dùng để: - Tạo object
phức tạp từng bước - Tách quá trình tạo object khỏi representation

Ví dụ:

``` java
User user = User.builder()
    .name("Man")
    .email("man@gmail.com")
    .age(20)
    .build();
```

------------------------------------------------------------------------

### So sánh trực tiếp

Tiêu chí          Facade                  Builder
  ----------------- ----------------------- ---------------------
Loại pattern      Structural              Creational
Mục đích          Đơn giản hóa workflow   Tạo object phức tạp
Quan tâm chính    Hành vi (behavior)      Dữ liệu (state)
Đối tượng xử lý   Nhiều subsystem         Một object
Output            Hành động / kết quả     Object
Client gọi        1 method                Nhiều bước

------------------------------------------------------------------------

## 9. Vì sao không nên dùng Builder thay Facade?

``` java
OrderProcess process = OrderProcess.builder()
    .authenticate()
    .pay()
    .notifyUser()
    .build();
```

Cách này: - Làm sai ý nghĩa của Builder - `build()` không còn tạo object
đúng nghĩa - Business workflow bị ngụy trang thành object construction

👉 Đây là **design smell**, không phải best practice.

------------------------------------------------------------------------

## 10. Kết luận

-   **Facade** dùng để **đơn giản hóa cách sử dụng hệ thống**
-   **Builder** dùng để **tạo object phức tạp từng bước**
-   Hai pattern có thể giống về hình thức, nhưng **khác hoàn toàn về mục
    đích**

> ✨ Facade càng "bình thường" thì thiết kế càng đúng.
