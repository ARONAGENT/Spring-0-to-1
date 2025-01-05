package com.springjourney.hibernateMapping.Week3Homework.Repositories;

import com.springjourney.hibernateMapping.Week3Homework.Entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
