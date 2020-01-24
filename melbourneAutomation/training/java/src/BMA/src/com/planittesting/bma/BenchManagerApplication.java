package com.planittesting.bma;
//package com.planittesting.gui;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.planittesting.gui.iBenchManagerApplication;

//Create a BenchManagerApplication class that implements iBenchManagerApplication

public class BenchManagerApplication implements iBenchManagerApplication {
	

ArrayList<Employee> newConsultant = new ArrayList<Employee>();

	
	@Override
	public boolean addEmployee(String fullName, String joinDate) {

	
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	        LocalDate localDate = LocalDate.parse(joinDate, formatter);
	 			Consultant AddConsultant=new Consultant(fullName, localDate);
				
				
					if(!fullName.isEmpty())
						{   
						newConsultant.add(AddConsultant);
			        	return true;
						}
					else {
				        JOptionPane.showMessageDialog(null, "Please fill all fields ! \n");
				        } 
				        	return false;
						
				}
			
	      
	        
	        
	
	 
	@Override
	public double getHoursAverage() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int addWorkHoursToEmployee(String fullname, int hours) {
		// TODO Auto-generated method stub
		for(int i = 0;i<newConsultant.size();i++) {
			Consultant cons = (Consultant) newConsultant.get(i);
			
			if(cons.getFullName().equals(fullname)) {
				cons.setHours(hours);
				
			}
		}
		return hours;
	}

	@Override
	public boolean assignEmployee(String fullName, boolean assign) {
		if(assign){
		for(int i = 0;i<newConsultant.size();i++) {
		Consultant cons = (Consultant) newConsultant.get(i);
		if(cons.getFullName().equals(fullName)) {
		cons.setAssigned(assign);
						}
		}
		return true;
	

	}
		else{
			for(int i = 0;i<newConsultant.size();i++) {
				Consultant cons = (Consultant) newConsultant.get(i);
				if(cons.getFullName().equals(fullName)) {
				cons.setAssigned(assign);
								}
				}
				return false;
			
		}
		
	}


	@Override
	public boolean removeEmployee(String fullName) {
		// TODO Auto-generated method stub
		
		for(int i = 0;i<newConsultant.size();i++) {
			// Consultant AddConsultant=new Consultant(fullName);
			 Consultant cons = (Consultant) newConsultant.get(i);
			
			if(cons.getFullName().equals(fullName)) {
				newConsultant.remove(i);
				
			}
		}
		
        return true;
    }
		
		

	@Override
	public ArrayList getEmployees() {
		// TODO Auto-generated method stub
	
		return newConsultant;
	}

	@Override
	public String getTotalSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBMSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfEmployeeAvailable() {

        int availableNum = 0;
        for(int i = 0;i<newConsultant.size();i++) {
        Consultant cons = (Consultant) newConsultant.get(i);
        if(!cons.isAssinged()) {
        	availableNum++;
        	
        }
		
    }
		//System.out.println(availableNum);
        return availableNum;

	}





	@Override
	public Employee getEmployee(String fullName) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Employee getBusiestEmployee() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Employee getLessBusyEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
