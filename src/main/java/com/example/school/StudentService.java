package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository ;


    public List<Student> studentList(){
      return studentRepository.findAll();
    }

    public Student findStudentById(Long id){

        Student student = studentRepository.findById(id).orElse(null);
       return student ;
    }

    public Student insertStudent(Student student){
       return studentRepository.save(student) ;
    }
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
    public void updateStudent(long id, Student student){
        studentRepository.delete(student);
    }
}
