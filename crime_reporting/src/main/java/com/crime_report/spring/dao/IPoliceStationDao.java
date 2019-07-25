
package com.crime_report.spring.dao;

import java.util.List;

import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;

/**
 * @author SCRAT
 *
 */
public interface IPoliceStationDao {
	
	//1
	Admin getAuthenticateAdmin(Integer ps_id, String username, String password);
	
	//2
	String addCriminal(Criminal criminal);
	
	List<Complaint> getAllComplaints(String pincode);
	
	//3
	Complaint viewComplaint(Integer Complaint_id);
		
	//4
	Integer changeComplaintStatus(Integer complaint_id, String status);
	
	//5
	boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id);
	
	
	
}
