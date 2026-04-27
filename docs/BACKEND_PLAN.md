# 🖥️ E-Store Backend Plan (Spring Boot)

**Repository Name:** `estore-api`  
**Owner:** Student A

## 🛠️ Tech Stack & Requirements

- **Framework:** Spring Boot 3.x (Maven)
- **Language:** Java 21
- **Primary DB (JPA):** H2 (Dev) ➔ MySQL (Production)
- **Document DB:** MongoDB (Reviews & Search History)
- **Security:** Spring Security + JWT (Stateless) - _Optional Bonus_
- **Architecture:** Layered (Controller -> Service -> Repository) organized by Domain.

## 🧬 Data Model (Strictly per CDC Section 9 & 12)

### JPA Entities

1. **User (1-1) Profile:** Identity vs. personal details (Phone, Address, City, Country).
2. **Category (1-N) Product:** Product categorization.
3. **Product (1-1) Inventory:** Separate entity for stock management (Quantity).
4. **Cart (1-N) CartItem:** Persistence for the shopping cart.
5. **Order (1-N) OrderItem:** Transactional history.

### MongoDB Documents

- **Review:** `id`, `productId`, `userId`, `authorName`, `note`, `comment`, `date`.
- **SearchHistory:** _Optional_ - `userId`, `keyword`, `timestamp`.

## 🚀 Implementation Roadmap

### Phase 1: Infrastructure & Core (Day 1)

- [ ] Initialize Spring Boot with: `web`, `data-jpa`, `data-mongodb`, `validation`, `lombok`, `security`.
- [ ] Configure H2 and MongoDB connection strings.
- [ ] Setup Base Package Structure: `com.estore.[domain].[controller/service/repository/entity/dto/mapper]`.
- [ ] Global Exception Handling: `@ControllerAdvice` for 404, 400, 403 errors.

### Phase 2: Domain Implementation (Day 2)

- [ ] **Customer Domain:** JWT Authentication, Registration (unique email), Profile update.
- [ ] **Catalog Domain:** Category & Product CRUD. Add **Pagination** (Bonus).
- [ ] **Inventory Domain:** Stock check logic and updates.

### Phase 3: Transactional Logic (Day 3)

- [ ] **Shopping Domain:** Cart management (Add/Update/Remove/Clear).
- [ ] **Billing Domain:** Order validation (Stock check -> Create Order -> Update Stock -> Empty Cart).
- [ ] **MongoDB Integration:** Product Reviews endpoints.

### Phase 4: Finalization & Quality (Day 4)

- [ ] **Admin Features:** Secured endpoints for adding products and viewing all orders.
- [ ] **Automated Tests:** JUnit/Mockito for Services; MockMvc for API testing.
- [ ] **Data Seeding:** `CommandLineRunner` to populate categories, products, and a test admin.
- [ ] **MySQL Migration:** Update `application.properties` and provide `schema.sql`.

## 📂 Project Structure (Annexe A Compliance)

```text
src/main/java/com/estore/
├── customer/   # Auth, User, Profile
├── catalog/    # Category, Product
├── inventory/  # Stock Management
├── shopping/   # Cart, CartItem
├── billing/    # Order, OrderItem
├── review/     # MongoDB Documents
├── shared/     # DTOs, Mappers, Constants
├── config/     # SecurityConfig, MongoConfig
└── exception/  # Global Exception Handler
```
