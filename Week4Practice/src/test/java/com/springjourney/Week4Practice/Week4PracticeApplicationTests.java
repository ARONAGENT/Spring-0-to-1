package com.springjourney.Week4Practice;

import com.springjourney.Week4Practice.Clients.EmployeeClient;
import com.springjourney.Week4Practice.Dtos.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class Week4PracticeApplicationTests {
	@Autowired
	private EmployeeClient employeeClient;
	@Test
	void getAllEmployee(){
		List<EmployeeDTO> employeeDTOList=employeeClient.getAllEmployees();
		for (EmployeeDTO empList : employeeDTOList) {
			System.out.println(empList);
		}
	}

	@Test
	void addEmployee(){
		EmployeeDTO employeeDTO=
				new EmployeeDTO
						(null,
								"Tony Stark"
								,"Tony3000@gmail.com"
								,"Nuclear Power"
								,123456
								,true
						);
		employeeClient.addEmployee(employeeDTO);
		System.out.println(employeeDTO);
	}
	@Test
	void deleteEmployee(){
		EmployeeDTO employeeDTO=
				employeeClient.deleteEmployee(1102);
		System.out.println(employeeDTO);
	}

	@Test void updateEmployee() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpNm("Muke saheb");
		employeeDTO.setDeptName("Maths");
		employeeDTO.setSalary(82678);
		employeeDTO.setPassword("Mon@123678");
		employeeDTO.setIsActive(true);
		EmployeeDTO updatedEmployee =
				employeeClient.updateEmployee
						(854, employeeDTO);
		System.out.println(updatedEmployee);
	}
}
