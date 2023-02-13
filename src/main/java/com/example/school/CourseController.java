package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService ;


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> listOfAllCourses(){
        return ResponseEntity.ok(courseService.listOfAllCourses()) ;
    }
    @PostMapping("/createCourse")
    @ResponseBody
    public ResponseEntity<?> createCourse(@RequestBody Course course){
         if(course.name.equals("") || course.point == 0){
             return ResponseEntity.ok("The fields are required") ;
         }
         return ResponseEntity.ok(courseService.createCourse(course)) ;
    }

    @DeleteMapping("/deleteCourseById/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteCourse(@PathVariable long id){
        Course course = courseService.findCourseById(id) ;
        if(course!=null)
        {
           courseService.deleteCourse(course) ;
           return ResponseEntity.ok(course.getName() + " deleted") ;
        }
        return ResponseEntity.ok(id + " Not Found") ;
    }

    @PutMapping("/editCourseById/{id}")
    @ResponseBody
    public ResponseEntity<?> editCourseById(@PathVariable long id,@RequestBody Course course){
        Course course1 = courseService.findCourseById(id) ;
        if(course1!=null) {
            course.setName(course1.getName());
            course.setPoint(course1.getPoint());
            courseService.createCourse(course) ;
            return ResponseEntity.ok(course + "is updated ") ;
        }
        return ResponseEntity.ok(id + "Not Found ");
    }

    @GetMapping("findCourseById/{id}")
    @ResponseBody
    public ResponseEntity<?> findCourseById(@PathVariable long id){
        Course course = courseService.findCourseById(id) ;
        if(course!=null){
            return ResponseEntity.ok(course) ;
        }
        return ResponseEntity.ok(id + " Not found") ;
    }

}
