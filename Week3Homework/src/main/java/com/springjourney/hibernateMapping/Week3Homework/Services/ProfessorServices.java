package com.springjourney.hibernateMapping.Week3Homework.Services;

import com.springjourney.hibernateMapping.Week3Homework.Entities.ProfessorEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.ProfessorRepository;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServices {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ProfessorEntity addProfessor(ProfessorEntity obj){
        return professorRepository.save(obj);
    }

    public List<ProfessorEntity> allProfessor(){
        return professorRepository.findAll();
    }


    public ProfessorEntity assignProfessorToStudent(long profId, long studId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(profId);
        Optional<StudentEntity> studentEntity=studentRepository.findById(studId);

        if(professorEntity.isPresent() && studentEntity.isPresent()){
             ProfessorEntity professor=professorEntity.get();
             StudentEntity student=studentEntity.get();
             student.getProfessors().add(professor);
             professor.getStudents().add(student);
             studentRepository.save(student);
             return professorRepository.save(professor);
        }
        else {
            return null;
        }
    }
}
