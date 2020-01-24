# Java extended exercises

## To test the below exercises

The code to test your solution actually works is stored in this repository.  You need to run the class  BMA.src.com.planittesting.gui.GUIBenchManager

To fully test your solution

### Add consultant

- Click add button to add a new consultant
- Click Remove and remove a consultant

### Assign Consultant

- Click Assign enter the consultant name
  - Click the Assign check box
  - Click the Assign button
  - Make sure the consultant you entered has the Assigned value of true

### Unassign Consultant

- Click Assign enter the consultant name
  - Click the Assign button
  - Make sure the consultant you entered has the Assigned value of false

### Add hours

- Click Add time  
  - Enter a consultant name
  - Enter hours
  - Click on the Add button
  - Find the consultant in the list and click on it
  - Ensure that the Hours field is correct

## Task 1

- Create an Employee Class that
  - Has the string attribute of fullName
  - Has the integer attribute of hours
  - Has the localdate attribute of startDate
  - create the appropriate getters and setters

- Create a Consultant class that extends the Employee class
  - Has the boolean attribute of assigned
  - the constructor will take Name and startDate as input
  - A method getDisplayText that returns a string in the form of "fullName , assigned, startDate"

- Create a BenchManager class that also extends Employee class
  - the constructor will take Name and startDate as input
  - A method getDisplayText that returns a string in the form of "fullName , startDate"

- Create a BenchManagerApplication class that implements iBenchManagerApplication

## Task 2

- Extend the Employee class to include address fields
  - the address fields should be held in their own class.
  - Modify the getDisplayText routines to include the newly created addresses