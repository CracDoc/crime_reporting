package com.crime_reporting.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crime_report.spring.dao.PoliceStationDaoImpl;
import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.Photo;


@Service
public class PoliceStationService implements IPoliceStationService {
	
	@Autowired
	private PoliceStationDaoImpl policestation;

	@Override
	public Admin getAuthenticateAdmin(Integer ps_id, String username, String password) {
		return policestation.getAuthenticateAdmin(ps_id, username, password);
	}

	@Override
	public boolean addCriminal(Criminal criminal, Photo photo) {
		String criminal_name = criminal.getName();
		Date date_of_birth = criminal.getDateOfBirth();
		String crime_commited = criminal.getCrimesCommited();
		String cases_pending = criminal.getCasesPending(); 
		Integer wanted_level = criminal.getWantedLevel(); 
		String p_file_name = photo.getFileName(); 
		byte[] p_file_data = photo.getData();
		if(policestation.addCriminal(criminal_name, date_of_birth, crime_commited, cases_pending, wanted_level, p_file_name, p_file_data))
			return true;
		return false;
	}

	@Override
	public List<Complaint> getAllComplaints(String pincode) {
		List<Complaint> list = policestation.getAllComplaints(pincode);
		return list;
	}

	@Override
	public Complaint viewComplaint(Integer complaint_id) {
		Complaint complaint = policestation.viewComplaint(complaint_id);
		return complaint;
	}

	@Override
	public boolean changeComplaintStatus(Integer complaint_id, String status) {
		Integer complaint = policestation.changeComplaintStatus(complaint_id, status);
		if(complaint==1)
		return true;
		return false;
	}

	@Override
	public boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id) {
		if(policestation.criminalAssignToComplaint(complaint_id, criminal_id))
		return true;
		return false;
	}

}
