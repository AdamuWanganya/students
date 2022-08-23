package com.adamustudents.service;

import com.adamustudents.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> fetchStudentList();

    Student fetchStudentById(Long studentId);

    Student fetchStudentByName(String studentName);

    String deleteStudentById(Long studentId);


    Student updateStudentById(Long studentId, Student student);
}
