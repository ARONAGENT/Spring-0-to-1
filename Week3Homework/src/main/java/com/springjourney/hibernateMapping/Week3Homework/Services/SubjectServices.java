package com.springjourney.hibernateMapping.Week3Homework.Services;

import com.springjourney.hibernateMapping.Week3Homework.Entities.ProfessorEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.SubjectEntity;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.ProfessorRepository;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServices {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public SubjectEntity addSubject(SubjectEntity obj){
        return subjectRepository.save(obj);
    }

    public List<SubjectEntity> allSubjects(){
        return subjectRepository.findAll();
    }

    public SubjectEntity assignSubjectToProfessor(long profId, long subId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(profId);
        Optional<SubjectEntity> subjectEntity=subjectRepository.findById(subId);
        if(professorEntity.isPresent() && subjectEntity.isPresent()){
            ProfessorEntity professorEntity1=professorEntity.get();
            SubjectEntity subjectEntity1=subjectEntity.get();

            subjectEntity1.setProfessor(professorEntity1);
            return subjectRepository.save(subjectEntity1);
        }
        else {
            return null;
        }
    }
}
