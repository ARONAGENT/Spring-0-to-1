package com.spingjourney.Week2Homework.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private int deptId;

    private String title;

    private boolean isActive;

    private Date createdAt;

}
