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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime_report.spring.model.AddressPoliceStation;
import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;
import com.crime_reporting.spring.exception.AdminException;
import com.crime_reporting.spring.exception.ReporterException;
import com.crime_reporting.spring.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpServletRequest req;
	
	public AdminController() {
		System.out.println("In admin controller");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getLogin(String username, String password) throws AdminException {
		System.out.println("in admin login");
		try {
			HttpSession hs = req.getSession();
			Admin admin = adminService.loginAdmin(username, password);
			System.out.println(adminService.loginAdmin(username, password)+" validating admin");
			if(admin != null)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				throw new AdminException("Could not login, please try again");
			}
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Admin login failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/addPoliceStation")
	public ResponseEntity<?> addPoliceStation(@RequestBody PoliceStation policeStation, @RequestBody AddressPoliceStation addrPoliceStation) {
		System.out.println("in add police station");
		try {
			boolean stat = adminService.addPoliceStation(policeStation, addrPoliceStation);
			if(stat)
				return new ResponseEntity<PoliceStation>(HttpStatus.OK);
			else 
				throw new AdminException("Police Station registration failed, please try again");
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Police Station registration failed due to some reason. Please try again.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	
	@PostMapping("/changePassword")
	public ResponseEntity<?> changeAddress(@RequestBody Admin admin,@RequestBody String password ) throws AdminException {
		System.out.println("in admin : change password");
		try {
			HttpSession hs = req.getSession();
			boolean ad = adminService.changeCredentials(admin, password);
			if(ad)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				System.out.println(hs.getAttribute("admin"));
				throw new AdminException("Could not change password, please try again");
			}
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Changing password failed due to some reason. Please try again.", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity<?> getAllComplaints(Admin admin) throws AdminException {
		System.out.println("in admin : all complaints");
		try {
			HttpSession hs = req.getSession();
			List<Complaint> list = adminService.viewAllComplaints();
			if(list != null)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				System.out.println(hs.getAttribute("admin"));
				throw new AdminException("Could not find complaints, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllCriminal")
	public ResponseEntity<?> getAllCriminals(Admin admin) throws AdminException {
		System.out.println("in admin : all criminal");
		try {
			HttpSession hs = req.getSession();
			List<Criminal> list = adminService.viewAllCriminals();
			if(list != null)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				System.out.println(hs.getAttribute("admin"));
				throw new AdminException("Could not find criminals, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllReporter")
	public ResponseEntity<?> getAllReporters(Admin admin) throws AdminException {
		System.out.println("in admin : all reporter");
		try {
			HttpSession hs = req.getSession();
			List<Reporter> list = adminService.viewAllReporters();
			if(list != null)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				System.out.println(hs.getAttribute("admin"));
				throw new AdminException("Could not find reporters, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllPoliceStation")
	public ResponseEntity<?> getAllPoliceStations(Admin admin) throws AdminException {
		System.out.println("in admin : all PoliceStation");
		try {
			HttpSession hs = req.getSession();
			List<PoliceStation> list = adminService.viewAllPoliceStations();
			if(list != null)
			{
				hs.setAttribute("admin", admin);
				System.out.println(hs.getAttribute("admin"));
			}
			else {
				System.out.println(hs.getAttribute("admin"));
				throw new AdminException("Could not find police stations, please try again");
			}
			return new ResponseEntity<List>(list, HttpStatus.OK); 
		}
		catch (NoResultException e) {
			return new ResponseEntity<String>("Something went wrong. Please try again.", HttpStatus.NOT_FOUND);
		}
	}

}
