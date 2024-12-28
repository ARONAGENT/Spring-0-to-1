package Week2Springboot.Week2Practice.Services;

import Week2Springboot.Week2Practice.Dto.EmployeeDTO;
import Week2Springboot.Week2Practice.Entities.EmployeeEntity;
import Week2Springboot.Week2Practice.Repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    public EmployeeDTO addEmp(EmployeeDTO employeeDTO) {
        EmployeeEntity obj=modelMapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity employeeEntity=employeeRepository.save(obj);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }
}
