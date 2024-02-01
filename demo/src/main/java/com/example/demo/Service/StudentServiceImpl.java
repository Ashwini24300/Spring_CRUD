package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentHibernateDao;
import com.example.demo.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentHibernateDao studentHibernateDao;

    //1.GET/SELECT

    // you can use Hibernate code to show that you know Hibernate : create the DAO class for performing operations.
    public Student getStudentDetails(Long id) throws EntityNotFoundException {
        return studentHibernateDao.getStudentDetails(id);
    }

    //2.POST/INSERT
    // use JDBC code here to show that you know JDBC also
    public String registerStudentDetails(Student student){
        studentRepository.save(student);

        // Write JDBC code here.

        return "Student with id"+ student.getStudentId()+ " is added successfully !";
    }

    //3.PUT/UPDATE
    public String updateStudentDetails(Student student){
        studentRepository.save(student);
        return "Student Details with id"+ student.getStudentId()+ " is updated successfully !";
    }

    //4.DELETE
    public String deleteStudentEntry(Long studentId){
        studentRepository.deleteById(studentId);
        return "Student with id"+ studentId + " is removed successfully !";
    }
    
}
