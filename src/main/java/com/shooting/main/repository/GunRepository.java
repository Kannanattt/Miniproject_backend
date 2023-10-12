package com.shooting.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shooting.main.model.Gun;

@Repository
public interface GunRepository extends JpaRepository<Gun, Long>{

}
