package com.shooting.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ShootingStatus")
public class ShootingStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long status_id;

	private String status_name;

	public ShootingStatus() {
		super();
	}

	public ShootingStatus(Long status_id, String status_name) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
	}

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

}
