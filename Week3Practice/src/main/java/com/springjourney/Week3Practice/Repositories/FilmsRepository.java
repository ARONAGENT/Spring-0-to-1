package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.Films;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmsRepository extends JpaRepository<Films,Integer> {
    List<Films> findBy(Sort sort);
}
