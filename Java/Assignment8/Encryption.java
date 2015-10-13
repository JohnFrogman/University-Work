// 			   	 Encryption					//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class creates a matrix in it's 		//
// constructor. It can then encrypt a 		//
// string based on the matrix by calling 	//
// the encrypt method with the string as 	//
// the parameter.							//

public class Encryption
{
	// matrix will be used to encrypt the string and the letters will be used to populate the matrix
	private char[][] matrix = new char [5][5];
	
	// The ignored character and keyword are later removed from the alphabet stored here in order to
	// populate the matrix
	private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// q is used as a counter later to build the matrix
	private int q = 0;
	
	// These will be the coordinates of the character pairs to be encoded.
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	// Ignore is the character that will not be placed in the matrix that will remain unencrypted
	private char ignore;
	
	// The keyword is five letters long and populates the first row in the matrix.
	private String keyWord;
	
	//Constructor, takes the keyword and the ignored character then builds the matrix.
	public Encryption(String keyWord, char ignore) throws Exception
	{
	
	//												Matrix generation 
	//	{B,R,E,A,K}																														//
	//	{C,D,F,G,H}		In order to generate the matrix use in the the cipher first a keyword and ignored character must be chosen. The //
	//	{I,L,M,N,O}		keyword must be five letters long and is removed from the alphabet along with the character to be ignored, in 	//
	//	{P,Q,S,T,U}		example on the left the keyword is BREAK and the ignored character is 'J'. The keyword populates the top row of //
	//	{V,W,X,Y,Z}		the matrix then the rest of the rows are popluated by the remainder of the alphabet. J does not appear.			//
	
	
		// stringBuild will hold the letters that are neither the keyword or the ignored character. 
		StringBuilder stringBuild = new StringBuilder(letters);
		
		// Deletes irrelevant characters and converts to upper case. This can cause an error to be thrown later if hte keyword is of the wrong length.
		keyWord = keyWord.toUpperCase();
		keyWord = keyWord.replaceAll("[^A-Z]", "");
		ignore = Character.toUpperCase(ignore);
		
		this.ignore = ignore;
		this.keyWord = keyWord;
		
		// Throws an exception if the inputs are invalid.
		validityCheck(keyWord, ignore);
		
		// Removing ignored character from alphabet
		for (int p = 0; p < stringBuild.length(); p++) 
		{		
			if (stringBuild.charAt(p) == ignore)
			{
				stringBuild.deleteCharAt(p);
				break;
			}
		}
		
		// Removing keyword from the alphabet
		for (int s = 0; s < keyWord.length(); s++)
		{
			for (int y = 0; y < stringBuild.length(); y++)
			{
				if (stringBuild.charAt(y) == keyWord.charAt(s))
				{
					stringBuild.deleteCharAt(y);
					break;
				}
			}
		}
		letters = stringBuild.toString();
		
		// Populates the first row of the matrix with the keyword
		for (int h = 0; h < 5; h++)
			{
				matrix[0][h] = keyWord.charAt(h);
			}
			
		// Populates the rest of the matrix with the characters that remain in the alphabet.
		for (int t = 1; t < 5; t++)
		{
			for (int s = 0; s < 5; s++)
			{
				matrix[t][s] = letters.charAt(q);
				q++;
			}
		}
	}
	
	public String encrypt(String input)
	{
	
	//											How the cipher works, in plainer terms													//
	//	{B,R,E,A,K}																														//
	//	{C,D,F,G,H}		The string is split into pairs, for each pair we must first find the coordinates of each letter,				//
	//	{I,L,M,N,O}		for example, for the pair CO, the coordinates are (0,1) and (4,2). The x coordinates of the two letters			//
	//	{P,Q,S,T,U}		are then swapped, so for C the coordinate become (4,1) and for O the coordinates become (0,2). The character	//
	//	{V,W,X,Y,Z}	 	at the new coordinates is then used to encrypt the original character, so CO will become HI, H occurring at		//
	//					(4,1) in the matrix and I occurring at (0,2). In order for the grid to be square a character must be removed,	//
	//	this character will not be encrypted if it appears in the input. If the input has an odd length the final letter will also		//
	//	not be encrypted.																												//			
		
		// The final string will be returned, the string builder is used for the inner workings and is then converted to string at the end.
		String finalString = "";
		StringBuilder output = new StringBuilder();
	
		// The dollar is appended so that the program knows when to stop looping, without going out of bound in a loop.
		// For example if the string has an uneven length the final character will search for the character after it to encrypt
		// then afterwards it will iterate i beyond the bounds of the input string.
			
		input = input.toUpperCase();
		input = input.replaceAll("[^A-Z]", "");
		input +='$';
		int length = input.length();

		// The upper bound is set at length-1 as the i+1 can throw an error when the method tries to check an out of bound index
		for (int i = 0; i < length-1; i++)
		{
			// The character to be ignored
			if ((input.charAt(i) == ignore)||(input.charAt(i+1) == ignore))
			{
				output.append(input.charAt(i));
			}
			
			// Breaks the loop when the end of the string is reached.
			else if (input.charAt(i+1) == '$')
			{
				output.append(input.charAt(i));
				break;
			}
			//	Break character for an uneven string length.
			else  if (input.charAt(i) == '$')
			{
				break;
			}
			
			else 
			{
					// Searching through the matrix for the index of the first character
					// x is the x coordinate and y is the y coordinate of the character
					for (int x = 0; x < 5; x++)
					{
						for (int y = 0; y < 5; y++)
						{
							//Breaks the loop when the character is found
							if (matrix[x][y] == input.charAt(i))
							{
								x1 = x;
								y1 = y;
							}
						}
					}
					// Searching through the matrix for the index of the second character
					// j is the x coordinate and k is the y coordinate of the character
					for (int j = 0; j < 5; j++)
					{
						for (int k = 0; k < 5; k++)
						{
							//Breaks the loop when the character is found
							if (matrix[j][k] == input.charAt(i+1))
							{
								x2 = j;
								y2 = k;
							}
						}					
					}			
					output.append(matrix[x1][y2]);
					output.append(matrix[x2][y1]);
					//Iterating i as a pair has been found.
					i++;
				}
			
		}
		finalString = output.toString();
		return finalString;
	}
	// Checks for valid inputs and throws an exception when the input is invalid
	private void validityCheck(String keyWord,char ignore) throws Exception
	{
		// Checking the keyword is five letters long
		if (keyWord.length() != 5)
		{
			throw new Exception("Keyword is not valid");
		}		
		
		// Checking if the ignored character is a number
		if (!Character.isLetter(ignore))
		{
			throw new Exception("Your ignored character is not a letter.");
		}
		
		// Checking for the ignored character in the keyword
		for (int g = 0; g<keyWord.length(); g++)
		{
			if (keyWord.charAt(g) == ignore) 
			throw new Exception("Invalid input. The ignored character also exists in the keyword.");
		}
		
		//Checking for duplicate characters in the keyword
		for (int i = 0; i < keyWord.length(); i++)
		{
			for (int j = i+1; j < keyWord.length(); j++)
			{
				if (keyWord.charAt(i) == keyWord.charAt(j))
				throw new Exception("There are duplicate characters in the keyword.");
			}
		}

	}

	// Debug method, for when things were going wrong.
	public void debug()
	{
		System.out.println("Letters string: " + letters);
		
		System.out.print(matrix[0][0]);
		System.out.print(matrix[0][1]);
		System.out.print(matrix[0][2]);
		System.out.print(matrix[0][3]);
		System.out.println(matrix[0][4]); 
		
		System.out.print(matrix[1][0]);
		System.out.print(matrix[1][1]);
		System.out.print(matrix[1][2]);
		System.out.print(matrix[1][3]);
		System.out.println(matrix[1][4]);
		
		System.out.print(matrix[2][0]);
		System.out.print(matrix[2][1]);
		System.out.print(matrix[2][2]);
		System.out.print(matrix[2][3]);
		System.out.println(matrix[2][4]);
		
		System.out.print(matrix[3][0]);
		System.out.print(matrix[3][1]);
		System.out.print(matrix[3][2]);
		System.out.print(matrix[3][3]);
		System.out.println(matrix[3][4]);
		
		System.out.print(matrix[4][0]);
		System.out.print(matrix[4][1]);
		System.out.print(matrix[4][2]);
		System.out.print(matrix[4][3]);
		System.out.println(matrix[4][4]);
		
		System.out.println("The keyword is " + keyWord);
		System.out.println("The ignored character is " + ignore);
	}
	
}
