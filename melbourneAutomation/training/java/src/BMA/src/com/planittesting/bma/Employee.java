package com.planittesting.bma;

import java.time.LocalDate;
import java.util.ArrayList;

//import com.planittesting.gui.Skill;



//Exercise 1: Create an Employee Class
//Update the Employee class to include address fields

public class Employee extends Address {
	
	//Has the string attribute of fullName
	 String fullName;
				
	//Has the integer attribute of hours
	 int hours;
				
	//Has the local date attribute of startDate
	  LocalDate startDate;
		
	

	//create the appropriate getters and setters
	  public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		
		public int getHours() {
			return hours;
		}

		public void setHours(int hours) {
			this.hours = hours;
		}
		
		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}



}
