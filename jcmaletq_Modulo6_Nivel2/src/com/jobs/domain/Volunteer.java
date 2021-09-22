package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;	
	}
	
	private String description;
	@Override
	public void pay() {
		//TODO		
	}

	@Override
	public String toString() {
	return this.getClass().toString().replace("class com.jobs.domain.","") +
				" [id= " + id +
			", name= " + name + 
			", address= " + address +
			", phone= " + phone +
	        ", description= " + description + 
			", totalPaid= " + totalPaid + 
			"]"+ "\n";

	}
}
