package com.springjourney.hibernateMapping.Week3Homework.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stud_id;

    private String name;

    @OneToOne(mappedBy = "student")
    private AdmissionRecordEntity admissionRecord;


    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ProfessorEntity> professors;


    @ManyToMany
    @JoinTable(name = "students_and_subjects",
            joinColumns = @JoinColumn(name = "stud_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_id"))
    private Set<SubjectEntity> subjects;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return stud_id == that.stud_id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stud_id, name);
    }
}
