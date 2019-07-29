package com.crime_report.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
	    @NamedStoredProcedureQuery(
	      name="changeCredentials",
	      procedureName="changeCredentials",
	    		  parameters = {
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "username"),
	    					@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "password")
	    			})


@Table(name = "tbl_admin")
public class Admin {
	
	@Id
	@Column(name = "username",nullable = false,length = 20)
	private String username;
	
	@Column(name = "password",nullable = false,length = 20)
	private String password;
	

	public Admin() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
	
}
