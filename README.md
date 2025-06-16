# 💳 Bank Management System

A Java-based Bank Management System that simulates essential banking operations such as account creation, deposits, withdrawals, fund transfers, and user authentication via a graphical user interface (GUI).

## 📌 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Modules](#modules)
  - [Admin Module](#admin-module)
  - [User Module](#user-module)
- [System Requirements](#system-requirements)
- [How to Run](#how-to-run)
- [Database SQL Queries](#database-sql-queries)
- [Future Enhancements](#future-enhancements)
- [Screenshots](#screenshots)
- [Contributors](#contributors)
- [License](#license)

---

## 📖 About the Project

This project is a simulation of a real-world bank management system using Java. The application allows both administrators and users to perform day-to-day banking transactions online in a secure and user-friendly manner.

It includes operations like:
- Account creation
- Depositing and withdrawing money
- Viewing account details
- Fund transfers
- Transaction history

The system uses **Java Swing** for GUI and **MySQL** as the backend database.

---

## ✅ Features

- Secure login for users and admin
- Create and manage accounts
- Deposit/Withdraw money
- Transfer funds (local/international)
- Transaction history
- Real-time balance update
- Admin-controlled account management

---

## 🛠 Technologies Used

- **Java**
- **Java Swing (AWT)**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **NetBeans / Eclipse IDE**

---

## 🧩 Modules

### 👨‍💼 Admin Module
- Admin login
- Add, delete or update accounts
- View all transactions
- Activate/deactivate accounts
- Manage user details

### 👨‍💻 User Module
- User login via PIN
- Create account
- Deposit/Withdraw money
- Transfer funds
- View account balance & history
- Update password & PIN

---

## 💻 System Requirements

- Java JDK 8 or later
- MySQL 5.7 or later
- JDBC Driver for MySQL
- IDE: Eclipse or NetBeans

---

## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/bank-management-system.git
   ```

2. **Open the project in your IDE** (e.g., Eclipse or NetBeans)

3. **Set up the MySQL Database**
   - Create the database and required tables using the queries below.
   - Update DB credentials in `Conn.java`:
     ```java
     Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "your_password");
     ```

4. **Run the `Login.java` or `Main.java` file**

---

## 🗄 Database SQL Queries

```sql
CREATE DATABASE bankmanagementsystem;

SHOW DATABASES;

USE bankmanagementsystem;

CREATE TABLE signup (
  formno VARCHAR(20),
  name VARCHAR(40),
  father_name VARCHAR(40),
  dob VARCHAR(20),
  gender VARCHAR(20),
  email VARCHAR(30),
  marital_status VARCHAR(20),
  address VARCHAR(40),
  city VARCHAR(25),
  state VARCHAR(25),
  pincode VARCHAR(20)
);

SHOW TABLES;

DESCRIBE signup;

ALTER TABLE signup
MODIFY name VARCHAR(100),
MODIFY father_name VARCHAR(100),
MODIFY email VARCHAR(140);

SELECT * FROM signup;

CREATE TABLE signuptwo (
  formno VARCHAR(20),
  religion VARCHAR(20),
  category VARCHAR(20),
  income VARCHAR(20),
  education VARCHAR(20),
  occupation VARCHAR(20),
  pan VARCHAR(30),
  aadhar VARCHAR(30),
  senior_citizen VARCHAR(20),
  existing_account VARCHAR(20)
);

SELECT * FROM signuptwo;

CREATE TABLE signupthree (
  formno VARCHAR(20),
  accountType VARCHAR(30),
  cardnumber VARCHAR(25),
  pin VARCHAR(10),
  facility VARCHAR(100)
);

SELECT * FROM signupthree;

CREATE TABLE login (
  formno VARCHAR(20),
  cardnumber VARCHAR(25),
  pin VARCHAR(10)
);

SELECT * FROM login;

DROP TABLE bank;

CREATE TABLE bank (
  pin VARCHAR(10),
  date VARCHAR(50),
  type VARCHAR(20),
  amount VARCHAR(20)
);

SELECT * FROM bank;
```

---

## 🔮 Future Enhancements

- Mobile Banking App (Android/iOS)
- ATM Card Simulation
- Integration with Payment Gateways
- Biometric Authentication
- Multi-currency support
- RESTful API for banking operations

---

## 🖼 Screenshots

#### 🔐 Login Page
![Login Page](https://github.com/digvijaykorake2002/Bank-Account-Management-System/blob/540258c5bc1e8f9980a69d9f47a35201ac046228/src/icons/Login%20Page.png)

#### 📝 Sign Up - Page 1 (Personal Details)
![Sign Up Page 1](signup-page1.png)

#### 📋 Sign Up - Page 2 (Additional Details)
![Sign Up Page 2](signup-page2.png)

#### 💳 Sign Up - Page 3 (Account Details)
![Sign Up Page 3](signup-page3.png)

#### 🧾 Transaction Page
![Transaction Page](transaction-page.png)

---

## 👥 Contributors

- **Digvijay Korake** - Developer  
- **Tyagi Sir** - Project Guide

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
