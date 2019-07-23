package com.crime_report.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;

@Repository
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
		
		session.getCurrentSession().save(complaint_raise);
		return null;
	}

	@Override
	public List<Complaint> getReporterComplaint(String repo_aadhar_no) {
		
		session.getCurrentSession().createQuery("select comp from Complaint where comp.repo_aadhar_no: complaint",Reporter.class)
		.setParameter("repo_aadhar_no", repo_aadhar_no)
		.getResultList();
		return null;
	}

	@Override
	public String complaintStatus(Complaint complaint_id) {
		session.getCurrentSession().createQuery("select complaint_status from Complaint where com.complaint_id: stat",Complaint.class)
		.setParameter("stat", complaint_id);
		return null;
	}


}
