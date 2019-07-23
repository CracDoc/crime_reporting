package com.crime_report.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_criminal_photos")
public class Photo {
	
	    private long id;
	    private String fileName;
	    private byte[] data;
	    private Criminal ph_id;
	 

		@Id
	    @GeneratedValue
	    @Column(name = "p_file_id")
	    public long getId() {
	        return id;
	    }
	 
	    public void setId(long id) {
	        this.id = id;
	    }
	 
	    @Column(name = "p_file_name", length = 20)
	    public String getFileName() {
	        return fileName;
	    }
	 
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	    
	    @Column(name = "p_file_data")
	    public byte[] getData() {
	        return data;
	    }
	 
	    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ph_id")
	    public Criminal getPh_id() {
			return ph_id;
		}

		public void setPh_id(Criminal ph_id) {
			this.ph_id = ph_id;
		}

		public void setData(byte[] data) {
	        this.data = data;
	    }

}
