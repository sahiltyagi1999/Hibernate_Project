<<<<<<< HEAD
# Hibernate MySQL Demo

This is a simple Java application demonstrating basic CRUD (Create, Read, Update, Delete) operations using Hibernate with a MySQL database.

## Description

The project consists of a `Student` entity with basic operations to interact with a MySQL database. The `App.java` class demonstrates how to:
- Create and save new student records.
- Retrieve and display all student records.
- Update a student's email.
- Delete a student record.

## Prerequisites

- Java 17 or higher
- Apache Maven
- MySQL Server

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/hibernate-demo.git
   cd hibernate-demo
   ```

2. **Database Setup:**
   - Make sure you have MySQL server running.
   - Create a database named `hibernate_db`.
   - Create a MySQL user `hibernate_user` with password `password123` and grant permissions to the `hibernate_db` database.
   - You can change the database connection details in `src/main/resources/hibernate.cfg.xml`.

3. **Build the project:**
   ```bash
   mvn clean install
   ```

## Usage

Run the `App.java` class to see the Hibernate operations in action. You can run it from your IDE or using Maven:

```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

The application will perform the following operations:
1. Create three new students.
2. Print all students.
3. Update the email of the student with ID 1.
4. Print all students again to show the update.
5. Delete the student with ID 2.
6. Print the final list of students.
=======
# 🐘 Hibernate CRUD Demo

A hands-on learning project for mastering **Create, Read, Update, and Delete (CRUD)** operations using **Hibernate ORM** in Java.

![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white)

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Prerequisites](#-prerequisites)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Configuration](#-configuration)
- [CRUD Operations](#-crud-operations)
- [Running Tests](#-running-tests)
- [Key Concepts](#-key-concepts)
- [Resources](#-resources)
- [Next Steps](#-next-steps)

---

## 🎯 Overview

This project is your gateway to understanding **Hibernate**, the industry-leading Object-Relational Mapping (ORM) framework for Java. Learn how to:

- Map Java objects to database tables
- Perform CRUD operations without writing SQL
- Manage transactions and sessions
- Build scalable database applications

---

## ✅ Prerequisites

- ☕ **Java 7** or higher
- 📦 **Maven 3.6+**
- 🗄️ **MySQL 5.7+** (or compatible database)
- 🧠 Basic knowledge of Java and SQL

---

## 📁 Project Structure

```
hibernate-demo/
├── src/
│   ├── main/
│   │   └── java/com/example/
│   │       └── App.java                 # Main application entry point
│   └── test/
│       └── java/com/example/
│           └── AppTest.java             # Unit tests
├── pom.xml                              # Maven configuration
└── README.md                            # This file
```

---

## 🚀 Getting Started

### 1️⃣ Clone or Navigate to Project

```bash
cd C:\Users\sahil\Desktop\hibernate-demo
```

### 2️⃣ Create Resources Directory

```bash
mkdir -p src/main/resources
```

### 3️⃣ Add Hibernate Configuration

Create `src/main/resources/hibernate.cfg.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
  "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <!-- Database Dialect -->
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    
    <!-- JDBC Connection -->
    <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_db</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">password</property>
    
    <!-- Auto Create Tables -->
    <property name="hibernate.hbm2ddl.auto">update</property>
    
    <!-- Show SQL -->
    <property name="hibernate.show_sql">true</property>
  </session-factory>
</hibernate-configuration>
```

### 4️⃣ Install Dependencies

```bash
mvn clean install
```

### 5️⃣ Build & Run

```bash
# Compile the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="com.example.App"

# Run tests
mvn test
```

---

## ⚙️ Configuration

### Database Setup

Create a MySQL database:

```sql
CREATE DATABASE hibernate_db;
USE hibernate_db;
```

### Update pom.xml

Add Hibernate and MySQL dependencies:

```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.14.Final</version>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

---

## 🔧 CRUD Operations

### ➕ CREATE (Insert)

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

User user = new User();
user.setName("John Doe");
user.setEmail("john@example.com");

session.save(user);  // or session.persist(user)
tx.commit();
session.close();
```

### 📖 READ (Retrieve)

```java
Session session = sessionFactory.openSession();

// Get by ID
User user = session.get(User.class, 1);

// Get all users using HQL
Query query = session.createQuery("FROM User");
List<User> users = query.list();

session.close();
```

### ✏️ UPDATE (Modify)

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

User user = session.get(User.class, 1);
user.setName("Jane Doe");
session.update(user);

tx.commit();
session.close();
```

### 🗑️ DELETE (Remove)

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

User user = session.get(User.class, 1);
session.delete(user);

tx.commit();
session.close();
```

---

## 🧪 Running Tests

Run all unit tests:

```bash
mvn test
```

Run a specific test:

```bash
mvn test -Dtest=AppTest
```

---

## 📚 Key Concepts

| Concept | Description |
|---------|-------------|
| 🏛️ **Entity** | Java class mapped to a database table |
| 🔑 **SessionFactory** | Factory for creating Hibernate sessions |
| 💬 **Session** | Connection to the database |
| 🔄 **Transaction** | Unit of work ensuring data consistency |
| 🏷️ **Annotations** | `@Entity`, `@Id`, `@Column`, `@Table` |
| 📝 **HQL** | Hibernate Query Language for database queries |
| ⚡ **Lazy Loading** | Load data only when accessed |
| 🔗 **Relationships** | One-to-One, One-to-Many, Many-to-Many |

### Example Entity Class

```java
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", unique = true)
    private String email;
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

---

## 📖 Resources

- 🌐 [Hibernate Official Documentation](https://hibernate.org/orm/documentation/)
- 📘 [JPA Annotations Guide](https://www.baeldung.com/jpa-annotations)
- 🔍 [HQL Query Language](https://hibernate.org/orm/documentation/latest/#query-hql)
- 💡 [Hibernate Best Practices](https://www.baeldung.com/hibernate-best-practices)

---

## 🎓 Next Steps

After mastering basic CRUD:

- [ ] 🏗️ Implement **DAO (Data Access Object)** pattern
- [ ] 🎯 Create a **Service layer** for business logic
- [ ] 🔗 Explore **One-to-Many** relationships
- [ ] 👥 Master **Many-to-Many** relationships
- [ ] 📊 Learn **Criteria API** for complex queries
- [ ] ⚙️ Understand **Lazy vs Eager** loading
- [ ] 🔒 Implement proper **Transaction management**
- [ ] 🧪 Write comprehensive **unit tests**

---

## 📝 License

MIT License - Feel free to use this project for learning!

---

## 👨‍💻 Author

**Sahil** - Learning Hibernate CRUD Operations

---

## 💬 Tips for Learning

- 💡 Start with simple entities before relationships
- 🐛 Use `hibernate.show_sql=true` to see generated SQL
- 🔍 Enable logging to understand what's happening behind the scenes
- 📖 Practice each CRUD operation thoroughly
- 🧪 Write tests for every operation
- 🚀 Build a small project (e.g., Task Manager, Blog) to reinforce concepts

Happy Learning! 🚀🎉
>>>>>>> e5079c89259aebe5f5d14700b0e97e997aff1a74
