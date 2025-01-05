package com.springjourney.hibernateMapping.Week3Homework.Controllers;

import com.springjourney.hibernateMapping.Week3Homework.Entities.ProfessorEntity;
import com.springjourney.hibernateMapping.Week3Homework.Services.ProfessorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorServices professorServices;

    @PostMapping("/add")
    public ProfessorEntity addProfessor(@RequestBody ProfessorEntity obj){
        return professorServices.addProfessor(obj);
    }

    @GetMapping("/all")
    public List<ProfessorEntity> allProfessors(){
        return professorServices.allProfessor();
    }

    @PutMapping("/{prof_id}/assign/{stud_id}")
    public ProfessorEntity assignProfessorToStudent(@PathVariable long prof_id, @PathVariable long stud_id){
        return professorServices.assignProfessorToStudent(prof_id,stud_id);
    }

}
