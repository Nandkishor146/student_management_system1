package com.studentmanagementsystem.student_management_system.controller;

import com.studentmanagementsystem.student_management_system.entity.Student;
import com.studentmanagementsystem.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
@PostMapping("/addStudent")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping("/getAllStudents")
     public List<Student> findAllStudent()
    {
        return studentService.getAllStudent();
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> findStudentById(@PathVariable int id)
    {
        return studentService.getStudentById(id);
    }
    @GetMapping("/getByName/{name}")
    public Optional<Student> findStudentByName(@PathVariable String name)
    {
        return studentService.getStudentByName(name);
    }
    @DeleteMapping("deleteById/{id}")
    public String deleteStudentById(@PathVariable int id)
    {
       studentService.deleteStudentById(id);
        return "Student Deleted";
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

}
