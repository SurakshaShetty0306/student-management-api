package com.suraksha.studentmanagementapi.repository;

import com.suraksha.studentmanagementapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    List<Student> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM Student s WHERE s.course = :course")
    List<Student> findStudentsByCourse(@Param("course") String course);
}