package com.adamustudents.Controller;

import com.adamustudents.entity.Student;
import com.adamustudents.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //getting/connecting from spring boot
    @Autowired
    private StudentService studentService;

    //method for posting students
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){return studentService.saveStudent(student);}

    //method to get students
    @GetMapping("/students")
    public List<Student> fetchStudentList(){return studentService.fetchStudentList();}

    //method to get studentById
    @GetMapping("/students/{Id}")
    public Student fetchStudentById(@PathVariable ("Id") Long studentId){return studentService.fetchStudentById(studentId);}

    //method to get studentByName
    @GetMapping("/students/name/{name}")
    public Student fetchStudentByName(@PathVariable ("name") String studentName){return studentService.fetchStudentByName(studentName);}

    //method to delete studentById
    @DeleteMapping("/students/{Id}")
    public String deleteStudentById(@PathVariable ("Id") Long studentId){return studentService.deleteStudentById(studentId);}

    //method to update StudentById
    @PutMapping("/students/{Id}")
    public Student updateStudentById(@PathVariable ("Id") Long studentId,@RequestBody Student student){return studentService.updateStudentById(studentId,student);}
}
