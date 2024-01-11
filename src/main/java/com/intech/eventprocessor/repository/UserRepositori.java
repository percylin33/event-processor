package com.intech.eventprocessor.repository;

import com.intech.eventprocessor.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositori extends JpaRepository<User,Integer> {
    User findByEmail(@Param(("email")) String email);
}
