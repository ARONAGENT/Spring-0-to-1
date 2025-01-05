package com.springjourney.hibernateMapping.Week3Homework.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name="AdmissionRecord")
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int fees;

    @OneToOne
    @JoinColumn(name = "stud_id")
    @JsonIgnore
    private StudentEntity student;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AdmissionRecordEntity that = (AdmissionRecordEntity) o;
        return id == that.id && fees == that.fees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fees);
    }
}
