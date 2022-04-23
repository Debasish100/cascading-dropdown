package com.example.demo.MainEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private int cid;
	private String countryname;
	
	
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	
	
	

}
