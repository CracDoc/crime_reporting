package com.crime_reporting.spring.service;

import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.Photo;
import com.crime_report.spring.model.PoliceStation;

public interface IPoliceStationService {

		//1
		PoliceStation getAuthenticateAdmin(String username, String password);
		
		//2
		boolean addCriminal(Criminal criminal, Photo photo );
		
		//3
		List<Complaint> getAllComplaints(Integer pincode);
		
		//4
		Complaint viewComplaint(Integer Complaint_id);
			
		//5
		boolean changeComplaintStatus(Integer complaint_id, String status);
		
		//6
		boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id);
}
