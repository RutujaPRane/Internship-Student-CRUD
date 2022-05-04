package in.one2n.hrithik.controllers;

import in.one2n.hrithik.entities.Student;
import in.one2n.hrithik.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public List<Student> fetchAllStudents() {
        return studentService.fetchAllStudents();
    }


    @GetMapping("/students/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) {
        return studentService.fetchStudentById(studentId);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("students/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long studentId) {
        try {
            studentService.deleteStudentById(studentId);
            return ResponseEntity.ok("ID: " + studentId + " Deleted Successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("ID: " + studentId + " Not Found");
        }
    }
}
