package com.crime_report.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity

@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
	    name="registerCriminal",
	    procedureName="registerCriminal",
	    		parameters = {
    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "criminal_name"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "date_of_birth"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "crime_commited"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cases_pending"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "wanted_level"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_file_name"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = Byte.class, name = "p_file_data")
	    		}
	    ),
	    @NamedStoredProcedureQuery(
	      name="assignComplaintToCriminal",
	      procedureName="assignComplaintToCriminal",
	    		  parameters = {
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "complaint_id"),
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "criminal_id")
	    			})
} )

@Table(name = "tbl_criminal")
public class Criminal {
	private Integer criminalId;
	private Complaint complaintId;
	private String name;
	private Date dateOfBirth;
	private String crimesCommited;
	private String casesPending;
	private Integer wantedLevel;
	private Photo ph; 
	private List<Complaint> complaints;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCriminalId() {
		return criminalId;
	}
	public void setCriminalId(Integer criminalId) {
		this.criminalId = criminalId;
	}
	@ManyToMany
	@JoinColumn(name = "Complaint")
	@Column(name = "complaint_id")
	public Complaint getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Complaint complaintId) {
		this.complaintId = complaintId;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@OneToOne
	@JoinColumn(name="FK_criminal_photo")
	public Photo getPh() {
		return ph;
	}
	public void setPh(Photo ph) {
		this.ph = ph;
	}
	
	@Column(length = 300)
	public String getCrimesCommited() {
		return crimesCommited;
	}
	public void setCrimesCommited(String crimesCommited) {
		this.crimesCommited = crimesCommited;
	}
	
	@Column(length = 300)
	public String getCasesPending() {
		return casesPending;
	}
	public void setCasesPending(String casesPending) {
		this.casesPending = casesPending;
	}
	
	public Integer getWantedLevel() {
		return wantedLevel;
	}
	public void setWantedLevel(Integer wantedLevel) {
		this.wantedLevel = wantedLevel;
	}
	
	@ManyToMany(mappedBy = "criminals")
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	@Override
	public String toString() {
		return "Criminal [criminalId=" + criminalId + ", complaintId=" + complaintId + ", name=" + name
				+ ", dateOfBirth=" + dateOfBirth + ", crimesCommited=" + crimesCommited
				+ ", casesPending=" + casesPending + ", wantedLevel=" + wantedLevel + ", ph=" + ph + ", complaints="
				+ complaints + "]";
	}
	
	
	
	
}
