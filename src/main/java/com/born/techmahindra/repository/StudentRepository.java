package com.born.techmahindra.repository;

import com.born.techmahindra.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentId(Long studentId);
    void deleteByStudentId(Long studentId);
}

