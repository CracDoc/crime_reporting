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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "tbl_police_station")
public class PoliceStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ps_id",nullable = false, updatable = false)
	@GenericGenerator(name = "ps_id", strategy = "foreign", parameters = {
			@Parameter(name = "ps_property", value = "ps_id") })
	private Integer ps_id;
	@Column(name = "police_station",nullable = false,length = 30)
	private String police_station;
	@Column(name = "ps_addr_id")
	@OneToOne(mappedBy = "addr_police_station")
	@Cascade(value = CascadeType.ALL)
	private AddressPoliceStation ps_addr_id;
	
	public PoliceStation() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getPs_id() {
		return ps_id;
	}
	public void setPs_id(Integer ps_id) {
		this.ps_id = ps_id;
	}
	public String getPolice_station() {
		return police_station;
	}
	public void setPolice_station(String police_station) {
		this.police_station = police_station;
	}
	public AddressPoliceStation getPs_addr_id() {
		return ps_addr_id;
	}
	public void setPs_addr_id(AddressPoliceStation ps_addr_id) {
		this.ps_addr_id = ps_addr_id;
	}
	
	
	
	
	@Override
	public String toString() {
		return "PoliceStation [ps_id=" + ps_id + ", police_station=" + police_station + ", ps_addr_id=" + ps_addr_id
				+ "]";
	}

	
	
	
	
	
	
}
