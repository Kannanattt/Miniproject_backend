package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	@Query("SELECT o FROM Owner o WHERE o.user.u_id = :userId")
    Owner findByUserId(@Param("userId") Long userId);
}
