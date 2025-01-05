package com.springjourney.Week3Practice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
@Data
@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    private String title;

    @ManyToMany(mappedBy = "projectSet")
    private Set<EmployeeEntity> members;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return projectId == that.projectId && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, title);
    }
}
