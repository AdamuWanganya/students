package com.adamustudents.repository;

import com.adamustudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //create a method to return name coz it doesn't exist in repository
    public Student findByStudentName(String studentName);
    public Student findByStudentNameIgnoreCase(String studentNameIgnoreCase);
}
