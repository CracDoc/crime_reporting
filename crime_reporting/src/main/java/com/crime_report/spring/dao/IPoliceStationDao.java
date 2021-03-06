
package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.PoliceStation;

/**
 * @author SCRAT
 *
 */
public interface IPoliceStationDao {
	
	//1
	PoliceStation getAuthenticateAdmin(String username, String password);
	
	//2
	boolean addCriminal(String criminal_name, Date date_of_birth, String crime_commited, String cases_pending, Integer wanted_level, String p_file_name, byte[] p_file_data );
	
	//3
	List<Complaint> getAllComplaints(Integer pincode);
	
	//4
	Complaint viewComplaint(Integer Complaint_id);
		
	//5
	Integer changeComplaintStatus(Integer complaint_id, String status);
	
	//6
	boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id);
	
	
	
}
