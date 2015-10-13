//
// Alexander Hayes
// University of Liverpool
//
// This class takes a user's input of their gender  
// and age and calculates the pension due to them.
//

import java.util.Scanner;

public class PensionUser

{
	public static void main(String [] args)
	{
	//instantiating objects and welcome message. 
	Scanner in = new Scanner(System.in);
	Pension user = new Pension();
	
	//taking gender input
	System.out.print("Welcome to PensionUser, please input your gender, M for male and F for female. Do not include any spaces. ");

	String genderInput = in.nextLine();
	user.setGender(genderInput);
		
	//checks if gender is valid	
	boolean check = user.genderCheck(genderInput);

		if (!check) 				
			System.out.print("You have entered an undefined gender, program will now close. ");
		else
		{
	
		//inputting user's age
			System.out.print("Welcome " + user.gender + " user, please input your age ");
			
		//attempting a try catch statement to catch incorrect inputs as I couldn't think of a way to do this with if statements.
try {
			String input = in.nextLine();
			double ageInput = Double.parseDouble(input);
			user.setAge((int)ageInput);
			}
			catch (Exception e) 
				{
				System.out.print("You have entered an undefined age, program will now close.");
				System.exit(0);
				}
		//checks if age is too much and throws back you back if it is invalid.
			int pension = user.CalculatePension();
			if (pension == 0)
			System.out.print("You are under pensionable age. ");
			else 
			System.out.print("You are entitled to $" + user.CalculatePension() + " per week ");
		}
	}
}