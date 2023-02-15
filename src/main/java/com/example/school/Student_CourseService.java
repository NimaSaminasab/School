package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_CourseService {
    @Autowired
    private Student_CourseRepository student_courseRepository ;

    public List<Course> getCoursesForStudent(long studentId){
        return student_courseRepository.getStudent_CoursesByStudent_Id(studentId) ;
    }

    public Student_Course registerCourseToStudent(Student_Course studentCourse){
       return student_courseRepository.save(studentCourse);
    }
}
