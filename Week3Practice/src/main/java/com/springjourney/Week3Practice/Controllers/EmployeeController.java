package com.springjourney.Week3Practice.Controllers;

import com.springjourney.Week3Practice.Entities.EmployeeEntity;
import com.springjourney.Week3Practice.Entities.ProjectEntity;
import com.springjourney.Week3Practice.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices empServ;

    @PostMapping("/add")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity obj){
        return  empServ.addEmp(obj);
    }

    @GetMapping("/all")
    public List<EmployeeEntity> allEmployee(){
        return empServ.allEmp();
    }


}
