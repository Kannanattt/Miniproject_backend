package com.shooting.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long o_id;

	private String o_fname;
	private String o_lname;

	@OneToOne
	@JoinColumn(name = "u_id")
	private User user;

	public Owner() {
		super();
	}

	public Owner(Long o_id, String o_fname, String o_lname, User user) {
		super();
		this.o_id = o_id;
		this.o_fname = o_fname;
		this.o_lname = o_lname;
		this.user = user;
	}

	public Long getO_id() {
		return o_id;
	}

	public void setO_id(Long o_id) {
		this.o_id = o_id;
	}

	public String getO_fname() {
		return o_fname;
	}

	public void setO_fname(String o_fname) {
		this.o_fname = o_fname;
	}

	public String getO_lname() {
		return o_lname;
	}

	public void setO_lname(String o_lname) {
		this.o_lname = o_lname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
