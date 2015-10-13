//
// Alexander Hayes
// University of Liverpool
//
// This class works in conjunction with PensionUser
// It handles the calculation of the pension and the 
// validity test for gender.
//
 
public class Pension

{
	//declaring the variables
	public String gender; 
	public int age;
	
	//sets the age from the user inputAge
	public void setAge(int inputAge) 
	{
	age = inputAge;
	}
	
	//Sets the gender from the user input also checks if the gender is valid by returning true when it's an invalid input.
	public void setGender(String inputGender) 
	{
	gender = inputGender.toUpperCase();
	}
	
	//returns true if gender is an accepted input
	public boolean genderCheck(String genderInput)
	{
	String input = genderInput.toUpperCase();

		if (input.equals("M")|| input.equals("MALE") || input.equals("F")|| input.equals("FEMALE"))
			return true;
		else 
			return false;
	}
	
	
	//Calculates the pension depending on gender and age.
	public int CalculatePension()
	{
		{ 
		if (gender.equals("M")||gender.equals("MALE")) 	 
							{
							if		(age>=65 && age<70)
									return 50;
							
							else if (age>=70)
									return 70;
							
							else 	
									return 0;	
							}		
						
		
		else if (gender.equals("F")|| gender.equals("FEMALE"))
							{
							if		(age>=60 && age<65)
									return 45;
							
							else if	(age>=65)
									return 70;
							
							else 	
									return 0;
							}	
		else 
		return 0;
		}
	}
	
	
}