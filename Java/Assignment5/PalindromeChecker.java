// 			   Palindrome User				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// 	This class will take a string and 		//
// 	clear any non alphanumeric characters	//
// 	It can then be used to see if the 	 	//
// 	string is a palindrome.					//
// 											//
//											//

public class PalindromeChecker
{
	private String input;
	private String oInput;
	private int stringLength;
	
	//Constructor that converts the string to uppercase, while deleting all non alphabetic characters
	public PalindromeChecker(String oInput)
	{
		this.oInput = oInput;
		input = oInput.replaceAll("[^a-zA-Z0-9]", "" );
		input = input.toUpperCase();
		stringLength = input.length();
		
		//If everything is deleted then the input defaults to 
		if (stringLength==0)
			{
			input = "default";
			stringLength = input.length();
			}
	}
	
	public boolean isPalindromeRecursive()
	{
		return isPalindromeRecursive(input);
	}
	
	//Palindrome check that uses recursion, if the length is less than 2 then the string is either blank or a single character long,
	//A single character is a palindrome and a blank input will appear when the length of the string being checked is even.
	private boolean isPalindromeRecursive(String str)
	{
		int length = str.length();
		if (length==0 || length == 1)
		{
			return true;
		}
		
		//If the characters at the start and the end are the same then the string may still be a palindrome. From this
		//I take a substring with the checked characters deleted and call the method again.
		else if (str.charAt(0) != str.charAt(length-1))
		{	
			return false;
		}
		//if the length is not less than two and the characters are not equal then the string cannot be a palindrome.
		else 
		{
			return isPalindromeRecursive(str.substring(1, length-1));
		}
	}


	//Palindrome check that uses a loop
	public boolean isPalindromeIterative()
	{
		int x = 0;
		//if the string is a palindrome then x will increase with every pass of the loop, leaving the value as the length of the string.
		//iterates through each character in the string to see if it is symmetric
		//1 is taken from the stringlength as string length does not correspond exactly to the indexes of the string
		for (int i = 0; i<stringLength; i++)
		{
			if (input.charAt(i) == (input.charAt(stringLength-i-1)))
			{
				x++;
			}
		}
	
		if (x==stringLength)
		{
			return true;
		}
	
		else 
		{
			return false;
		}
	}
	
	// I used this for debugging, it just prints out the variables to show where things are going wrong.
	public String printVariables()
	{
	String debug = oInput + " " + input + " " + stringLength;
	return debug;
	}
}	