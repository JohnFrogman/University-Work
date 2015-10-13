// 			    Prime User					//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class will instantiate an instance 	//
// of PrimeChecker, with parameters read 	//
// from the user, then print out the primes	//
// found.									//
// 											//

import java.util.Scanner;
public class PrimeUser
{
	public static void main(String [] args)
	{
		// Declaring variables, the upper and lower bounds are to  be  taken in as ints, the scanner is instantiated and the input variable declared as an integer.
		String output;
		int input;
		int lowerBound;
		int upperBound;
		boolean running = true;

		Scanner in = new Scanner(System.in);
		// Hello welcome to Prime User etc
		System.out.println("Welcome to PrimeUser, this program will find all prime numbers between the two numbers you input.");
	
		while (running)	
		{
			try
			{
				// Lower bound read
				System.out.println("Please input the lower bound.");	
				lowerBound = in.nextInt();
		
				//Checks for an input less than 2 and closes the program if it detects such an input
				running = runCheck(lowerBound);
				if (!running)
				{
					System.out.println("Input less than 2 detected. PrimeUser closing.");
					System.exit(0);
				}
				else
				{
					// Upper bound read
					System.out.println("Please input the upper bound. Any output less than two will close the program.");	
					upperBound = in.nextInt();
			
					//Checks for an input less than 2 and closes the program if it detects such an input
					running = runCheck(upperBound);
					if (!running)
					{
						System.out.println("Input less than 2 detected. PrimeUser closing.");
						System.exit(0);
					}
					else
					{
						//Instantiating the PrimeChecker and running the prime checking method, then printing out a string with all the primes on it.
						PrimeChecker primeChecker = new PrimeChecker(lowerBound, upperBound);
						System.out.println("Calculating");
						output = primeChecker.printPrimes();
					
						//Quick check to see if there are any primes found, if there aren't then an empty string wont be outputted any more.
						if (output.equals(""))
						{
							System.out.println("No primes were found between your bounds");
						}
						else	 
						{
							System.out.println(output);
						}
					}
				}
			}	
			// This is here here to catch any invalid inputs, strings and such.
			catch (Exception e) 
			{	
				System.out.println("You have entered an invalid input, the program will now close.");
				System.exit(0);
			}
		
		}
	}

	//Static method to check if the program should stop running, rather than putting it in the code above.	
	private static boolean runCheck(int number)
	{
		if (number<2)
			return false;
		else 
			return true;
	}
}
