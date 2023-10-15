package com.shooting.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gun")
public class Gun {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long g_id;

	private String g_name;

	public Gun() {
		super();
	}

	public Gun(Long g_id, String g_name) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
	}

	public Long getG_id() {
		return g_id;
	}

	public void setG_id(Long g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

}
