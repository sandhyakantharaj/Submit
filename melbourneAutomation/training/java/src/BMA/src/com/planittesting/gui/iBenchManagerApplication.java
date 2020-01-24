package com.planittesting.gui;

import java.util.ArrayList;

import com.planittesting.bma.Employee;

public interface iBenchManagerApplication {

    /**
     * The getEmployee method have to return the corresponding consultant searching by the fullName.
     * In order to avoid mismatches due capital letters a comparison with ignore case shall be used.
     *
     * @param fullName: The fullName of the consultant being searched
     * @return An Consultant object that matches the corresponding name, if not found should return null.
     */
    Employee getEmployee(String fullName);

    /**
     * The getHoursAverage method return the calculation of the avergage of hours per consultant for the 4 consultants
     * that the BMA have available.
     *
     * @return A double value with the Average
     */
    double getHoursAverage();


    /**
     * Method that returns the busiest consultant that the BMA has.
     * The definition of busiest consultant is the person with the most worked hours.
     * If there is a draw in worked hours then the first one shall be returned.
     *
     * @return Consultant: An object of the Consultant that meets the condition.
     */
    Employee getBusiestEmployee();
    /**
     * Method that returns the number of consultants that are available.
     * The consultant is available if the corresponding attribute is true.
     *
     * @return int -> The number of available consultants
     */
    int getNumberOfEmployeeAvailable();

    /**
     * Method that returns the LESS busiest consultant that the BMA has.
     * The definition of busiest consultant is the person with the most worked hours.
     * If there is a draw in worked hours then the first one shall be returned.
     *
     * @return Consultant: An object of the Consultant that meets the condition.
     */

    Employee getLessBusyEmployee();

    /**
     * Methods that adds a number of hours worked to a specific consultant
     * The criteria of choosing the consultant is the full name
     * After adding the corresponding hours the method should return the
     * new total hours worked of the consultant.
     *
     * @param fullname The full name of the consultant, the comparison must be done ignoring Upper/Lower case
     * @param hours    The hours to be added to the consultant
     * @return int, The new value for worked hours for the consultant
     */

    int addWorkHoursToEmployee(String fullname, int hours);

    /**
     * Method that allows to change the consultant assigned mark by his name
     * The criteria of choosing the consultant is the full name,
     * the comparison must be done ignoring Upper/Lower case
     *
     * @param fullName The full name of the consultant
     * @param assign   Boolean mark of the consultant being assigned to client
     * @return boolean, indicating the new assigned state of the Consultant
     */
    boolean assignEmployee(String fullName, boolean assign);

    /**
     * Remove employee method allows the Bench Manager Application to delete one employee from its consultants
     * @param fullName The Fullname of the employee to be removed
     * @return Boolean meaning if the deletion was successful
     */
    boolean removeEmployee(String fullName);

    /**
     * The add method allows to include a new employee in the bench manager application
     * @param fullName The fullname of the employee
     * @param joinDate The join date to the company of the employee
     * @return Boolean meaning if teh new enrollment was successful
     */
    boolean addEmployee(String fullName, String joinDate);

    /**
     * Returns the employee collection of the Bench Manager Application
     * @return ArrayList with all the current employees
     */
  //  System.out.println(newConsultant);
    ArrayList getEmployees();
   //ArrayList.getDisplay();

    String getTotalSalary();

    String getBMSalary();

	
	//boolean addConsultant(String fullName, String joinDate);
}
