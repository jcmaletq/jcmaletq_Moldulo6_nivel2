package com.jobs.domain;

public class Boss extends Employee{
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	public Boss (String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone,salaryPerMonth,paymentRate);	
	}
}
