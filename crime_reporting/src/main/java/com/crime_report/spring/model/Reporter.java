package com.crime_report.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity

@NamedStoredProcedureQuery(
		name = "registerReporter",
		procedureName = "registerReporter",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "repo_name"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "repo_aadhar_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "date_of_birth"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "flat_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "street"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "landmark"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "city"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "pincode"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "primary_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "secondary_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "land_line")
				}
		)

@Table(name = "tbl_reporter")
public class Reporter {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rp_id",updatable = false , nullable = false)
	private Integer reporter_id;
	
	@Column(name = "repo_name",nullable = false)
	private String reporter_name;
	
	@Column(name = "repo_aadhar_no", updatable = true, nullable = false,length = 12)
	private String repo_aadhar_no;
	
	@Column(name = "date_of_birth",nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date D_O_B;
	
	@Column(name = "addr_id")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
	private AddressReporter address;
	
	@Column(name = "contact_id")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
	private ContactReporter contact;
	
	@OneToMany(mappedBy = "reporter", cascade=CascadeType.ALL)
	private List<Complaint> complaint;

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

	public String getRepo_aadhar_no() {
		return repo_aadhar_no;
	}

	public void setRepo_aadhar_no(String repo_aadhar_no) {
		this.repo_aadhar_no = repo_aadhar_no;
	}

	public Date getD_O_B() {
		return D_O_B;
	}

	public void setD_O_B(Date d_O_B) {
		D_O_B = d_O_B;
	}

	public AddressReporter getAddress() {
		return address;
	}

	public void setAddress(AddressReporter address) {
		this.address = address;
	}

	public ContactReporter getContact() {
		return contact;
	}

	public void setContact(ContactReporter contact) {
		this.contact = contact;
	}

	public List<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<Complaint> complaint) {
		this.complaint = complaint;
	}

	@Override
	public String toString() {
		return "Reporter [reporter_id=" + reporter_id + ", reporter_name=" + reporter_name + ", repo_aadhar_no="
				+ repo_aadhar_no + ", D_O_B=" + D_O_B + ", address=" + address + ", contact=" + contact + ", complaint="
				+ complaint + "]";
	}
	
	

	
}
