package com.springjourney.Week4Practice.Clients.Impl;

import com.springjourney.Week4Practice.Clients.EmployeeClient;
import com.springjourney.Week4Practice.Dtos.EmployeeDTO;
import com.springjourney.Week4Practice.advices.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientApi implements EmployeeClient {

    Logger log = LoggerFactory.getLogger(EmployeeClientApi.class);

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            log.info("Attempting method getAllEmployees");
            ApiResponse<List<EmployeeDTO>> employeeDtoList = restClient.get()
                    .uri("employees/all")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.info("Successfully get all Employees");
            return employeeDtoList.getData();
        } catch (Exception e) {
            log.error("Error occurred in getAllEmployees");
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        try {
            log.info("Attempting method addEmployee");
            ApiResponse<EmployeeDTO> addEmp = restClient.post()
                    .uri("employees/add")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("debugging");
            return addEmp.getData();
        } catch (Exception e) {
            log.error("Error occurred in addEmployee");
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO deleteEmployee(int empId) {
        try {
            log.info("Attempting method deleteEmployee");
            ApiResponse<EmployeeDTO> response = restClient.delete()
                    .uri("employees/delete/{empId}", empId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                    })
                    .body(new ParameterizedTypeReference<>() {});
            log.info("Successfully Delete Employee with id : {} ",empId);
            return response.getData();
        } catch (Exception e) {
            log.error("Error occurred in deleteEmployee");
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO updateEmployee(int empId, EmployeeDTO employeeDTO) {
        try {
            log.info("Attempting method updateEmployee");
            ApiResponse<EmployeeDTO> updatedEmp = restClient.put()
                    .uri("employees/update/{empId}", empId)
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                    })
                    .body(new ParameterizedTypeReference<>() {}) ;
            log.info("Successfully update Employee with id : {} ",empId);
            return updatedEmp.getData();
        } catch (Exception e) {
            log.error("Error occurred in updateEmployee");
            throw new RuntimeException(e);
        }
    }
}
