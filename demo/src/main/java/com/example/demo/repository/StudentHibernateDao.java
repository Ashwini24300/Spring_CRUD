package com.example.demo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class StudentHibernateDao {

    private final SessionFactory sessionFactory;

    public StudentHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student getStudentDetails(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            Student student = session.get(Student.class, id);

            // If student is not found, handle it accordingly.
            if (student == null) {
                throw new EntityNotFoundException("Student with ID " + id + " not found");
            }

            transaction.commit();

            // If student is found then return student persistent entity.
            return student;
        } catch (Exception e) {
            // Handle exceptions accordingly.
            e.printStackTrace(); // Log or rethrow as needed.
            throw new RuntimeException("Error fetching student details", e);
        }
    }
}

