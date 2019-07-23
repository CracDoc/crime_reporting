package com.crime_report.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;

public class ReporterDaoImpl implements IReporterDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Reporter getLoginReporter(Integer username, String password) {
		
		session.getCurrentSession().createQuery("select repo from Reporter where repo.repo_aadhar_no:username and repo.D_O_B :password",Reporter.class )
		.setParameter("username", username)
		.setParameter("password",password)
		.getSingleResult();
		return null;
	}

	@Override
	public void registerReporter(Reporter register_rep) {
	
		System.out.println(register_rep);
		session.getCurrentSession().save(register_rep);
	}

	@Override
	public String registerComplaint(Complaint complaint_raise) {
		return null;
	}

	@Override
	public List<Complaint> getReporterComplaint(String reporter_id) {
		
		
		return null;
	}

	@Override
	public String complaintStatus(Complaint complaint_id) {
		return null;
	}


}
