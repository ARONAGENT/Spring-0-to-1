package com.springjourney.Week4Practice.Clients;

import com.springjourney.Week4Practice.Dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO deleteEmployee(int empId);
    EmployeeDTO updateEmployee(int empId, EmployeeDTO employeeDTO);
}
