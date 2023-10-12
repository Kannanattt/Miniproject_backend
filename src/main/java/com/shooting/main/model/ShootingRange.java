package com.shooting.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ShootingRange")
public class ShootingRange {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long s_id;

	private String s_name;

	@ManyToOne
	@JoinColumn(name = "status")
	private ShootingStatus shootingStatus;

	public ShootingRange() {
		super();
	}

	public ShootingRange(Long s_id, String s_name, ShootingStatus shootingStatus) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.shootingStatus = shootingStatus;
	}

	public Long getS_id() {
		return s_id;
	}

	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public ShootingStatus getShootingStatus() {
		return shootingStatus;
	}

	public void setShootingStatus(ShootingStatus shootingStatus) {
		this.shootingStatus = shootingStatus;
	}

}
