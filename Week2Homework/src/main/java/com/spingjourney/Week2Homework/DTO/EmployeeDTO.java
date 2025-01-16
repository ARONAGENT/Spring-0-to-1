package com.spingjourney.Week2Homework.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spingjourney.Week2Homework.annotations.passwordChecker;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    private Integer empId;

    @NotBlank(message = "empNm cannot be null")
    private String empNm;

    @passwordChecker
    private String password;

    @NotBlank(message = "deptName cannot be null")
    private String deptName;

    @Digits(integer = 6,fraction = 2,message = "The Salary is less than 6 digit")
    private float salary;

    @AssertTrue(message = "isActive field always be true")
    @JsonProperty("isActive")
    private Boolean isActive;

}
