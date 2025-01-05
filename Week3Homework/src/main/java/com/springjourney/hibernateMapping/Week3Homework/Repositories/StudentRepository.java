package com.springjourney.hibernateMapping.Week3Homework.Repositories;

import com.springjourney.hibernateMapping.Week3Homework.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
