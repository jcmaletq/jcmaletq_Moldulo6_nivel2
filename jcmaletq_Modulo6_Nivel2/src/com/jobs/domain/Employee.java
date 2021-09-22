package com.jobs.domain;

public class Employee extends AbsStaffMember {
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}
	public Boolean salaryValidation (double min, double max) {
	double salarybyyear;
	boolean interm;
	salarybyyear= paymentRate.pay(salaryPerMonth)*12;
	if(salarybyyear > min && salarybyyear < max) {
		interm = true;
	  } else {
		System.out.println("salario informado :"+salaryPerMonth+" calculado % mensual "+paymentRate.pay(salaryPerMonth)+" total anual "+salarybyyear );  
		interm = false;
	  }
		return interm	;
	}
	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}


	@Override
	public String toString() {
//		return "Employee [salaryPerMonth=" + salaryPerMonth + ", paymentRate=" + paymentRate + ", id=" + id + ", name="
//				+ name + ", address=" + address + ", phone=" + phone + ", totalPaid=" + totalPaid + "]";
		return this.getClass().toString().replace("class com.jobs.domain.","") +
				" [id= " + id +
				", name= "+ name +
				", address= " + address +
				", phone= " + phone +
				", salaryPerMonth= " + salaryPerMonth + 
			//	", paymentRate=" + paymentRate +  				 
				", totalPaid= " + totalPaid + "]"+ 
			    " \n";
    }
		
}
