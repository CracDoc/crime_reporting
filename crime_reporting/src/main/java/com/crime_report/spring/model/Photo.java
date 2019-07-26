package com.crime_report.spring.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
public class Photo {
	
	    private long ph_id;
	    private String fileName;
	    private byte[] data;
	    private Criminal criminal;


		@Id
	    @GeneratedValue
	    @Column(name = "ph_id")
	    public long getId() {
	        return ph_id;
	    }
	 
	    public void setId(long id) {
	        this.ph_id = id;
	    }
	 
	    @Column(name = "p_file_name")
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
	 
	    public void setData(byte[] data) {
	        this.data = data;
	    }

	    @OneToOne(mappedBy = "ph")
		public Criminal getCriminal() {
			return criminal;
		}

		public void setCriminal(Criminal criminal) {
			this.criminal = criminal;
		}

		@Override
		public String toString() {
			return "Photo [ph_id=" + ph_id + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + "]";
		}
	    
	    

}
