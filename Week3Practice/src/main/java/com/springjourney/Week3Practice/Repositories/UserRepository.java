package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String username);

    List<User> findByRegisterAtAfter(LocalDate registerAt);
    List<User> findByRegisterAtBefore(LocalDate registerAt);

    List<User> findByUserNameAndLocation(String userName, String location);
    List<User> findByUserNameOrIsActive(String userName, boolean isActive);

    List<User> findByIsActiveFalse();
    List<User> findByIsActiveTrue();

    List<User> findByUserIdIn(List<Integer> userId);
    List<User> findByUserIdNotIn(List<Integer> ids);

    List<User> findByLocationEquals(String location);

    List<User> findByLocationIsNull();
    List<User> findByLocationIsNotNull();

    List<User> findByUserNameAllIgnoreCase(String userName);

//    List<User> findDistinctByLocation();
}
