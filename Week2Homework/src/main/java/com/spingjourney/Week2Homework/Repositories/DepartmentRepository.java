package com.spingjourney.Week2Homework.Repositories;

import com.spingjourney.Week2Homework.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}
