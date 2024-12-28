package com.spingjourney.Week2Homework.Repositories;

import com.spingjourney.Week2Homework.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
