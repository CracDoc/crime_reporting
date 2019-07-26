package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;

public interface IReporterDao {

	// List<Reporter> getAllReporter();
	Reporter getLoginReporter(Integer username, Date Password);
	
	boolean registerReporter(String repo_name, String repo_aadhar_no, Date date_of_birth, String flat_no,  String street, String landmark, String city, Integer pincode, String primary_no, String secondary_no, String land_line);
	
	boolean registerComplaint(String com_type, String com_status, String com_desc, Date com_date, String location, Integer pincode, Integer rp_id, Integer ps_id);

	boolean changeAddress(Integer rp_id, String flat_no, String street, String landmark, String city, Integer pincode);
	
	boolean changeContact(Integer rp_id, String primary_no, String secondary_no, String land_line);
	
	Complaint complaintStatus(Integer complaint_id);

	List<Complaint> getAllReporterComplaint(Integer rp_id);
	
	

	
	
}