package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    private CourseService courseService ;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseBody listOfAllCourses(){
        return (ResponseBody) courseService.listOfAllCourses();
    }
    @PostMapping("/createCourse/{name}/{point}")
    @ResponseBody
    public void createCourse(@PathVariable String name,@PathVariable int point){
        Course course = new Course(name,point) ;
        courseService.createCourse(course);
    }

//    @GetMapping("/deleteCourse")
//    @ResponseBody
//    public void deleteCourse(@PathVariable long id){
//        Course course = courseService.(id) ;
//        if(course!= null)
//            courseService.deleteCourse(course);
//    }

}
