// 			   	  	  Number					//
// 				   By Alex Hayes				//
// 				University of Liverpool			//
//												//
// This class represents an integer and the 	//
// number of times it has occurred. To be used  //
// in a linked list.							//

public class Number
{
	private int value;
	private int occurences;
	
	// Sets the value in the constructor, occurences always begins at 1.
	public Number(int value)
	{
		this.value = value; 
		occurences = 1;
	}
	
	// Returns the value being stored
	public int getValue()
	{
		return value;
	}
	
	// Iterates the occurences
	public void iterateOccurences() 
	{
		occurences++;
	}
	
	// Returns the occurences variable.
	public int getOccurences()
	{
		return occurences;
	}
}
