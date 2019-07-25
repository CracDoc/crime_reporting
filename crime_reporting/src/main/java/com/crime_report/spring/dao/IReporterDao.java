package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;

public interface IReporterDao {

	// List<Reporter> getAllReporter();
	Reporter getLoginReporter(Integer username, Date Password);
	
	void registerReporter(Reporter register_rep);
	
	String registerComplaint(Complaint complaint_raise);

	//Reporter getAuthenticateReporter();

	Integer changeAddress(String flat_no, String street, String landmark, String city, Integer pincode, Integer address_id);
	
	Complaint complaintStatus(Integer complaint_id);

	List<Complaint> getReporterComplaint(String reporter_id);
	
	

	
	
}