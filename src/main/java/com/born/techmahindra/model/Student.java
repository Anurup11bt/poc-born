package com.born.techmahindra.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentClass;
    private Integer marksPhysics;
    private Integer marksChemistry;
    private Integer marksMath;

    @Transient
    private Integer totalMark;

    public Integer getTotalMark() {
        return totalMark;
    }
    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }


    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
    public Integer getMarksPhysics() {
        return marksPhysics;
    }
    public void setMarksPhysics(Integer marksPhysics) {
        this.marksPhysics = marksPhysics;
    }
    public Integer getMarksChemistry() {
        return marksChemistry;
    }
    public void setMarksChemistry(Integer marksChemistry) {
        this.marksChemistry = marksChemistry;
    }
    public Integer getMarksMath() {
        return marksMath;
    }
    public void setMarksMath(Integer marksMath) {
        this.marksMath = marksMath;
    }
}
