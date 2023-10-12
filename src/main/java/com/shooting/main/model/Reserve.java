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
	private Time r_time_reserve;
	private Date r_date_deadline;
	private Time r_time_deadline;

	@OneToOne
	@JoinColumn(name = "c_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "s_id")
	private ShootingRange shootingRange;

	@OneToMany
	@JoinColumn(name = "g_id")
	private List<Gun> guns;

	public Reserve() {
		super();
	}

	public Reserve(Long r_id, Date r_date_reserve, Time r_time_reserve, Date r_date_deadline, Time r_time_deadline,
			Customer customer, ShootingRange shootingRange, List<Gun> guns) {
		super();
		this.r_id = r_id;
		this.r_date_reserve = r_date_reserve;
		this.r_time_reserve = r_time_reserve;
		this.r_date_deadline = r_date_deadline;
		this.r_time_deadline = r_time_deadline;
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

	public Time getR_time_reserve() {
		return r_time_reserve;
	}

	public void setR_time_reserve(Time r_time_reserve) {
		this.r_time_reserve = r_time_reserve;
	}

	public Date getR_date_deadline() {
		return r_date_deadline;
	}

	public void setR_date_deadline(Date r_date_deadline) {
		this.r_date_deadline = r_date_deadline;
	}

	public Time getR_time_deadline() {
		return r_time_deadline;
	}

	public void setR_time_deadline(Time r_time_deadline) {
		this.r_time_deadline = r_time_deadline;
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

	public List<Gun> getGuns() {
		return guns;
	}

	public void setGuns(List<Gun> guns) {
		this.guns = guns;
	}

}
