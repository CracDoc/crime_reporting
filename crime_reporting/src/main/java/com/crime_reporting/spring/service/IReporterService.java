package com.crime_reporting.spring.service;

import java.util.Date;
import java.util.List;

import com.crime_report.spring.model.AddressReporter;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.ContactReporter;
import com.crime_report.spring.model.Reporter;

public interface IReporterService {
	
		Reporter getLoginReporter(Integer username, Date Password);
		
		boolean registerReporter(Reporter reporter, AddressReporter addrReporter, ContactReporter contactReporter);
		
		boolean registerComplaint(Complaint complaint, Integer rp_id, Integer ps_id);

		boolean changeAddress(Integer rp_id, AddressReporter addrReporter);
		
		boolean changeContact(Integer rp_id, ContactReporter contactReporter);
		
		Complaint complaintStatus(Integer rp_id, Integer complaint_id);

		List<Complaint> getAllReporterComplaint(Integer rp_id);
		

}
