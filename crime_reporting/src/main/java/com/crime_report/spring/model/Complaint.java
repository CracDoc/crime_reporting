package com.crime_report.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_complaint" )
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "com_id",updatable = false , nullable = false)
	private Integer complaint_id;
	
	@Column(name = "com_type",updatable = false , nullable = false,length = 20)
	private String complaint_type;
	@Column(name = "com_status",updatable = false , nullable = false,length = 20)
	private String complaint_status;
	@Column(name = "com_desc",updatable = false , nullable = false,length = 400)
	private String complaint_desc;
	@Column(name = "location",updatable = false , nullable = false,length = 50)
	private String location;
	@Column(name = "pincode",nullable = false, length = 6)
	private String pincode;
	
	
	public Integer getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(Integer complaint_id) {
		this.complaint_id = complaint_id;
	}
	public String getComplaint_type() {
		return complaint_type;
	}
	public void setComplaint_type(String complaint_type) {
		this.complaint_type = complaint_type;
	}
	public String getComplaint_status() {
		return complaint_status;
	}
	public void setComplaint_status(String complaint_status) {
		this.complaint_status = complaint_status;
	}
	public String getComplaint_desc() {
		return complaint_desc;
	}
	public void setComplaint_desc(String complaint_desc) {
		this.complaint_desc = complaint_desc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", complaint_type=" + complaint_type + ", complaint_status="
				+ complaint_status + ", complaint_desc=" + complaint_desc + ", location=" + location + ", pincode="
				+ pincode + "]";
	}
	
	
	
	
	
	
	
}
