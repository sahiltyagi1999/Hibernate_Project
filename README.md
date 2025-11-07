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
