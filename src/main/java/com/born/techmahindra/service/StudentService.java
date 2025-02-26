package com.born.techmahindra.service;

import com.born.techmahindra.model.Student;
import com.born.techmahindra.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(Long studentId, Student student) {
        Optional<Student> existingStudent = studentRepository.findByStudentId(studentId);
        if (existingStudent.isPresent()) {
            student.setStudentId(studentId);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }
    @Transactional
    public void deleteStudents(List<Long> studentIds) {
        for (Long studentId : studentIds) {
            Optional<Student> existingStudent = studentRepository.findByStudentId(studentId);
            if (existingStudent.isPresent()) {
                studentRepository.deleteByStudentId(studentId);
            } else {
                throw new RuntimeException("Student not found with ID: " + studentId);
            }
        }
    }
    public Student getStudentMarks(Long studentId, String studentClass) {
        Optional<Student> student = studentRepository.findByStudentId(studentId);
        if (student.isPresent() && student.get().getStudentClass().equals(studentClass)) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found or mismatched class");
        }
    }

    public Student findId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found or mismatched class");
        }
    }
}

