package com.springjourney.hibernateMapping.Week3Homework.Controllers;

import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.SubjectEntity;
import com.springjourney.hibernateMapping.Week3Homework.Services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectServices subjectServices;

    @PostMapping("/add")
    public SubjectEntity addSubject(@RequestBody SubjectEntity obj){
        return subjectServices.addSubject(obj);
    }

    @GetMapping("/all")
    public List<SubjectEntity> allSubject(){
        return subjectServices.allSubjects();
    }
    @PutMapping("{prof_id}/assign/{sub_id}")
    public SubjectEntity assignSubjectToProfessor(@PathVariable long prof_id,
                                                  @PathVariable long sub_id){
        return subjectServices.assignSubjectToProfessor(prof_id,sub_id);

    }
}
