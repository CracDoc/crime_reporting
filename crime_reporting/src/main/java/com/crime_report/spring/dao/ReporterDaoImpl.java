package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crime_report.spring.model.AddressReporter;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;
@CrossOrigin
@Repository
public class ReporterDaoImpl implements IReporterDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Reporter getLoginReporter(Integer username, Date password) {
		return session.getCurrentSession().createQuery("select repo from Reporter where repo.repo_aadhar_no:username and repo.D_O_B :password",Reporter.class )
		.setParameter("username", username)
		.setParameter("password",password)
		.getSingleResult();
		
	}

	@Override
	public void registerReporter(Reporter register_rep) {
	
		System.out.println(register_rep);
		session.getCurrentSession().save(register_rep);
	}

	@Override
	public String registerComplaint(Complaint complaint_raise) {
		
		session.getCurrentSession().save(complaint_raise);
		return "Complaint Register Succesfully";
	}

	@Override
	public List<Complaint> getReporterComplaint(String repo_aadhar_no) {
		
		List<Complaint> list = (List<Complaint>) session.getCurrentSession().createQuery("select comp from Complaint where comp.repo_aadhar_no: complaint",Complaint.class)
		.setParameter("repo_aadhar_no", repo_aadhar_no)
		.getResultList();
			return list;
	}

	@Override
	public Complaint complaintStatus(Integer complaint_id) {
		 return  session.getCurrentSession().createQuery("select complaint_status from Complaint where com.complaint_id: stat",Complaint.class)
		.setParameter("stat", complaint_id)
		.getSingleResult();
	
	}

	@Override
	public Integer changeAddress(String flat_no, String street, String landmark, String city, Integer pincode, Integer address_id) {
		 Query q = session.getCurrentSession().createQuery("update AddressReporter a SET a.falt_no = :flat_no and a.street:street and a.landmark:landmark and a.city:city and a.pincode:pincode WHERE a.address_id:address_id",AddressReporter.class)
				.setParameter("flat_no", flat_no)
				.setParameter("street", street)
				.setParameter("landmark", landmark)
				.setParameter("city", city)
				.setParameter("pincode", pincode);
		return q.executeUpdate();
			
		
	}


}
