package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_CourseService {
    @Autowired
    private Student_CourseRepository student_courseRepository ;

    public Student_Course getOneStudentCourse(long studentCourseId){
        return student_courseRepository.findById(studentCourseId).orElse(null);
    }

    public Student_Course saveStudentCourse(Student_Course studentCourse){
        return student_courseRepository.save(studentCourse) ;
    }
    public List<Course> getCoursesForStudent(long studentId){
        return student_courseRepository.getCoursesForStudent(studentId) ;
    }

    public Student_Course registerCourseToStudent(Student student, Course course){
       return student_courseRepository.save(new Student_Course(student,course));
    }
}
