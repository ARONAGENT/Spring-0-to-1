package Week2Springboot.Week2Practice.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String empNm;

    private String password;

    private String deptName;

    private float salary;

    private boolean isActive;

}
