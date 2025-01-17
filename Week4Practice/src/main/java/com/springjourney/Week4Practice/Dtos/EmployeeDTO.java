package com.springjourney.Week4Practice.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {


    private Integer empId;


    private String empNm;


    private String password;


    private String deptName;


    private float salary;

    @JsonProperty("isActive")
    private Boolean isActive;

}
