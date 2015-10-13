// 			   Palindrome User				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// 	This class will take in a string input 	//
// 	from the user then instantiate a new 	//
// 	palindrome checker, it will then tell 	//
// 	the user whether their input is a 		//
// 	palindrome or not  						//
//											//

import java.util.Scanner;
public class PalindromeUser
{
	public static void main(String [] args)
	{
		// Declaring the initial variables
		String input = "";
		boolean running = true;
		Scanner in = new Scanner(System.in);
		
		//Opening text, will only display once.
		System.out.println("Welcome to PalindromeUser, this program will check if your input is a palindrome, with both a recursive method and a iterative method.");
	
		while (true)	
		{
			try
			{
				// Palindrome Read
				System.out.println("Please input your palindrome.");	
				input = in.nextLine();
		
				//Checks for an empty input by calling the run check method, if the input it blank the program will close
				if (!runCheck(input))
				{
					System.out.println("Empty input detected, program closing.");
					break;
				}
				
				//Instantiates and runs the palindrome check method, returning true if the string is palindrome
				
				//This means I don't have to call the isPalindrome method for each if condition.
				PalindromeChecker palindromeChecker = new PalindromeChecker(input);
				boolean recursion = palindromeChecker.isPalindromeRecursive();
				boolean iterative = palindromeChecker.isPalindromeIterative();
				System.out.println(input);
				
				if (recursion)
				{
					System.out.println("Recursive version: This is a palindrome");
				}
				else 
				{
					System.out.println("Recursive version: This is not a palindrome");
				}
							
				if (iterative)
				{
					System.out.println("Iterative version: This is a palindrome");
				}
				
				else
				{
					System.out.println("Iterative version: This is not a palindrome");
				}
				
				//This was here for debugging
				//System.out.println(palindromeChecker.printVariables());
				
			}	
			// This is here here to catch any invalid inputs, I don't think this should ever actually kick in.
			catch (Exception e) 
			{	
				System.out.println("You have entered an invalid input, the program will now close.");
				System.exit(0);
			}
			
		}
	}

	//Static method to check if the program should stop running, rather than putting it in the code above.	
	private static boolean runCheck(String run)
	{
		if (run.equals(""))
			return false;
		else 
			return true;
	}
}

	