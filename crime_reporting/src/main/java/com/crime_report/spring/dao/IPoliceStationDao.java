/**
 * 
 */
package com.crime_report.spring.dao;

import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;

/**
 * @author SCRAT
 *
 */
public interface IPoliceStationDao {
	
	//1
	PoliceStation getAuthenticateAdmin(Integer ps_id, String username, String password);
	
	//2
	boolean addCriminal(Criminal criminal);
	
	//List<PoliceStation> getAllPoliceStation();
	
	//3
	Complaint viewComplaint(Integer Complaint_id);
		
	//4
	String changeComplaintStatus(Integer complaint_id);
	
	//5
	boolean criminalAssignToComplaint();
	
	
	
	
	
	
	
}
