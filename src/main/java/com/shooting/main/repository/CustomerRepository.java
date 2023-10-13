package com.shooting.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("SELECT c FROM Customer c WHERE c.user.u_id = :userId")
    Customer findByUserId(@Param("userId") Long userId);
}
