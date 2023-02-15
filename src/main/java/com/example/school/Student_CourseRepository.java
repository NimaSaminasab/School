package com.example.school;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_CourseRepository extends CrudRepository<Student_Course,Long>{
    public List<Course> getStudent_CoursesByStudent_Id(long id) ;
}
