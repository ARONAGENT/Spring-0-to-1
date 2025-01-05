package com.springjourney.Week3Practice.Controllers;

import com.springjourney.Week3Practice.Entities.DepartmentEntity;
import com.springjourney.Week3Practice.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServices deptServ;

    @PostMapping("/add")
    public DepartmentEntity addDepartment(@RequestBody DepartmentEntity obj){
      return  deptServ.addDept(obj);
    }

    @GetMapping("/all")
    public List<DepartmentEntity> allDepartment(){
        return deptServ.allDepartment();
    }

    @PutMapping("/{deptId}/manage/{empId}")
    public DepartmentEntity addManagedDepartment(@PathVariable int empId,
                                                 @PathVariable int deptId){
        return deptServ.addManagedDepartment(deptId,empId);
    }

    @PutMapping("/{deptId}/assign/{empId}")
    public DepartmentEntity addDepartmentEmp(@PathVariable int deptId,@PathVariable int empId){
        return deptServ.addDepartmentEmployee(deptId,empId);
    }

    @PutMapping("/{deptId}/freelancer/{empId}")
    public DepartmentEntity addDepartmentFreelancer(@PathVariable int deptId,@PathVariable int empId){
        return deptServ.addDepartmentFreelancer(deptId,empId);
    }


}
