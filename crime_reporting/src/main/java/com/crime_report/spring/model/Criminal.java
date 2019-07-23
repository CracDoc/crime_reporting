package com.crime_report.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_criminal")
public class Criminal {
	private Integer criminalId;
	private String name;
	private String crimesCommited;
	private String casesPending;
	private Integer wantedLevel;
	private Photo ph; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "criminal_id")
	public Integer getCriminalId() {
		return criminalId;
	}
	public void setCriminalId(Integer criminalId) {
		this.criminalId = criminalId;
	}
	
	@Column(length = 30, name = "criminal_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne
	@JoinColumn(name = "ph_id")
	public Photo getPh() {
		return ph;
	}
	public void setPh(Photo ph) {
		this.ph = ph;
	}
	
	@Column(length = 300, name = "crime_commited")
	public String getCrimesCommited() {
		return crimesCommited;
	}
	public void setCrimesCommited(String crimesCommited) {
		this.crimesCommited = crimesCommited;
	}
	
	@Column(length = 300, name = "cases_pending")
	public String getCasesPending() {
		return casesPending;
	}
	public void setCasesPending(String casesPending) {
		this.casesPending = casesPending;
	}
	
	@Column(name = "wanted_level")
	public Integer getWantedLevel() {
		return wantedLevel;
	}
	public void setWantedLevel(Integer wantedLevel) {
		this.wantedLevel = wantedLevel;
	}
	
	@Override
	public String toString() {
		return "Criminal [criminalId=" + criminalId + ", name=" + name + ", crimesCommited=" + crimesCommited
				+ ", casesPending=" + casesPending + ", wantedLevel=" + wantedLevel + ", ph=" + ph + "]";
	}
	
	
	
	
}
