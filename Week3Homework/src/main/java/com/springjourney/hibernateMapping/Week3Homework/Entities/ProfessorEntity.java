package com.springjourney.hibernateMapping.Week3Homework.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "professors")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prof_id;

    private String name;


    @OneToMany(mappedBy = "professor")
    private List<SubjectEntity> subjects;

    @ManyToMany
    @JoinTable(name = "professor_students",
            joinColumns = @JoinColumn(name = "prof_id"),
            inverseJoinColumns = @JoinColumn(name = "stud_id"))
    private Set<StudentEntity> students;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return prof_id == that.prof_id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prof_id, name);
    }
}
