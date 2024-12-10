package com.studentmanagementsystem.student_management_system.controller;

import com.studentmanagementsystem.student_management_system.entity.Course;
import com.studentmanagementsystem.student_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//http://localhost:9292/course/deledById
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }
    @GetMapping("/getAllCourse")
    public List<Course> findAllCourse() {
        return  courseService.getAllCourse();
    }
    @GetMapping("/getById/{id}")
    public Optional<Course> findCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }
@GetMapping("/getByName/{name}")
    public Optional<Course> findCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }
    @DeleteMapping("/deledById/{id}")
    public String deleteById(@PathVariable int id) {
       courseService.deleteById(id);
        return "Course Deleted";
    }
    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course)
    {
        return courseService.updateCourse(course);
    }
}
