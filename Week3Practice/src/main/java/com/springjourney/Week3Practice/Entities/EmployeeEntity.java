package com.springjourney.Week3Practice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne
    @JoinColumn(name = "depId",referencedColumnName = "deptId")
    @JsonIgnore
    private DepartmentEntity deptId;

    @ManyToMany
    @JoinTable(name = "Freelancers"
            ,joinColumns = @JoinColumn(name = "deptId")
            ,inverseJoinColumns =@JoinColumn(name = "EmpId_of_freelancer"))
    @JsonIgnore
    private Set<DepartmentEntity> freelancersDepartment;

    @ManyToMany
    @JoinTable(name="employee_projects",
                joinColumns = @JoinColumn(name = "empId"),
                inverseJoinColumns = @JoinColumn(name ="projectId"))
    @JsonIgnore
    private Set<ProjectEntity> projectSet;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return empId == that.empId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }
}
