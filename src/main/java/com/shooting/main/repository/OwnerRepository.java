package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
