package com.springjourney.Week3Practice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    private String deptName;

    @OneToOne
    @JoinColumn(name = "departmentManager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "deptId")
    private Set<EmployeeEntity> deptEmployees;

    @ManyToMany(mappedBy = "freelancersDepartment")
    private Set<EmployeeEntity> freelancers;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return deptId == that.deptId && Objects.equals(deptName, that.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName);
    }
}
