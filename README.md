# Library-Management-System
# 📚 Library Management System

A console-based **Library Management System** developed in **Java** using **JDBC** and **MySQL**. This application helps manage library operations such as adding books, managing students, issuing books, and returning books through a simple menu-driven interface.

---

## 🚀 Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse IDE
- Git & GitHub

---

## ✨ Features

- 📖 Add new books
- 📚 View all books
- ✏️ Update book details
- ❌ Delete books
- 👨‍🎓 Add and manage students
- 📕 Issue books to students
- 📗 Return issued books
- 💾 Store and retrieve data using MySQL database

---

## 📂 Project Structure

```
Librarymanage/
│
├── src/
│   ├── Connect/
│   │   └── DBConnection.java
│   ├── dao/
│   │   └── Operations.java
│   ├── dto/
│   │   ├── book.java
│   │   ├── student.java
│   │   └── issuebook.java
│   ├── user/
│   │   └── Userlogic.java
│   └── module-info.java
│
├── .classpath
├── .project
└── .gitignore
```

---

## 🗄️ Database

Create a MySQL database (for example `library_db`) and create the required tables.

### Book Table

| Column | Type |
|---------|------|
| book_id | INT |
| book_name | VARCHAR |
| author | VARCHAR |
| price | DOUBLE |

### Student Table

| Column | Type |
|---------|------|
| student_id | INT |
| student_name | VARCHAR |
| phone | VARCHAR |

### IssueBook Table

| Column | Type |
|---------|------|
| issue_id | INT |
| student_id | INT |
| book_id | INT |
| issue_date | DATE |

---

## ⚙️ How to Run

1. Clone the repository

```bash
git clone https://github.com/palletijeevan123/Library-Management-System.git
```

2. Open the project in Eclipse.

3. Create the MySQL database.

4. Update the database credentials in:

```
src/Connect/DBConnection.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/library_db";
String username = "root";
String password = "your_password";
```

5. Add the MySQL JDBC Driver to the project.

6. Run:

```
Userlogic.java
```

---

## 📸 Sample Menu

```
========= Library Management System =========

1. Add Book
2. View Books
3. Update Book
4. Delete Book
5. Add Student
6. Issue Book
7. Return Book
8. Exit

=============================================
```

---

## 📖 Concepts Used

- Object-Oriented Programming (OOP)
- JDBC
- MySQL Database
- DAO Design Pattern
- DTO Design Pattern
- CRUD Operations

---

## 👨‍💻 Author

**Jeevan Prasad Palleti**

- GitHub: https://github.com/palletijeevan123
- LinkedIn: *(Add your LinkedIn profile URL here)*

---

## ⭐ If you like this project

Please consider giving this repository a ⭐ on GitHub.
