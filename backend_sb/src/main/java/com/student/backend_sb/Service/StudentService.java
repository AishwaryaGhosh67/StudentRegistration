package com.student.backend_sb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.backend_sb.Entity.Student;
import com.student.backend_sb.Repo.StudentRepo;

@Service
public class StudentService {

@Autowired
private StudentRepo repo;

    public void saveorUpdate(Student students) {

        repo.save(students);
        
       }

    public List<Student> listAll() {
        return this.repo.findAll();
    }

    public void deleteStudent(String id) {
       repo.deleteById(id);
    }

    public Student getStudentById(String studentId) {
        return repo.findById(studentId).get();
    }

}
