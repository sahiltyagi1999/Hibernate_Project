package com.example;

// Hibernate imports for DB operations
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Hibernate MySQL Demo ===\n"); // Prints heading in console

        // Creating 3 student records in DB
        createStudent("John", "Doe", "john@example.com");
        createStudent("Jane", "Smith", "jane@example.com");
        createStudent("Mike", "Johnson", "mike@example.com");

        System.out.println("\n=== All Students ===");
        getAllStudents(); // Fetch and print all students

        updateStudent(1, "john.doe@newemail.com"); // Update email of student with id=1

        System.out.println("\n=== After Update ===");
        getAllStudents(); // Print again after update

        deleteStudent(2); // Delete student whose id = 2

        System.out.println("\n=== After Delete ===");
        getAllStudents(); // Print final student list

        HibernateUtil.shutdown(); // Close Hibernate session factory
        System.out.println("\n=== Done ===");
    }

    // ================== CREATE FUNCTION ==================
    public static void createStudent(String firstName, String lastName, String email) {
        Transaction transaction = null; // Used to commit or rollback DB changes

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction(); // Start DB transaction

            Student student = new Student(firstName, lastName, email); // Create student object
            session.persist(student); // Save object into database

            transaction.commit(); // Make changes permanent in DB
            System.out.println("Created: " + student); // Print student details
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Undo if error happens
            System.out.println("Error while creating student!");
        }
    }

    // =================== READ FUNCTION ===================
    public static void getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("FROM Student", Student.class).list();
            students.forEach(System.out::println); // Print each student using toString()
        } catch (Exception e) {
            System.out.println("Error fetching students!");
        }
    }

    // ================== UPDATE FUNCTION ==================
    public static void updateStudent(int id, String newEmail) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, id); // Fetch student from DB using ID
            if (student != null) {
                student.setEmail(newEmail); // Update email
                session.merge(student); // Save updated object in DB
                System.out.println("Updated student ID " + id + " email to: " + newEmail);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating student!");
        }
    }

    // ================== DELETE FUNCTION ==================
    public static void deleteStudent(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, id); // Fetch student
            if (student != null) {
                session.remove(student); // Delete student from DB
                System.out.println("Deleted: " + student);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting student!");
        }
    }
}
