package com.planittesting.bma;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*Create a Consultant class that extends the Employee class
Has the boolean attribute of assigned
the constructor will take Name and startDate as input
A method getDisplayText that returns a string in the form of "fullName , assigned, startDate“
*/


public class Consultant extends Employee{
	
	private boolean assigned;
	
	  public boolean isAssinged() {
	        return assigned;
	    }
	    
	    
	    
	    public void setAssigned(boolean assigned) {
	        this.assigned = assigned;
	    }
	    
	
	
  public Consultant(String fullName, LocalDate startDate) {
  	this.setStartDate(startDate);
  	
		this.setFullName(fullName);
	}





	public Consultant(String fullName) {
		// TODO Auto-generated constructor stub
	}



	public String getDisplayText() {
      return getFullName() + getStartDate() +isAssinged() + getHours() ;
             
  }


 
	
	@Override
  public String toString() {
      return " Full Name: " + getFullName() + ", Start Date: " + getStartDate() + ", Assigned: " 
              + isAssinged()  + ", Hours: " +getHours()  ;
	
	


	
}

}
