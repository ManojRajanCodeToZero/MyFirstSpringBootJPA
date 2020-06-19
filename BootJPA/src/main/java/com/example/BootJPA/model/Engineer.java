package com.example.BootJPA.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engineer {

	@Id
	private int eid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteLang() {
		return eLang;
	}
	public void seteLang(String eLang) {
		this.eLang = eLang;
	}
	private String eName;
	private String eLang;
	@Override
	public String toString() {
		return "Engineer [eid=" + eid + ", eName=" + eName + ", eLang=" + eLang + "]";
	}
	
	
	
	
	
		
}
