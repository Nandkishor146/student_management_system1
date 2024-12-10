package com.studentmanagementsystem.student_management_system.controller;

import com.studentmanagementsystem.student_management_system.entity.Enrollment;
import com.studentmanagementsystem.student_management_system.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//http://localhost:9292/enroll/enrollStudent
@RestController
@RequestMapping("/enroll")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @PostMapping("/enrollStudent")
    public Enrollment enrollStudent(@RequestBody Enrollment enrollmentRequest) {
        return enrollmentService.enrollStudent(
                enrollmentRequest.getStudent().getStudentId(),
                enrollmentRequest.getCourse().getCourseId());
    }
    @GetMapping("/getAllEnrolled")
    public List<Enrollment> findAllEnrollments()
    {
        return enrollmentService.getAllEnrollments();
    }
  /*  @GetMapping("/findByStudentId/{studentId}")
    public List<Enrollment> findEnrollmentsByStudentId(@PathVariable int studentId)
    {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }
@GetMapping("/findByCourseId/{courseId}")
public List<Enrollment> findEnrollmentsByCourseId(@PathVariable int courseId)
    {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }*/
@DeleteMapping("/deleteById/{id}")
public String deleteEnrollment(@PathVariable int id)
    {
        return enrollmentService.deleteEnrollment(id);
    }
    @GetMapping("/findById/{id}")
    public Optional<Enrollment> getById(@PathVariable int id)
    {
        return enrollmentService.getById(id);
    }
}
