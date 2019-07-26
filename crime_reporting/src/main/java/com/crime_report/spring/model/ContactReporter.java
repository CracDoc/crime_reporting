package com.crime_report.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity

@NamedStoredProcedureQuery(
		name = "changeReporterContact",
		procedureName = "changeReporterContact",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "rp_id"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "primary_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "secondary_no"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "land_line")
				}
		)

@Table(name="tbl_contact_reporter")
public class ContactReporter {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id",updatable = false,nullable = false,unique = true)
	private long contact_id;
	@Column(nullable = false)
	private long primary_no;
	@Column(name = "secondary_no")
	private long secondary_no;
	@Column(name = "land_line")
	private long land_line ;
	@OneToOne(mappedBy = "contact")
    private Reporter reporter;

	
	//Getter and Setter 
	public long getContact_id() {
		return contact_id;
	}
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}
	public long getPrimary_no() {
		return primary_no;
	}
	public void setPrimary_no(long primary_no) {
		this.primary_no = primary_no;
	}
	public long getSecondary_no() {
		return secondary_no;
	}
	public void setSecondary_no(long secondary_no) {
		this.secondary_no = secondary_no;
	}
	public long getLand_line() {
		return land_line;
	}
	public void setLand_line(long land_line) {
		this.land_line = land_line;
	}
	
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	
	@Override
	public String toString() {
		return "ContactReporter [contact_id=" + contact_id + ", primary_no=" + primary_no + ", secondary_no="
				+ secondary_no + ", land_line=" + land_line + ", reporter=" + reporter + "]";
	}
	
	
}
