package com.shooting.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long c_id;

	private String c_fname;
	private String c_lname;
	private String c_tel;
	
	@OneToOne
	@JoinColumn(name = "u_id")
	private User user;
	

	public Customer() {
		super();
	}


	public Customer(Long c_id, String c_fname, String c_lname, String c_tel, User user) {
		super();
		this.c_id = c_id;
		this.c_fname = c_fname;
		this.c_lname = c_lname;
		this.c_tel = c_tel;
		this.user = user;
	}


	public Long getC_id() {
		return c_id;
	}


	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}


	public String getC_fname() {
		return c_fname;
	}


	public void setC_fname(String c_fname) {
		this.c_fname = c_fname;
	}


	public String getC_lname() {
		return c_lname;
	}


	public void setC_lname(String c_lname) {
		this.c_lname = c_lname;
	}


	public String getC_tel() {
		return c_tel;
	}


	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	



}
