package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/listCourseForStudent/{id_student}")
    public ResponseEntity<List<Student_Course>> getListOfCoursesForStudent(@PathVariable long id_student){
        return ResponseEntity.ok(student_courseService.getCoursesForStudent(id_student) );
    }


    @PutMapping("/setGrade/{id_student_course}")
    public ResponseEntity<Student_Course> setGradeForCourse(@PathVariable long id_student_course,@RequestBody int grad ){

        Student_Course studentCourse=student_courseService.getOneStudentCourse(id_student_course);
        studentCourse.setGrade(grad);
        return ResponseEntity.ok(  student_courseService.saveStudentCourse(studentCourse) );

    }

    @PostMapping("/registerCourse/{id_student}/{id_course}")
    public ResponseEntity<Student_Course> registerCourseForStudent(@PathVariable long id_student, @PathVariable long id_course ){

        Student student= studentService.findStudentById(id_student);
        Course course=courseService.findCourseById(id_course);
       return ResponseEntity.ok( student_courseService.registerCourseToStudent(student,course));
    }


}
