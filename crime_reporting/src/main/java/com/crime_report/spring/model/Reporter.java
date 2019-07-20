package com.crime_report.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_reporter")
public class Reporter {

	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "reporter_id",updatable = false , nullable = false)
	private Integer reporter_id;
	
	@Column(name = "reporter_name",nullable = false)
	private String reporter_name;
	
	@Column(name = "repo_aadhar_no", updatable = true, nullable = false,length = 12)
	private Integer repo_aadhar_no;
	
	@Column(name = "date_of_birth",nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date D_O_B;
	
	@OneToOne(mappedBy = "reporter")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private AddressReporter address_id;
	
	@OneToOne(mappedBy = "reporter")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private ContactReporter contact_id;
	
	
	//Getter And Setter

	

	


	public Integer getReporter_id() {
		return reporter_id;
	}


	public void setReporter_id(Integer reporter_id) {
		this.reporter_id = reporter_id;
	}


	public String getReporter_name() {
		return reporter_name;
	}


	public void setReporter_name(String reporter_name) {
		this.reporter_name = reporter_name;
	}


	public Integer getRepo_aadhar_no() {
		return repo_aadhar_no;
	}


	public void setRepo_aadhar_no(Integer repo_aadhar_no) {
		this.repo_aadhar_no = repo_aadhar_no;
	}


	public Date getD_O_B() {
		return D_O_B;
	}


	public void setD_O_B(Date d_O_B) {
		D_O_B = d_O_B;
	}


	public AddressReporter getAddress_id() {
		return address_id;
	}


	public void setAddress_id(AddressReporter address_id) {
		this.address_id = address_id;
	}


	public ContactReporter getContact_id() {
		return contact_id;
	}


	public void setContact_id(ContactReporter contact_id) {
		this.contact_id = contact_id;
	}
	
	
	
	


	@Override
	public String toString() {
		return "Reporter [reporter_id=" + reporter_id + ", reporter_name=" + reporter_name + ", repo_aadhar_no="
				+ repo_aadhar_no + ", D_O_B=" + D_O_B + ", address_id=" + address_id + ", contact_id=" + contact_id
				+ "]";
	}
	
	
	
	
	

	
}
