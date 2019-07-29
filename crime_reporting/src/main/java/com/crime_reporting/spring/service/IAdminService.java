package com.crime_reporting.spring.service;

import java.util.List;

import com.crime_report.spring.model.AddressPoliceStation;
import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;

public interface IAdminService {
	
	Admin loginAdmin(String username, String password);
	
	public boolean addPoliceStation(PoliceStation policeStation,AddressPoliceStation addressPoliceStation);
	
	public boolean changeCredentials(Admin admin, String password);
	
	public List<Complaint> viewAllComplaints();
	
	public List<Criminal> viewAllCriminals();
	
	public List<Reporter> viewAllReporters();
	
	public List<PoliceStation> viewAllPoliceStations();


}
