package com.springjourney.hibernateMapping.Week3Homework.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sub_id;

    private String title;


    @ManyToOne
    @JoinColumn(name = "prof_id")
    @JsonIgnore
    private ProfessorEntity professor;

    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    private Set<StudentEntity> students;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return sub_id == that.sub_id && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sub_id, title);
    }
}
