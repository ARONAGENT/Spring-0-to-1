package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}
