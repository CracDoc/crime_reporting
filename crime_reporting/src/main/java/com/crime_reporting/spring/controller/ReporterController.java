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
	public ResponseEntity<?> getLogin(Integer username, Date password) {
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
				System.out.println(hs.getAttribute("reporter"));
			}
			return new ResponseEntity<Reporter>(reporter, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Reporter login failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	/*
	@PostMapping("/register")
	public ResponseEntity<?> registerReporter(@RequestBody Reporter reporter,@RequestBody AddressReporter addrReporter,@RequestBody ContactReporter contactReporter) {
		System.out.println("in reporter register");
		try {
			reporter = reporterService.registerReporter(reporter, addrReporter, contactReporter);
			return new ResponseEntity<Reporter>(reporter,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}	
	*/
	@GetMapping("/")
	public boolean registerComplaint(Complaint complaint, Integer rp_id, Integer ps_id) {
		System.out.println("in reporter : crime register");
		boolean stat = reporterService.registerComplaint(complaint, rp_id, ps_id);
		if(stat)
		{
			System.out.println("Registration of complaint successfull");
			return true;
		}
		else
		{
			System.out.println("Registration of complaint failed");
			return false;
		}
	}
	
	@GetMapping("/")
	public boolean changeAddress(Integer rp_id, AddressReporter addrReporter) {
		System.out.println("in reporter : change addr");
		boolean stat = reporterService.changeAddress(rp_id, addrReporter);
				if(stat)
				{
					System.out.println("addr change successfull");
					return true;
				}
				else
				{
					System.out.println("addr change failed");
					return false;
				}
	}
	
	@GetMapping("/")
	public boolean changeContact(Integer rp_id, ContactReporter contactReporter) {
		System.out.println("in reporter : change contact");
		boolean stat = reporterService.changeContact(rp_id, contactReporter);
				if(stat)
				{
					System.out.println("contact change successfull");
					return true;
				}
				else
				{
					System.out.println("contact change failed");
					return false;
				}
	}
	
	@GetMapping("/")
	public Complaint complaintStatus(Integer rp_id, Integer complaint_id) {
		System.out.println("in reporter : complaint status");
		return reporterService.complaintStatus(rp_id, complaint_id);
	}
	
	@GetMapping("/")
	public List<Complaint> getAllReporterComplaint(Integer rp_id) {
		System.out.println("in reporter : all reporter complaints");
		List<Complaint> list = reporterService.getAllReporterComplaint(rp_id);
		return list;
	}


}
