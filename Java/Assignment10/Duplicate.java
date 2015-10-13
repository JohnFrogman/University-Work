// 			   	  	 Duplicate					//
// 				   By Alex Hayes				//
// 				University of Liverpool			//
//												//
// This class will read in from a .txt file and	//
// return a table containing the integers that 	//
// occurred in that file and how many times 	//
// they appear. It will keep reading until a 	//
// negative number is detected.					//
//												//
// To use the program simply type: 				//
//												//
// 			java Duplicate example.txt			//
//												//
// into the command line, example.txt can be 	//
// replaced with a file of your choosing.		//
// example.txt shows how to properly format the //
// file you want to read.						//
//												//

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.*;
import java.io.File;

public class Duplicate
{
	public static void main(String [] args) throws Exception
	{	
		File file = new File(args[0]);
		if (!file.exists())
		{
			throw new Exception("File " + args[0] + " was not found");
		}
		
		BufferedReader inStream = new BufferedReader(new FileReader(args[0]));	
		String line = inStream.readLine();
		LinkedList<Number> numberList = new LinkedList<Number>(); 
		
		// Counter for the line number when throwing errors
		int lineNumber = 1;
		
		
		// Adds all the integers to the list in their correct location, iterating the occurrences variable in the Number object
		// instead when the number is already in the list. Stops searching either on reaching a negative integer or an invalid
		// character.
		boolean occurs = false;
		int number = Integer.parseInt(line);
		
		// If the first value in the file is less than zero this stops it from being added to the list.
		if (number >= 0)		
		{
			numberList.addFirst(new Number(number));
		}
		
		while(number >= 0)
		{	
			lineNumber++;
			line = inStream.readLine();	
			
			// Attempts to parse an integer from the file, if an integer cannot be parsed the program stops working.
			try
			{	
				number = Integer.parseInt(line);
			}
				catch (Exception e)
			{
				System.out.println("There was an error in line " + Integer.toString(lineNumber) + " of " + args[0] + ". Printing table up to that point.");
				break;
			}
			
			// Checks for duplicates and iterates occurrences when they're detected.
			for (int i = 0; i < numberList.size(); i++)
			{
				if (numberList.get(i).getValue() == number)
				{
					numberList.get(i).iterateOccurences();
					occurs = true;
					break;
				}	
			}
			// Adds to the list in the correct location if the number isn't already on it.
			if (!occurs && number >= 0)
			{	
				if (number > numberList.getLast().getValue())
				{
					numberList.addLast(new Number(number));
				}	
				else 
				{	
					for (int i = 0; i < numberList.size(); i++)
					{	
						if (number < numberList.get(i).getValue())
						{
							numberList.add(i, new Number(number));
							break;
						}
					}
				}
			}
			else
			{
				occurs = false;
			}
		}
		
		// Prints a table of each value and the number of times it occurs in the .txt file.
		System.out.println("VALUE 	OCCURENCES");
		System.out.println("----- 	----------");
		
		for (int i = 0; i < numberList.size(); i++)
		{
			System.out.println(numberList.get(i).getValue() +  "	" + numberList.get(i).getOccurences());
		}

	}
}