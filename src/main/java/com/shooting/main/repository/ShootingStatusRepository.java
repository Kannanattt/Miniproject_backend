package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.ShootingStatus;

@Repository
public interface ShootingStatusRepository extends JpaRepository<ShootingStatus, Long>{

}
