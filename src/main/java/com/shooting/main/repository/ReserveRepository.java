package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long>{

}
