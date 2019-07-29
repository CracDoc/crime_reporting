package com.crime_reporting.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crime_report.spring.dao.ReporterDaoImpl;
import com.crime_report.spring.model.AddressPoliceStation;
import com.crime_report.spring.model.AddressReporter;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.ContactReporter;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;

@Service
public class ReporterService implements IReporterService {
	
	@Autowired
	private ReporterDaoImpl reporterdao;
	
	private PoliceStation policeStation;
	
	private AddressPoliceStation addrPS;

	@Override
	@Transactional
	public Reporter getLoginReporter(Integer username, Date password) {
		
		return reporterdao.getLoginReporter(username, password);
	}

	@Override
	@Transactional
	public boolean registerReporter(Reporter reporter, AddressReporter addrReporter, ContactReporter contactReporter) {
		String repo_name = reporter.getReporter_name();
		String repo_aadhar_no = reporter.getRepo_aadhar_no();
		Date date_of_birth = reporter.getD_O_B();
		String flat_no = addrReporter.getFlat_no();
		String street = addrReporter.getStreet();
		String landmark = addrReporter.getLandmark();
		String city = addrReporter.getCity();
		Integer pincode = addrReporter.getPincode();
		String primary_no = contactReporter.getPrimary_no();
		String secondary_no = contactReporter.getSecondary_no();
		String land_line = contactReporter.getLand_line();
		if(reporterdao.registerReporter(repo_name, repo_aadhar_no, date_of_birth, flat_no, street, landmark, city, pincode, primary_no, secondary_no, land_line))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean registerComplaint(Complaint complaint, Reporter reporter) {
		Integer rp_id = reporter.getReporter_id();
		String com_type = complaint.getComplaint_type(); 
		String com_status = complaint.getComplaint_status(); 
		String com_desc = complaint.getComplaint_desc(); 
		Date com_date = complaint.getComplaint_date(); 
		String location = complaint.getLocation(); 
		Integer pincode = complaint.getPincode();
		Integer ps_id = null;
//		AddressPoliceStation addrCounter = policeStation.getPs_address();
//		Integer p = addrCounter.getPincode();
//		Integer id = policeStation.getPs_id();
//		
//		while( id !=null )
//		{
//			if(p==pincode)
//			{
//				complaint.setPolicestation(policeStation); 
//				break;
//			}
//			id++;
//			
//		}
		if(reporterdao.registerComplaint(com_type, com_status, com_desc, com_date, location, pincode, rp_id, ps_id))
			return true;
		return false;
	}

	@Override
	@Transactional
	public Reporter changeAddress(Reporter reporter, AddressReporter addrReporter) {
		Integer rp_id = reporter.getReporter_id();
		String flat_no = addrReporter.getFlat_no();
		String street = addrReporter.getStreet();
		String landmark = addrReporter.getLandmark();
		String city = addrReporter.getCity();
		Integer pincode = addrReporter.getPincode();
		if(reporterdao.changeAddress(rp_id, flat_no, street, landmark, city, pincode))
			return reporter;
		return null;
	}

	@Override
	@Transactional
	public Reporter changeContact( Reporter reporter, ContactReporter contactReporter) {
		Integer rp_id = reporter.getReporter_id();
		String primary_no = contactReporter.getPrimary_no();
		String secondary_no = contactReporter.getSecondary_no();
		String land_line = contactReporter.getLand_line();
		if(reporterdao.changeContact(rp_id, primary_no, secondary_no, land_line))
			return reporter;
		return null;
	}

	@Override
	@Transactional
	public Complaint complaintStatus(Reporter reporter, Complaint complaint) {
		Integer complaint_id = complaint.getComplaint_id();
		Integer rp_id = reporter.getReporter_id();
		return reporterdao.complaintStatus(rp_id, complaint_id);
	}

	@Override
	@Transactional
	public List<Complaint> getAllReporterComplaint(Reporter reporter) {
		Integer rp_id = reporter.getReporter_id();
		List<Complaint> list = reporterdao.getAllReporterComplaint(rp_id);
		return list;
	}

}
