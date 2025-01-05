package com.springjourney.hibernateMapping.Week3Homework.Controllers;

import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import com.springjourney.hibernateMapping.Week3Homework.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentEntity obj){
        return studentServices.addStudent(obj);
    }

    @GetMapping("/all")
    public List<StudentEntity> allStudents(){
        return studentServices.allStudents();
    }

    @PutMapping("/{stud_id}/assign/{sub_id}")
    public StudentEntity assignSubjectToStudents(@PathVariable long stud_id,
                                                 @PathVariable long sub_id){
        return studentServices.assignSubjectToStudents(stud_id,sub_id);
    }
}
