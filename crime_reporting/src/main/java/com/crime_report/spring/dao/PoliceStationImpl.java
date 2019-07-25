package com.crime_report.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;

public class PoliceStationImpl implements IPoliceStationDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Admin getAuthenticateAdmin(Integer ps_id, String username, String password) {
		return session.getCurrentSession().createQuery("select admin from Admin where admin.username:username and admin.password:password and admin.ps_id:ps_id",Admin.class )
				.setParameter("username", username)
				.setParameter("password",password)
				.setParameter("ps_id",ps_id)
				.getSingleResult();
		
	}

	@Override
	public String addCriminal(Criminal criminal) {
		session.getCurrentSession().save(criminal);
		return "Criminal added Succesfully";
	}

	@Override
	public Complaint viewComplaint(Integer complaint_id) {
		return session.getCurrentSession().createQuery("select comp from Complaint where comp.complaint_id:complaint_id", Complaint.class)
				.setParameter("complaint_id", complaint_id)
				.getSingleResult();
	}

	@Override
	public Integer changeComplaintStatus(Integer complaint_id, String status) {
		Query q = session.getCurrentSession().createQuery("update c from Complaint set c.status:status where c.complaint_id:complaint_id", Complaint.class)
				.setParameter("status", status)
				.setParameter("complaint_id", complaint_id);
		return q.executeUpdate();
	}

	@Override
	public boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id) {
		//use procedure for mapping
		 
		return false;
	}

	@Override
	public List<Complaint> getAllComplaints(String pincode) {
		List<Complaint> list = session.getCurrentSession().createQuery("select comp from Complaint where comp.pincode:pincode",Complaint.class)
				.setParameter("pincode", pincode)
				.getResultList();
		return list;
		
	}
}
