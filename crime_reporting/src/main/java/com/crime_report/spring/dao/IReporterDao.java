package com.crime_report.spring.dao;

import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;

public interface IReporterDao {

	// List<Reporter> getAllReporter();
	Reporter getLoginReporter(Integer username, String Password);
	
	void registerReporter(Reporter register_rep);
	
	String registerComplaint(Complaint complaint_raise);

	//Reporter getAuthenticateReporter();

	
	
	String complaintStatus(Complaint complaint_id);

	List<Complaint> getReporterComplaint(String reporter_id);
	
	

	
	
}