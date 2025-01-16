package com.spingjourney.Week2Homework.Controllers;

import com.spingjourney.Week2Homework.DTO.EmployeeDTO;
import com.spingjourney.Week2Homework.Services.EmployeeServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeServices empServ;
    public EmployeeController(EmployeeServices empServ) {
        this.empServ = empServ;
    }

    @GetMapping(path="/info")
    public String firstEmp(){
        return "Rest Api Working Successfully";
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EmployeeDTO>> allEmployee(){
        return ResponseEntity.ok(empServ.allEmployee());
    }
    @PostMapping(path="/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1=empServ.addEmp(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable int empId, @RequestBody @Valid EmployeeDTO employeeDTO){
        return ResponseEntity.ok(empServ.updateEmp(empId,employeeDTO));
    }

    @DeleteMapping(path = "/delete/{empId}")
    public ResponseEntity<EmployeeDTO> deleteByEmployeeID(@PathVariable int empId) {
        return empServ.deleteEmployee(empId);
    }

}
