package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService ;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getListOfStudents(){
       return ResponseEntity.ok( studentService.studentList());
    }
    @PostMapping("/createStudent")
    @ResponseBody
    public ResponseEntity<?> createStudent(@RequestBody Student student){
      //  Student student = new Student(name,telefon,adress) ;
       if( student.getName().equals("") || student.getTelefon()==0 || student.getAdress().equals("")){
           return ResponseEntity.ok("The fields is required!");
       }

        return ResponseEntity.ok(studentService.insertStudent(student));
    }

    @DeleteMapping("/deleteStudentById/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        Student student = studentService.findStudentById(id).get();
        if(student!=null){
            studentService.deleteStudent(student);
            return ResponseEntity.ok("success to delete");
        }
        return ResponseEntity.ok("Not Found "+ id);
    }


    @PutMapping("/editStudentById/{id}")
    @ResponseBody
    public ResponseEntity<?> editStudentById(@PathVariable Long id,@RequestBody Student editStudent){
        Student student = studentService.findStudentById(id).get();
        if(student!=null){
            student.setName(editStudent.getName()) ;
            student.setTelefon(editStudent.getTelefon()); ;
            student.setAdress(editStudent.getAdress()); ;

            studentService.insertStudent(student);
            return ResponseEntity.ok("success to edit");
        }
        return ResponseEntity.ok("Not Found "+ id);
    }

    @GetMapping("/findStudentById/{id}")
    @ResponseBody
    public  ResponseEntity<?> findStudentById(@PathVariable Long id){
        Student student = studentService.findStudentById(id).orElseThrow();

        if(studentService.findStudentById(id)!=null){
            return ResponseEntity.ok(student);
        }else {
            return ResponseEntity.ok("Not Found " + id);
        }
    }


}
