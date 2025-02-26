package com.born.techmahindra.controller;

import com.born.techmahindra.model.ErrorResponse;
import com.born.techmahindra.model.Response;
import com.born.techmahindra.model.Student;
import com.born.techmahindra.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/born/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        try {
            Student createdStudent = studentService.createStudent(student);
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(createErrorResponse(e),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Long studentId,
                                                @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(studentId, student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(createErrorResponse(e), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<Object> deleteStudents(@RequestBody List<Long> studentIds) {
        try {
            studentService.deleteStudents(studentIds);
            return new ResponseEntity<>("Students deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(createErrorResponse(e), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/total-marks")
    public ResponseEntity<Object> getTotalMarks(@RequestHeader("student-id") Long studentId,
                                                @RequestHeader("student-class") String studentClass) {
        try {
            Student student = studentService.findId(studentId);
            int totalMarks=student.getMarksChemistry()+student.getMarksMath()+student.getMarksPhysics();
            student.setTotalMark(totalMarks);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return new ResponseEntity<>(createErrorResponse(e), HttpStatus.NOT_FOUND);
        }
    }

    private ErrorResponse createErrorResponse(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setSuccess(false);
        errorResponse.setErrorMessage(e.getMessage());
        return errorResponse;
    }



}

