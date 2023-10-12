package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.ShootingRange;

@Repository
public interface ShootingRangeRepository extends JpaRepository<ShootingRange, Long>{

}
