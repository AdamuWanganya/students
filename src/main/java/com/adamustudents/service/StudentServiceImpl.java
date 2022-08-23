package com.adamustudents.service;

import com.adamustudents.entity.Student;
import com.adamustudents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student fetchStudentByName(String studentName) {
        return studentRepository.findByStudentNameIgnoreCase(studentName);
    }

    @Override
    public String deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student successfully deleted!!!";
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {
        Student studentDB = studentRepository.findById(studentId).get();

        if (Objects.nonNull(student.getStudentName())&&
        !"".equalsIgnoreCase(student.getStudentName())){
            studentDB.setStudentName(student.getStudentName());
        }
        if (Objects.nonNull(student.getStudentEmail())&&
        !"".equalsIgnoreCase(student.getStudentEmail())){
            studentDB.setStudentEmail(student.getStudentEmail());
        }
        if (Objects.nonNull(student.getStudentCourse())&&
        !"".equalsIgnoreCase(student.getStudentCourse())){
            studentDB.setStudentCourse(student.getStudentCourse());
        }
        return studentRepository.save(studentDB);
    }


}
