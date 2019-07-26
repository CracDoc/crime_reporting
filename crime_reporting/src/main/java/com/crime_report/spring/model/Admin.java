package com.crime_report.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity

@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
	    name="registerPoliceStation",
	    procedureName="registerPoliceStation",
	    		parameters = {
  				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "police_station_name"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "flat_no"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "street"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "landmark"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "city"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "pincode"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "username"),
	    				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "password")
	    		}
	    ),
	    @NamedStoredProcedureQuery(
	      name="changeCredentials",
	      procedureName="changeCredentials",
	    		  parameters = {
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ps_id"),
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "username"),
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "password")
	    			})
} )


@Table(name = "tbl_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id",nullable = false, updatable = false)
	private Integer admin_id;
	
	@Column(name = "username",nullable = false,length = 20)
	private String username;
	
	@Column(name = "password",nullable = false,length = 20)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ps")
	private PoliceStation ps_id;
	

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PoliceStation getPs_id() {
		return ps_id;
	}

	public void setPs_id(PoliceStation ps_id) {
		this.ps_id = ps_id;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", username=" + username + ", password=" + password + ", ps_id=" + ps_id
				+ "]";
	}
	

	
	
}
