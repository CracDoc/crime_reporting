package com.crime_report.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity

@Table(name = "tbl_police_station")
public class PoliceStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ps_id",nullable = false, updatable = false)
	private Integer ps_id;
	
	@Column(name = "police_station_name",nullable = false,length = 30)
	private String police_station_name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ps_addr")
	private AddressPoliceStation ps_address;
	
	@OneToOne(mappedBy = "ps_id")
	private Admin admin;
	
	@OneToMany(mappedBy = "policestation", cascade=CascadeType.ALL)
	private List<Complaint> complaint;

	public Integer getPs_id() {
		return ps_id;
	}

	public void setPs_id(Integer ps_id) {
		this.ps_id = ps_id;
	}

	public String getPolice_station_name() {
		return police_station_name;
	}

	public void setPolice_station_name(String police_station_name) {
		this.police_station_name = police_station_name;
	}

	public AddressPoliceStation getPs_address() {
		return ps_address;
	}

	public void setPs_address(AddressPoliceStation ps_address) {
		this.ps_address = ps_address;
	}


	public List<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<Complaint> complaint) {
		this.complaint = complaint;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "PoliceStation [ps_id=" + ps_id + ", police_station_name=" + police_station_name + ", ps_address="
				+ ps_address + ", admin=" + admin + ", complaint=" + complaint + "]";
	}

	
	
	
}
