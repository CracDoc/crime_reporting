package com.crime_report.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crime_report.spring.model.Admin;
import com.crime_report.spring.model.Complaint;
import com.crime_report.spring.model.Criminal;
import com.crime_report.spring.model.PoliceStation;
import com.crime_report.spring.model.Reporter;

@CrossOrigin

@Repository
public class AdminDaoImpl implements IAdminDao {
	
	@Autowired
	private SessionFactory session;
	
	@Autowired
	private EntityManager em;


	@Override
	public Admin loginAdmin(String username, String password) {
		return session.getCurrentSession().createQuery("select admin from Admin admin where admin.username:username and admin.password:password",Admin.class )
				.setParameter("username", username)
				.setParameter("password",password)
				.getSingleResult();
	}
	
	
	@Override
	public boolean addPoliceStation(String police_station_name,String flat_no,String street,String landmark,String city,Integer pincode,String username,String password) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("registerPoliceStation");
		query.setParameter(1, police_station_name);
		query.setParameter(2, flat_no);
		query.setParameter(3, street);
		query.setParameter(4, landmark);
		query.setParameter(5, city);
		query.setParameter(6, pincode);
		query.setParameter(7, username);
		query.setParameter(8, password);
		if(query.execute())
			return true;
		return false;
	}

	@Override
	public boolean changeCredentials(String username, String password) {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("changeCredentials");
		query.setParameter(1, username);
		query.setParameter(2, password);
		if(query.execute())
			return true;
		return false;
	}

	@Override
	public List<Complaint> viewAllComplaints() {
		List<Complaint> list = (List<Complaint>) this.session.getCurrentSession().createQuery("select comp from Complaint comp",Complaint.class)
				.getResultList();
					return list;
	}

	@Override
	public List<Criminal> viewAllCriminals() {
		List<Criminal> list = (List<Criminal>) this.session.getCurrentSession().createQuery("select crim from Criminal crim",Criminal.class)
				.getResultList();
		return list;
	
	}

	@Override
	public List<Reporter> viewAllReporters() {
		List<Reporter> list = (List<Reporter>) this.session.getCurrentSession().createQuery("select rep from Reporter rep",Reporter.class)
				.getResultList();
		return list;
	}

	@Override
	public List<PoliceStation> viewAllPoliceStations() {
		List<PoliceStation> list = (List<PoliceStation>) this.session.getCurrentSession().createQuery("select ps from PoliceStation ps",PoliceStation.class)
				.getResultList();
		return list;
	}


}
