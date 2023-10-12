package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
