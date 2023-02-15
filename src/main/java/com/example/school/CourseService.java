package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository ;



    public Course createCourse(Course course){
        return courseRepository.save(course) ;
    }
    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }
    public List<Course> listOfAllCourses(){
        return (List<Course>) courseRepository.findAll();
    }
    public Course findCourseById(Long id){
      return courseRepository.findById(id).orElse(null) ;

    }
}
