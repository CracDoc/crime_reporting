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
		
		boolean registerComplaint(Complaint complaint, Reporter reporter);

		Reporter changeAddress(Reporter reporter, AddressReporter addrReporter);
		
		Reporter changeContact(Reporter reporter, ContactReporter contactReporter);
		
		Complaint complaintStatus(Reporter reporter, Complaint complaint);

		List<Complaint> getAllReporterComplaint(Reporter reporter);
		

}
