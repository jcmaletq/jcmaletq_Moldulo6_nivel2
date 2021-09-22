package com.jobs.domain;

//para tener una tabla centralizada y no en el código de maximos y minimos
import java.util.HashMap;

public class max_min {
	private static 	HashMap<String, Double> maxmin = new HashMap<String, Double>();
	public max_min () {
		maxmin.put ("Boss_max", 80000.0);
		maxmin.put ("Boss_min",8000.0);
		maxmin.put ("Manager_min",3000.0);
		maxmin.put ("Manager_max",5000.0);
		maxmin.put ("Senior_min",2700.0);
		maxmin.put ("Senior_max",4000.0);	
		maxmin.put ("Midi_min",1800.0);
		maxmin.put ("Midi_max",2500.0);		
		maxmin.put ("Junior_max", 1600.0);
		maxmin.put ("Junior_min",900.0);


 }
	public double getmaxmin (String k) {
		return maxmin.get(k);
	}
}
