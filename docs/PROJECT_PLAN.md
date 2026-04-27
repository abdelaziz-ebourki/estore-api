# 🛍️ E-Store Full Stack Master Plan
**Strict Compliance with Cahier des Charges (CDC)**

## 🏗️ Project Overview
This project is a multi-repo Full Stack application for a simplified E-Commerce platform. It follows a layered architecture organized by functional domains.

### 👥 Team & Repositories
- **Backend:** [estore-api](./BACKEND_PLAN.md) - Spring Boot, JPA, H2/MySQL, MongoDB.
- **Frontend:** [estore-ui](./FRONTEND_PLAN.md) - React, JavaScript, Tailwind CSS, shadcn/ui.

---

## 🛠️ Global Constraints (CDC Compliant)
1. **Multi-Database:** 
   - **JPA (H2/MySQL):** All transactional data (Users, Products, Orders, Cart).
   - **MongoDB:** Documentary data (Product Reviews, Search History).
2. **Domain-Driven Design:** The project is divided into 5 core domains:
   - **Customer:** Identity & Profiles.
   - **Catalog:** Product discovery & Categories.
   - **Inventory:** Stock tracking.
   - **Shopping:** Cart management.
   - **Billing:** Order validation & History.
3. **Optional Features Included:** 
   - Spring Security + JWT Authentication.
   - Admin Roles (Product/Stock Management).
   - Server-side Pagination.
   - Global Exception Handling.
   - Automated Unit & API Tests.

---

## 📅 High-Level Timeline (4 Days)

| Day | Phase | Key Milestone |
| :--- | :--- | :--- |
| **1** | **Conception & Setup** | Projects initialized, DB schemas validated, Security configured. |
| **2** | **Core Modules** | Auth, Catalog, and Profiles functional on both ends. |
| **3** | **Transaction Flow** | Cart, Checkout, and Order history completed. |
| **4** | **Finalization** | MongoDB Reviews, Admin features, MySQL switch, and PDF Report. |

---

## 📜 Deliverables Checklist
- [ ] Backend Source Code (Maven project).
- [ ] Frontend Source Code (React project).
- [ ] Database Scripts (SQL for MySQL + MongoDB initialization).
- [ ] Comprehensive README (Setup & Execution instructions).
- [ ] Technical Documentation (PDF Report including Diagrams & API Docs).
- [ ] Demonstration Data (Realistic products, categories, and test accounts).

---
*For detailed implementation steps, refer to the specific plans:*
👉 **[Detailed Backend Plan](./BACKEND_PLAN.md)**  
👉 **[Detailed Frontend Plan](./FRONTEND_PLAN.md)**
