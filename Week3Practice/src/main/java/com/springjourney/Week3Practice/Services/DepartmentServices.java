package com.springjourney.Week3Practice.Services;

import com.springjourney.Week3Practice.Entities.DepartmentEntity;
import com.springjourney.Week3Practice.Entities.EmployeeEntity;
import com.springjourney.Week3Practice.Repositories.DepartmentRepository;
import com.springjourney.Week3Practice.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private EmployeeRepository empRepo;

    public DepartmentEntity addDept(DepartmentEntity obj){
        return deptRepo.save(obj);
    }

    public List<DepartmentEntity> allDepartment(){
        return deptRepo.findAll();
    }

    public DepartmentEntity addManagedDepartment(int deptId, int empId) {
        Optional<DepartmentEntity> departmentEntity=deptRepo.findById(deptId);
        Optional<EmployeeEntity> employeeEntity=empRepo.findById(empId);
        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
            department.setManager(employee);
            return deptRepo.save(department);
        })).orElse(null);
    }


//    public DepartmentEntity addManagedDept(int deptId, int empId) {
//        Optional<DepartmentEntity> departmentEntity = deptRepo.findById(deptId);
//        Optional<EmployeeEntity> employeeEntity = empRepo.findById(empId);
//        if (departmentEntity.isPresent() && employeeEntity.isPresent())
//        {
//        DepartmentEntity department = departmentEntity.get();
//        EmployeeEntity employee = employeeEntity.get();
//        department.setManager(employee);
//        return deptRepo.save(department);
//        }
//    else {
//        return null;
//     }
//    }
      public DepartmentEntity addDepartmentEmployee(int deptId, int empId) {
          Optional<DepartmentEntity> departmentEntity=deptRepo.findById(deptId);
          Optional<EmployeeEntity> employeeEntity=empRepo.findById(empId);
          return departmentEntity.flatMap(department ->
                  employeeEntity.map(employee -> {
                    employee.setDeptId(department);
                    empRepo.save(employee);
                    department.getDeptEmployees().add(employee);
                    return department;
                  })).orElse(null);
      }

    public DepartmentEntity addDepartmentFreelancer(int deptId, int empId) {

        Optional<DepartmentEntity> departmentEntity=deptRepo.findById(deptId);
        Optional<EmployeeEntity> employeeEntity=empRepo.findById(empId);
        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                  employee.getFreelancersDepartment().add(department);
                  empRepo.save(employee);
                   department.getFreelancers().add(employee);
                    return department;
                })).orElse(null);
    }
//
//    public DepartmentEntity addDepartmentEmployee(int deptId, int empId) {
//        DepartmentEntity department = deptRepo.findById(deptId).orElse(null);
//        EmployeeEntity employee = empRepo.findById(empId).orElse(null);
//
//        if (department != null && employee != null) {
//            employee.setDeptId(department);
//            empRepo.save(employee);
//            department.getDeptEmployees().add(employee);
//            return department;
//        }
//        return null;
//    }



}
