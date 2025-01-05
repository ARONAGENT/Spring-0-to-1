package com.springjourney.Week3Practice.Services;

import com.springjourney.Week3Practice.Entities.DepartmentEntity;
import com.springjourney.Week3Practice.Entities.EmployeeEntity;
import com.springjourney.Week3Practice.Entities.ProjectEntity;
import com.springjourney.Week3Practice.Repositories.EmployeeRepository;
import com.springjourney.Week3Practice.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private ProjectRepository projectRepository;

    public EmployeeEntity addEmp(EmployeeEntity obj){
        return empRepo.save(obj);
    }

    public List<EmployeeEntity> allEmp(){
        return empRepo.findAll();
    }


}

