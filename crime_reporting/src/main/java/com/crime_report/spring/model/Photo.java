package com.crime_report.spring.model;

import javax.persistence.*;

@Entity
public class Photo {
	
	    private long id;
	    private String fileName;
	    private byte[] data;
	    private Criminal crm;
	 


		@Id
	    @GeneratedValue
	    @Column(name = "FILE_ID")
	    public long getId() {
	        return id;
	    }
	 
	    public void setId(long id) {
	        this.id = id;
	    }
	 
	    @Column(name = "FILE_NAME")
	    public String getFileName() {
	        return fileName;
	    }
	 
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ph")
	    public Criminal getCrm() {
			return crm;
		}

		public void setCrm(Criminal crm) {
			this.crm = crm;
		}
	 
	    @Column(name = "FILE_DATA")
	    public byte[] getData() {
	        return data;
	    }
	 
	    public void setData(byte[] data) {
	        this.data = data;
	    }

}
