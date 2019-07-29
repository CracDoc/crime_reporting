package com.crime_report.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
		name = "registerComplaint",
		procedureName = "registerComplaint",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "com_type"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "com_status"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "com_desc"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "com_desc"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "location"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "pincode"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "rp_id"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ps_id")
				}
		),
@NamedStoredProcedureQuery(
	      name="assignComplaintToCriminal",
	      procedureName="assignComplaintToCriminal",
	    		  parameters = {
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "complaint_id"),
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "criminal_id")
	    			}),
@NamedStoredProcedureQuery(
		name = "assignComplaintToPS",
		procedureName = "assignComplaintToPS",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ps_id"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "complaint_id")
		}
		)
})

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
	@Column(name = "com_date",updatable = false , nullable = false)
	private Date complaint_date;
	@Column(name = "location",updatable = false , nullable = false,length = 50)
	private String location;
	@Column(name = "pincode",nullable = false, length = 6)
	private Integer pincode;
	
	@ManyToOne
	@JoinColumn(name="FK_reporter")
	private Reporter reporter;
	
	@ManyToOne
	@JoinColumn(name="FK_police_station")
	private PoliceStation policestation;
	
	@ManyToMany
	@JoinTable(name="tbl_complaint_criminal_mapping",
				joinColumns = { @JoinColumn(name = "FK_complaint_map") },
						inverseJoinColumns = { @JoinColumn(name = "FK_criminal_map") })
	private List<Criminal> criminals;
	
	public Complaint() {
		// TODO Auto-generated constructor stub
	}
	
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
	public Date getComplaint_date() {
		return complaint_date;
	}
	public void setComplaint_date(Date complaint_date) {
		this.complaint_date = complaint_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	public Reporter getReporter() {
		return reporter;
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public PoliceStation getPolicestation() {
		return policestation;
	}

	public void setPolicestation(PoliceStation policestation) {
		this.policestation = policestation;
	}

	public List<Criminal> getCriminals() {
		return criminals;
	}

	public void setCriminals(List<Criminal> criminals) {
		this.criminals = criminals;
	}

	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", complaint_type=" + complaint_type + ", complaint_status="
				+ complaint_status + ", complaint_desc=" + complaint_desc + ", complaint_date=" + complaint_date
				+ ", location=" + location + ", pincode=" + pincode + ", reporter=" + reporter + ", policestation="
				+ policestation + ", criminals=" + criminals + "]";
	}

	
	
	
	
}
