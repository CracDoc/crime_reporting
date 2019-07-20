package com.crime_report.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "tbl_address_police_station")
public class AddressPoliceStation {


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ps_addr_id", updatable = false, nullable = false,unique = true)
	@GenericGenerator(name = "ps_gen", strategy = "foreign", parameters = {
			@Parameter(name = "ps_property", value = "addr_police_station") })
	private Integer address_id;
	@Column(name = "flat_no")
	private String flat_no;
	@Column(name = "street")
	private String street;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private Integer pincode;
	
	
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getFlat_no() {
		return flat_no;
	}
	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "AddressPoliceStation [address_id=" + address_id + ", flat_no=" + flat_no + ", street=" + street
				+ ", landmark=" + landmark + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
	
	
	
}
