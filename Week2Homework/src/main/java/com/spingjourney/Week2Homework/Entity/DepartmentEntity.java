package com.spingjourney.Week2Homework.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    private int deptId;

    private String title;

    private boolean isActive;

    private Date createdAt;



}
