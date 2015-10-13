// 			    Triangle User				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This will take three user inputs and 	//
// using the TriangleTester class will 		//
// return the triangle type and print it	//
//											//

import java.util.Scanner;
public class TriangleUser
{

	public static void main(String [] args)
	
	{
	
	// declaring variables, the three sides to be taken in as ints, the scanner is instantiated and the input variable declared as an integer.
	String output;
	int side0, side1, side2;
	int input;
	Scanner in = new Scanner(System.in);
	
	try
	{
	// Hello welcome to triangle user etc
	System.out.println("Welcome to TriangleUser, this program will take three inputs and return the type of triangle you entered. Please input the first side's length. Only integer values will be accepted.");

	// First side taken in and stored
	input = in.nextInt();
	side0 = input;
	
	// Second side read
	System.out.println("Please input the second side's length.");	
	input = in.nextInt();
	side1 = input;
	
	// Third side read
	System.out.println("Please input the length of the final side.");	
	input = in.nextInt();
	side2 = input;
	
	// Calling the classify method to define the triangle, which then returns a string to be immediately printed.
	output = TriangleTester.Classify(side0, side1, side2);
	System.out.println(output);
	}
	
	// This is here here to catch any invalid inputs, strings and such.
	catch (Exception e) 
		{
		System.out.print("You have entered an undefined side length, the program will now close.");
		System.exit(0);
		}
	}
}
