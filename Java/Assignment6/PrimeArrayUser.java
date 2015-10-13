// 			   PrimeArrayUser				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class takes an input from the user	//
// then using PrimeArrayChecker it finds	//
// each prime number between 2 and the 		//
// input.									//
//											//

import java.util.Scanner;
public class PrimeArrayUser
{
	public static void main(String [] args)
	{
		// Declaring the input variable and displaying the welcome message.
		int input;
		System.out.println("Welcome to PrimeUser, this program will find all prime numbers up to the number you input.");
		
		while (true)
		{
			try 
			{
				Scanner in = new Scanner(System.in);
				System.out.println("Please input the numbers up to which you want primes printed. Any input less than 2 will close the program.");	
				input = in.nextInt();
				
				// Breaks the loop, closing the program if a value less than 2 is input.
				if (input < 2) 
				{
					System.out.println("Exiting.");
					break;
				}
				
				// Instantiates the PrimeArrayChecker and immediately begins checking for primes.
				// After this the print primes method displays all primes found on the page.
				PrimeArrayChecker primes = new PrimeArrayChecker(input);
				primes.getPrimes();
				System.out.println("Calculating...");
				primes.printPrimes();
			}
			// Catching invalid inputs
			catch (Exception e)
			{
				System.out.println("Invalid output detected, please try again.");
			}
		}
		
	}
}