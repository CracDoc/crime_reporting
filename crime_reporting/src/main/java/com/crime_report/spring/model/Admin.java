package com.crime_report.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tbl_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id",nullable = false, updatable = false)
	private Integer admin_id;
	
	@Column(name = "username",nullable = false,length = 20)
	private String username;
	
	@Column(name = "password",nullable = false,length = 20)
	private String password;
	
	@Column(name = "ps_id")
	@OneToOne(mappedBy = "ps_id")
	@Cascade(value = CascadeType.ALL)
	private PoliceStation ps_id;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PoliceStation getPs_id() {
		return ps_id;
	}

	public void setPs_id(PoliceStation ps_id) {
		this.ps_id = ps_id;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", username=" + username + ", password=" + password + ", ps_id=" + ps_id
				+ "]";
	}
	

	
	
}
