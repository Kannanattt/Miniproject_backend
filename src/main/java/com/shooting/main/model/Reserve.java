package com.shooting.main.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reserve")
public class Reserve {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long r_id;

	private Date r_date_reserve;
	private String r_time_reserve;

	@OneToOne
	@JoinColumn(name = "c_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "s_id")
	private ShootingRange shootingRange;

	private List<Object> guns;

	public Reserve() {
		super();
	}

	public Reserve(Long r_id, Date r_date_reserve, String r_time_reserve, Customer customer,
			ShootingRange shootingRange, List<Object> guns) {
		super();
		this.r_id = r_id;
		this.r_date_reserve = r_date_reserve;
		this.r_time_reserve = r_time_reserve;
		this.customer = customer;
		this.shootingRange = shootingRange;
		this.guns = guns;
	}

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}

	public Date getR_date_reserve() {
		return r_date_reserve;
	}

	public void setR_date_reserve(Date r_date_reserve) {
		this.r_date_reserve = r_date_reserve;
	}

	public String getR_time_reserve() {
		return r_time_reserve;
	}

	public void setR_time_reserve(String r_time_reserve) {
		this.r_time_reserve = r_time_reserve;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShootingRange getShootingRange() {
		return shootingRange;
	}

	public void setShootingRange(ShootingRange shootingRange) {
		this.shootingRange = shootingRange;
	}

	public List<Object> getGuns() {
		return guns;
	}

	public void setGuns(List<Object> guns) {
		this.guns = guns;
	}

}
