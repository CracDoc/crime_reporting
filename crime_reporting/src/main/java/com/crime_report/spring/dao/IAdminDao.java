package com.crime_report.spring.dao;

import java.util.List;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;

public interface IAdminDao {
	
	public boolean addPoliceStation(String police_station_name,String flat_no,String street,String landmark,String city,Integer pincode,String username,String password);
	
	public boolean changeCredentials(Integer ps_id, String username, String password);
	
	public List<Complaint> viewAllComplaints();
	
	public List<Criminal> viewAllCriminals();
	
	public List<Reporter> viewAllReporters();
	
	public List<PoliceStation> viewAllPoliceStations();

}
