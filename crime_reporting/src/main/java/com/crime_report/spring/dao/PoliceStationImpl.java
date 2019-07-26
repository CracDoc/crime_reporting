package com.crime_report.spring.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;

public class PoliceStationImpl implements IPoliceStationDao {

	@Autowired
	private SessionFactory session;
	@Autowired
	private EntityManager em;
	
	@Override
	public Admin getAuthenticateAdmin(Integer ps_id, String username, String password) {
		return session.getCurrentSession().createQuery("select admin from Admin admin where admin.username:username and admin.password:password and admin.ps_id:ps_id",Admin.class )
				.setParameter("username", username)
				.setParameter("password",password)
				.setParameter("ps_id",ps_id)
				.getSingleResult();
		
	}

	@Override
	public boolean addCriminal(String criminal_name, Date date_of_birth, String crime_commited, String cases_pending, Integer wanted_level, String p_file_name, Byte p_file_data ) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("registerCriminal");
		query.setParameter(1, criminal_name);
		query.setParameter(2, date_of_birth);
		query.setParameter(3, crime_commited);
		query.setParameter(4, cases_pending);
		query.setParameter(5, wanted_level);
		query.setParameter(6, p_file_name);
		query.setParameter(7, p_file_data);
		if(query.execute())
			return true;
		return false;
	}

	@Override
	public Complaint viewComplaint(Integer complaint_id) {
		return session.getCurrentSession().createQuery("select comp from Complaint comp where comp.complaint_id:complaint_id", Complaint.class)
				.setParameter("complaint_id", complaint_id)
				.getSingleResult();
	}

	@Override
	public Integer changeComplaintStatus(Integer complaint_id, String status) {
		Query q = session.getCurrentSession().createQuery("update c from Complaint c set c.status:status where c.complaint_id:complaint_id", Complaint.class)
				.setParameter("status", status)
				.setParameter("complaint_id", complaint_id);
		return q.executeUpdate();
	
		
		
	}

	@Override
	public boolean criminalAssignToComplaint(Integer complaint_id, Integer criminal_id) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("assignComplaintToCriminal");
		query.setParameter(1, complaint_id);
		query.setParameter(2, criminal_id);
		if(query.execute())
			return true;
		return false;
	
	}

	@Override
	public List<Complaint> getAllComplaints(String pincode) {
		List<Complaint> list = session.getCurrentSession().createQuery("select comp from Complaint comp where comp.pincode:pincode",Complaint.class)
				.setParameter("pincode", pincode)
				.getResultList();
		return list;
		
	}
}
