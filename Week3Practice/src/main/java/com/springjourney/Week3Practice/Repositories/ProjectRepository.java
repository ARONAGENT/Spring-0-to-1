package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
}
