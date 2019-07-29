package com.crime_reporting.spring.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime_report.spring.model.AddressPoliceStation;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.Photo;
import com.crime_report.spring.model.PoliceStation;
import com.crime_reporting.spring.exception.PoliceStationException;
import com.crime_reporting.spring.service.PoliceStationService;

@RestController
@RequestMapping("/policeStation")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PoliceStationController {
	
	@Autowired
	private PoliceStationService policeStationService;
	
	@Autowired
	private HttpServletRequest req;
	
	public PoliceStationController() {
		System.out.println("In police station controller");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getLogin(String username, String password) throws PoliceStationException {
		System.out.println("in police station login");
		try {
			HttpSession hs = req.getSession();
			PoliceStation policeStation = policeStationService.getAuthenticateAdmin(username, password);
			//System.out.println(policeStationService.(username, password)+" validating admin");
			if(policeStation != null)
			{
				hs.setAttribute("policeStation", policeStation);
				System.out.println(hs.getAttribute("policeStation"));
			}
			else {
				throw new PoliceStationException("Could not login, please try again");
			}
			return new ResponseEntity<PoliceStation>(policeStation, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Police login failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/addCriminal")
	public ResponseEntity<?> addCriminal(Criminal criminal, Photo photo) {
		System.out.println("in add police station");
		try {
			boolean stat = policeStationService.addCriminal(criminal, photo);
			if(stat)
				return new ResponseEntity<Criminal>(HttpStatus.OK);
			else 
				throw new PoliceStationException("Criminal registration failed, please try again");
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Criminal registration failed due to some reason. Please try again.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getComplaints")
	public ResponseEntity<?> getAllPoliceComplaint(PoliceStation policeStation) throws PoliceStationException {
		System.out.println("in police station : all police station complaints");
		try {
			HttpSession hs = req.getSession();
			AddressPoliceStation addrPoliceStation  = policeStation.getPs_address();
			Integer pincode = addrPoliceStation.getPincode();
			List<Complaint> list = policeStationService.getAllComplaints(pincode);
			if(list != null)
			{
				hs.setAttribute("policeStation", policeStation);
				System.out.println(hs.getAttribute("policeStation"));
			}
			else {
				System.out.println(hs.getAttribute("policeStation"));
				throw new PoliceStationException("Could not get complaints, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/viewPoliceComplaint")
	public ResponseEntity<?> viewComplaint(PoliceStation policeStation,Complaint complaint) throws PoliceStationException{
		System.out.println("in police station : view complaint ");
		try {
			HttpSession hs = req.getSession();
			Integer complaint_id = complaint.getComplaint_id();
			Complaint com = policeStationService.viewComplaint(complaint_id);
			if(com != null)
			{
				hs.setAttribute("policeStation", policeStation);
				System.out.println(hs.getAttribute("policeStation"));
			}
			else {
				System.out.println(hs.getAttribute("policeStation"));
				throw new PoliceStationException("Could not get complaint, please try again");
			}
			return new ResponseEntity<PoliceStation>(policeStation, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/changeComplaintStatus")
	public ResponseEntity<?> changeComplaintStatus(PoliceStation policeStation,Complaint complaint, String status) throws PoliceStationException{
		System.out.println("in police station : change complaint status");
		try {
			HttpSession hs = req.getSession();
			Integer complaint_id = complaint.getComplaint_id();
			boolean stat = policeStationService.changeComplaintStatus(complaint_id, status);
			if(stat)
			{
				hs.setAttribute("policeStation", policeStation);
				System.out.println(hs.getAttribute("policeStation"));
			}
			else {
				System.out.println(hs.getAttribute("policeStation"));
				throw new PoliceStationException("Could not change commplaint status, please try again");
			}
			return new ResponseEntity<PoliceStation>(policeStation, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/assignCriminalToComplaint")
	public ResponseEntity<?> assignCriminalToComplaint(PoliceStation policeStation, Complaint complaint, Criminal criminal) throws PoliceStationException
	{
		System.out.println("in police station : change complaint status");
		try {
			HttpSession hs = req.getSession();
			Integer complaint_id = complaint.getComplaint_id();
			Integer criminal_id = criminal.getCriminalId();
			boolean stat = policeStationService.criminalAssignToComplaint(complaint_id, criminal_id);
			if(stat)
			{
				hs.setAttribute("policeStation", policeStation);
				System.out.println(hs.getAttribute("policeStation"));
			}
			else {
				System.out.println(hs.getAttribute("policeStation"));
				throw new PoliceStationException("Could not assign complaint to criminal, please try again");
			}
			return new ResponseEntity<PoliceStation>(policeStation, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
}
