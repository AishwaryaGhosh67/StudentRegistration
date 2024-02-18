package com.student.backend_sb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.backend_sb.Entity.Student;
import com.student.backend_sb.Service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students)
    {
        studentService.saveorUpdate(students);
        return students.get_id();
    }

    @GetMapping(value = "/getAll")
    private List<Student> getStudents()
    {
        return studentService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Student updateStudents(@RequestBody Student student, @PathVariable(name="id") String _id)
    {
        student.set_id(_id);
        studentService.saveorUpdate(student);
        return student;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id)
    {
        studentService.deleteStudent(_id);
    }

    @GetMapping(value = "/search/{id}")
    private Student getStudents(@PathVariable(name = "id") String studentId)
    {
        return studentService.getStudentById(studentId);
    }


}
