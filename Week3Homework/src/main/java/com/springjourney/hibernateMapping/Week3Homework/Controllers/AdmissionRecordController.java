package com.springjourney.hibernateMapping.Week3Homework.Controllers;

import com.springjourney.hibernateMapping.Week3Homework.Entities.AdmissionRecordEntity;
import com.springjourney.hibernateMapping.Week3Homework.Services.AdmissionRecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordServices admissionRecordServices;

    @PostMapping("/add")
    public AdmissionRecordEntity enrollAdmission(@RequestBody  AdmissionRecordEntity obj){
        return admissionRecordServices.enrollAdmission(obj);
    }

    @GetMapping("/all")
    public List<AdmissionRecordEntity> allAdmission(){
        return admissionRecordServices.allEnrollments();
    }

    @PutMapping("/{ad_id}/enroll/{stud_id}")
    public AdmissionRecordEntity assignAdmissionToStudent(@PathVariable long ad_id,@PathVariable long stud_id){
        return admissionRecordServices.assignAdmissionToStudent(ad_id,stud_id);
    }
}
