package com.springjourney.hibernateMapping.Week3Homework.Services;

import com.springjourney.hibernateMapping.Week3Homework.Entities.ProfessorEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.SubjectEntity;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.StudentRepository;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public StudentEntity addStudent(StudentEntity obj){
        return studentRepository.save(obj);
    }

    public List<StudentEntity> allStudents(){
        return studentRepository.findAll();
    }


    public StudentEntity assignSubjectToStudents(long studId, long subId) {
        Optional<StudentEntity> studentEntity=studentRepository.findById(studId);
        Optional<SubjectEntity> subjectEntity=subjectRepository.findById(subId);

        if(studentEntity.isPresent() && subjectEntity.isPresent()){
            StudentEntity student=studentEntity.get();
            SubjectEntity subject=subjectEntity.get();
            student.getSubjects().add(subject);
            subject.getStudents().add(student);
            subjectRepository.save(subject);
            return studentRepository.save(student);
        }
        else {
            return null;
        }
    }
}
