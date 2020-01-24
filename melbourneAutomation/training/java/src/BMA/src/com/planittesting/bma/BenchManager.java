package com.planittesting.bma;

import java.time.LocalDate;


/*Create a BenchManager class that also extends Employee class
the constructor will take Name and startDate as input
A method getDisplayText that returns a string in the form of "fullName , startDate“
*/



public class BenchManager extends Employee {
	
	public BenchManager(String fullName, LocalDate startdate) {
		
	}

	
	public String getDisplayText() {
		 return getFullName() + getStartDate();
		
		
	}
	
}
