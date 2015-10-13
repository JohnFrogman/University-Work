// 			  PrimeArrayChecker				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class uses an array of booleans  	//
// initially all set to true and using 		//
// Eratosthenes' sieve it sets the values 	//
// that correspond with no prime numbers to	//
// false.									//
//											//

import java.util.Arrays;

public class PrimeArrayChecker
{
	private boolean[] isPrime;
	private int upperBound;
	private int input;
	
	// In the constructor the length of the array is specified, as the checks start from 
	// two rather than one the length of the array is set to one less than the input.
	// The upper bound of the check is set to the square root of the array's length, as 
	// no prime number can exist beyond this point.
	public PrimeArrayChecker(int input)
	{
		this.input = input;
		isPrime = new boolean[input-1];
		Arrays.fill(isPrime, Boolean.TRUE);
		upperBound = (int)Math.sqrt((double)input);
	}
	
	// Eratosthenes' Sieve
	public void getPrimes()
	{
		// i starts at 2 and checks up to the upper bound
		for (int i = 2; i<=upperBound; i++)
		{
			// If the boolean corresponding with i, is true, then execute the prime check.
			// The index of the boolean is smaller than the integer is corresponds to by 
			// two due to the array index starting at zero.
			if (isPrime[i-2])
			{
				// j corresponds to each value above 2 up to the length of the array, j is initialised at
				// i+1 to stop i from being set to false.
				for (int j = i+1; j <= input; j++)
				{
					// if j will divide exactly by i then it cannot be a prime number.
					if (j%i == 0)
					{	
						// j has two taken off it as its value is always two larger than the index corresponding to it.
						isPrime[j-2] = false;
					}
				}
			}
		}
	}
	
	// Prints all the primes using a StringBuilder. The StringBuilder is much faster than the standard String class for this method.
	public void printPrimes()
	{	
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input-1; i++)
		{
			if (isPrime[i])
			{
				output.append(i+2 + ", ");
			}
		}
		System.out.println("Primes found were: " + output);
	}
} 