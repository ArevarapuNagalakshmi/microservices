package com.Students.student.Repository;

import com.Students.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepo extends JpaRepository<Student,Long> {
    Student findBystudentId(Long studentId);

}
