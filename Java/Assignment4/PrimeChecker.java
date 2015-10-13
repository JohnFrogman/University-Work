// 			    Prime Checker				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class will create an object, with	//
// parameters corresponding to an upper and	//
// lower bound, then return a string 		//
// containing each prime number found 		//
// between those two bounds. 				//
// 											//

public class PrimeChecker
{
	//the variables for the class, just the upper and lower bound to check between.
	private int upperBound;
	private int lowerBound;

	// Constructor for the class, when invoked will set the upper and lower bound.
	public PrimeChecker(int lowerBound, int upperBound)
	{
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	// Method to check for primes, it will return a string with a full list of primes within.
	public String printPrimes()
	{
	//Checking for invalid integer inputs for the bounds.
		if (upperBound<lowerBound)
		{
			return "You can't have a lower bound larger than the upper bound";
		}
		
		// Iterates through each number in between the lower and upper bounds, calling the IsPrime method for each value of i.	
		String primes = "";
		for (int i = lowerBound; i <= upperBound; i++)
			{
				if (isPrime(i))
				{
					primes += i + ", ";
				}
			}
				return primes;
	}

	// Separate prime check method to confuse me less. If a number will divide exactly into any number
	// below itself then it isn't a prime and the method will return false. Otherwise is will return true.
	
	// The loop stops at half the number's value as above that none of the inputs can
	// possibly return a zero value by definition, this is a very simple way to cut down
	// the calculation time. 
	private boolean isPrime(int number)
	{
		for (int i = 2; i < number/2+1; i++) 
		{
			if (number%i==0)
			{
				return false;
			}	
		}
		return true;
	}
}