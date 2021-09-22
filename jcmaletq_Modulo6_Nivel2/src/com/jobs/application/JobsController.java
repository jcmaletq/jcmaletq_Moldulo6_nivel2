package com.jobs.application;

import java.util.ArrayList;
import java.util.List;
import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Boss;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.domain.Junior;
import com.jobs.domain.Senior;
import com.jobs.domain.Midi;
import com.jobs.domain.max_min;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	private	max_min maxmin = new max_min();
	public JobsController(){	
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Boss boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		double max,min;
		max = maxmin.getmaxmin("Boss_max");
		min = maxmin.getmaxmin("Boss_min");
		if (boss.salaryValidation(min,max)) {
			repository.addMember(boss);
		}
		else {
			throw new errorsalary(name,min,max);
		}
	}
/*	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee emp = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		double max,min;
		max = 4000;
		min = 2700;
		if (emp.salaryValidation(min,max)) {
			repository.addMember(emp);
		}
		else {
			throw new errorsalary(name,min,max);
		}		
	}
*/	
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Manager manager = new Manager(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		double max,min;
		max = maxmin.getmaxmin("Manager_max");
		min = maxmin.getmaxmin("Manager_min");
		if (manager.salaryValidation(min,max)) {
			repository.addMember(manager);
		}
		else {
			throw new errorsalary(name,min,max);
		}		
	}
	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Junior junior = new Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		double max,min;
		max = maxmin.getmaxmin("Junior_max");
		min = maxmin.getmaxmin("Junior_min");
		if (junior.salaryValidation(min,max)) {
			repository.addMember(junior);
		}
		else {
			throw new errorsalary(name,min,max);
		}		
	}
	public void createMidiEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Midi midi = new Midi(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMidi());
		double max,min;
		max = maxmin.getmaxmin("Midi_max");
		min = maxmin.getmaxmin("Midi_min");
		if (midi.salaryValidation(min,max)) {
			repository.addMember(midi);
		}
		else {
			throw new errorsalary(name,min,max);
		}		
	}
	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone,  description);
		repository.addMember(volunteer);
	}
	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Senior senior = new Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		double max,min;
		max = maxmin.getmaxmin("Senior_max");
		min = maxmin.getmaxmin("Senior_min");
		if (senior.salaryValidation(min,max)) {
			repository.addMember(senior);
		}
		else {
			throw new errorsalary(name,min,max);
		}		
	}	
	public void payAllEmployeers() {
		List<AbsStaffMember> miembros = this.repository.getAllMembers();
		for(AbsStaffMember m: miembros)
		{
			m.pay();
		}
	}

	public String getAllEmployees() {
		List<AbsStaffMember> miembros = this.repository.getAllMembers();
		return miembros.toString();
		
	}
	
}
class errorsalary extends Exception { 
	public errorsalary (String name, double min, double max) {  //(String message)
		super();
		System.out.println("El salario anual de "+name+ " debe ser superior a "+min+" e inferior a "+max);
//		System.out.println(message);
		}
}