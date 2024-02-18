package com.student.backend_sb.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.backend_sb.Entity.Student;

public interface StudentRepo extends MongoRepository<Student, String>{

}
