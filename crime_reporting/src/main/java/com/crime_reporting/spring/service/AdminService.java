package com.crime_reporting.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crime_report.spring.dao.AdminDaoImpl;
import com.crime_report.spring.model.AddressPoliceStation;
import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	
	@Override
	public Admin loginAdmin(String username, String password) {
		return adminDao.loginAdmin(username, password);		 
	}

	@Override
	public boolean addPoliceStation(PoliceStation policeStation, AddressPoliceStation addressPoliceStation) {
		String police_station_name = policeStation.getPolice_station_name();
		String flat_no = addressPoliceStation.getFlat_no();
		String street = addressPoliceStation.getStreet();
		String landmark = addressPoliceStation.getLandmark();
		String city = addressPoliceStation.getCity();
		Integer pincode = addressPoliceStation.getPincode();
		String username = policeStation.getPolice_station_username();
		String password = policeStation.getPolice_station_password();
		if(adminDao.addPoliceStation(police_station_name,flat_no,street,landmark,city,pincode,username,password))
			return true;
		return false;
	}

	@Override
	public boolean changeCredentials(Admin admin, String password) {
		String username = admin.getUsername();
		if(adminDao.changeCredentials(username,password))
			return true;
		return false;
	}

	@Override
	public List<Complaint> viewAllComplaints() {
		return adminDao.viewAllComplaints();
	}

	@Override
	public List<Criminal> viewAllCriminals() {
		return adminDao.viewAllCriminals();
	}

	@Override
	public List<Reporter> viewAllReporters() {
		return adminDao.viewAllReporters();
	}

	@Override
	public List<PoliceStation> viewAllPoliceStations() {
		return adminDao.viewAllPoliceStations();
	}

	

}
