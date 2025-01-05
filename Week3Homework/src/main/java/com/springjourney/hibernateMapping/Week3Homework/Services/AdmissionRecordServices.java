package com.springjourney.hibernateMapping.Week3Homework.Services;

import com.springjourney.hibernateMapping.Week3Homework.Entities.AdmissionRecordEntity;
import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.AdmissionRecordRepository;
import com.springjourney.hibernateMapping.Week3Homework.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordServices {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;

    @Autowired
    private StudentRepository studentRepository;
    public AdmissionRecordEntity enrollAdmission(AdmissionRecordEntity obj){
       return admissionRecordRepository.save(obj);
    }

    public List<AdmissionRecordEntity>  allEnrollments(){
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecordEntity assignAdmissionToStudent(long adId, long studId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity=admissionRecordRepository.findById(adId);
        Optional<StudentEntity> studentEntity=studentRepository.findById(studId);

        if(admissionRecordEntity.isPresent() && studentEntity.isPresent()){
            AdmissionRecordEntity admissionRecordEntity1=admissionRecordEntity.get();
            StudentEntity studentEntity1=studentEntity.get();

            admissionRecordEntity1.setStudent(studentEntity1);
            return admissionRecordRepository.save(admissionRecordEntity1);
        }
        else {
            return null;
        }
    }
}
