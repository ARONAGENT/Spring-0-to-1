package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}
