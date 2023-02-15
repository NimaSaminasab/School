package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Student_CourseController {

    @Autowired
    Student_CourseService student_courseService ;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping("/student_Course/{id}")
    public ResponseEntity<List<Course>> getListOfCoursesForStudent(@PathVariable long id){
        return ResponseEntity.ok(student_courseService.getCoursesForStudent(id) );
    }
    @PostMapping("/registerCourse")
    public ResponseEntity<Student_Course> registerCourseForStudent(@RequestBody Student_Course studentCourse ){
//        System.out.println(student_id);
//        Student student= studentService.findStudentById(student_id);
//        Course course=courseService.findCourseById(course_Id);
//        Student_Course studentCourse=new Student_Course(student, course);
       return ResponseEntity.ok( student_courseService.registerCourseToStudent(studentCourse) );
    }
}
