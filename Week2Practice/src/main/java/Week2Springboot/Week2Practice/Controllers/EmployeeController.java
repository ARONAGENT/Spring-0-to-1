package Week2Springboot.Week2Practice.Controllers;

import Week2Springboot.Week2Practice.Dto.EmployeeDTO;
import Week2Springboot.Week2Practice.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    //simple get request
    @GetMapping(path="/employees")
    public String mainResource(){
        return "Employees get Request Working Fine";
    }


    // get request using @PathVariable annotation
    //Use path variables when the
//    //parameter is an essential part of the URL path that identifies a resource.
//    @GetMapping(path="/employees/{empId}")
//    public EmployeeDTO getInfoById(@PathVariable int empId){
//        return new EmployeeDTO(empId,"rohan","rohan@gmail.com",20,45000,true);
//    }


    // get Request using @RequestParam Annotation == "?var=value&..."
    //Use query parameters when the parameter is optional and used for filtering, sorting, or other modifications to the request.
    @GetMapping(path="/employees/param")
    public String getInfoById2(@RequestParam(required = false,name = "id") int empId2,@RequestParam(required = false) Integer age){
        return "Your id is "+empId2+" and your age is "+age;
    }

    //Request Using @RequestBody annotation
//    // generally used for request like post ,put, delete
//    @PostMapping(path="/employees")
//    public EmployeeDTO addData(@RequestBody EmployeeDTO eDto){
//        eDto.setId(1001);
//        eDto.setAge(20);
//        eDto.setEmail("employee@123gmail.com");
//        eDto.setSalary(90876);
//        eDto.setActive(true);
//        return eDto;
//    }
//

    @Autowired
    private EmployeeServices empServ;

    @PostMapping(path="/employee/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return empServ.addEmp(employeeDTO);
    }
}
