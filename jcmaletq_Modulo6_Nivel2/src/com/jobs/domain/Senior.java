package com.jobs.domain;
public class Senior extends Employee{
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	public Senior (String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone,salaryPerMonth,paymentRate);		
	}
}
