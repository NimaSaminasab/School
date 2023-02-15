package com.example.school;

import jakarta.persistence.*;

@Entity
@Table
public class Student_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name= "student_id")
    Student student ;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course ;
    private  int grade ;

    public Student_Course(){}
    public Student_Course(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
