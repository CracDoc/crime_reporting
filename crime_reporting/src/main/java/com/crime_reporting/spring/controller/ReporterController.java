package com.crime_reporting.spring.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime_report.spring.model.AddressReporter;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.ContactReporter;
import com.crime_report.spring.model.Reporter;
import com.crime_reporting.spring.exception.AdminException;
import com.crime_reporting.spring.exception.ReporterException;
import com.crime_reporting.spring.service.ReporterService;

@RestController
@RequestMapping("/reporter")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReporterController {
	
	@Autowired
	private ReporterService reporterService;
	@Autowired
	private HttpServletRequest req;
	
	public ReporterController() {
		System.out.println("in reporter controller");
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> getLogin(Integer username, Date password) throws ReporterException {
		System.out.println("in reporter login");
		try {
			HttpSession hs = req.getSession();
			Reporter reporter = reporterService.getLoginReporter(username,password);
			System.out.println(reporterService.getLoginReporter(username, password)+" validating reporter");
			if(reporter != null)
			{
				hs.setAttribute("reporter", reporter);
				System.out.println(hs.getAttribute("reporter"));
			}
			else {
				throw new ReporterException("Could not login, please try again");
			}
			return new ResponseEntity<Reporter>(reporter, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Reporter login failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/registerReporter")
	public ResponseEntity<?> registerReporter(@RequestBody Reporter reporter,@RequestBody AddressReporter addrReporter,@RequestBody ContactReporter contactReporter) {
		System.out.println("in reporter register");
		try {
			boolean stat = reporterService.registerReporter(reporter, addrReporter, contactReporter);
			if(stat)
				return new ResponseEntity<Reporter>(HttpStatus.OK);
			else 
				throw new ReporterException("Reporter registration failed, please try again");
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Reporter registration failed due to some reason. Please try again.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@PostMapping("/registerComplaint")
	public ResponseEntity<?> registerComplaint(@RequestBody Complaint complaint, @RequestBody Reporter reporter, @RequestBody Integer ps_id) {
		System.out.println("in reporter : crime register");
		try {
			boolean stat = reporterService.registerComplaint(complaint, reporter);
			if(stat)
				return new ResponseEntity<Complaint>(HttpStatus.OK);
			else 
				throw new ReporterException("Complaint registration failed, please try again");
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Complaint registration failed due to some reason. Please try again.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/changeAddress")
	public ResponseEntity<?> changeAddress(@RequestBody Reporter reporter, @RequestBody AddressReporter addrReporter) throws ReporterException {
		System.out.println("in reporter : change addr");
		try {
			HttpSession hs = req.getSession();
			Reporter r = reporterService.changeAddress(reporter, addrReporter);
			if(r != null)
			{
				hs.setAttribute("reporter", reporter);
				System.out.println(hs.getAttribute("reporter"));
			}
			else {
				System.out.println(hs.getAttribute("reporter"));
				throw new ReporterException("Could not change address, please try again");
			}
			return new ResponseEntity<Reporter>(r, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Changing address failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/changeContact")
	public ResponseEntity<?> changeContact(Reporter reporter, ContactReporter contactReporter) throws ReporterException {
		System.out.println("in reporter : change contact");
		try {
			HttpSession hs = req.getSession();
			Reporter r = reporterService.changeContact(reporter, contactReporter);
			if(r != null)
			{
				hs.setAttribute("reporter", reporter);
				System.out.println(hs.getAttribute("reporter"));
			}
			else {
				System.out.println(hs.getAttribute("reporter"));
				throw new ReporterException("Could not change contact, please try again");
			}
			return new ResponseEntity<Reporter>(r, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Changing contact failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/viewComplaintStatus")
	public ResponseEntity<?> complaintStatus(Reporter reporter, Complaint complaint) throws ReporterException {
		System.out.println("in reporter : complaint status");
		try {
			HttpSession hs = req.getSession();
			Complaint c = reporterService.complaintStatus(reporter, complaint);
			if(c != null)
			{
				hs.setAttribute("reporter", reporter);
				System.out.println(hs.getAttribute("reporter"));
			}
			else {
				System.out.println(hs.getAttribute("reporter"));
				throw new ReporterException("Could not get complaint status, please try again");
			}
			return new ResponseEntity<Complaint>(c, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity<?> getAllReporterComplaint(Reporter reporter) throws ReporterException {
		System.out.println("in reporter : all reporter complaints");
		try {
			HttpSession hs = req.getSession();
			List<Complaint> list = reporterService.getAllReporterComplaint(reporter);
			if(list != null)
			{
				hs.setAttribute("reporter", reporter);
				System.out.println(hs.getAttribute("reporter"));
			}
			else {
				System.out.println(hs.getAttribute("reporter"));
				throw new ReporterException("Could not get registered complaints, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}


}
