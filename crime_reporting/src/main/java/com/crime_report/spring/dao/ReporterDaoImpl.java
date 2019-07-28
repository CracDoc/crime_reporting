package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Reporter;
@CrossOrigin

@Repository
public class ReporterDaoImpl implements IReporterDao {

	@Autowired
	private SessionFactory session;
	@Autowired
	private EntityManager em;
	
	@Override
	public Reporter getLoginReporter(Integer username, Date password) {
		return session.getCurrentSession().createQuery("select repo from Reporter repo where repo.repo_aadhar_no:username and repo.D_O_B :password",Reporter.class )
		.setParameter("username", username)
		.setParameter("password",password)
		.getSingleResult();
		
	}

	@Override
	public boolean registerReporter(String repo_name, String repo_aadhar_no, Date date_of_birth, String flat_no,  String street, String landmark, String city, Integer pincode, String primary_no, String secondary_no, String land_line) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("registerReporter");
		query.setParameter(1, repo_name);
		query.setParameter(2, repo_aadhar_no);
		query.setParameter(3, date_of_birth);
		query.setParameter(4, flat_no);
		query.setParameter(5, street);
		query.setParameter(6, landmark);
		query.setParameter(7, city);
		query.setParameter(8, pincode);
		query.setParameter(9, primary_no);
		query.setParameter(10, secondary_no);
		query.setParameter(11, land_line);
		if(query.execute())
			return true;
		return false;
	}

	@Override
	public boolean registerComplaint(String com_type, String com_status, String com_desc, Date com_date, String location, Integer pincode, Integer rp_id, Integer ps_id) 
	{
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("registerComplaint");
		query.setParameter(1, com_type);
		query.setParameter(2, com_status);
		query.setParameter(3, com_desc);
		query.setParameter(4, com_date);
		query.setParameter(5, location);
		query.setParameter(6, pincode);
		query.setParameter(7, rp_id);
		query.setParameter(8, null);
		if(query.execute())
			return true;
		return false;
		
	}

	@Override
	public List<Complaint> getAllReporterComplaint(Integer rp_id) {
		
		List<Complaint> list = (List<Complaint>) this.session.getCurrentSession().createQuery("select comp from Complaint comp where comp.rp_id: rp_id",Complaint.class)
		.setParameter("rp_id", rp_id)
		.getResultList();
			return list;
	}

	@Override
	public Complaint complaintStatus(Integer rp_id,Integer complaint_id) {
		 return this.session.getCurrentSession().createQuery("select comp from Complaint comp where comp.complaint_id: complaint_id and comp.rp_id:rp_id",Complaint.class)
		.setParameter("complaint_id", complaint_id)
		.setParameter("rp_id", rp_id)
		.getSingleResult();
	
	}

	@Override
	public boolean changeAddress(Integer rp_id, String flat_no, String street, String landmark, String city, Integer pincode) {
		
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("changeReporterAddress");
		query.setParameter(1, rp_id);
		query.setParameter(2, flat_no);
		query.setParameter(3, street);
		query.setParameter(4, landmark);
		query.setParameter(5, city);
		query.setParameter(6, pincode);
		if(query.execute())
			return true;
		return false;
	}


	@Override
	public boolean changeContact(Integer rp_id, String primary_no, String secondary_no, String land_line) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("changeReporterContact");
		query.setParameter(1, rp_id);
		query.setParameter(2, primary_no);
		query.setParameter(3, secondary_no);
		query.setParameter(4, land_line);
		if(query.execute())
			return true;
		return false;
	}


}
