package Week2Springboot.Week2Practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int empId;

    private String empNm;

    private String password;

    private String deptName;

    private float salary;

    private boolean isActive;

}
