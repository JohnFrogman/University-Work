import java.util.Scanner;

public class CubeUser

{
	public static void main(String [] args)
	{
		{
		
		//Opening text explaining the program and how to use it as well as known bugs.
		System.out.print("Welcome to  CubeUser, this program will  take the display  the surface area and  volume"  + "\n" +
						 "of three cubes  of side length equal to your  inputs.  Any numeric value between 0  and" 	+ "\n" +
						 "1.7*10^308 will work. Any negative numbers will be automatically corrected to positive "  + "\n" +
						 "ones. Non numeric inputs will produce errors, after which you will have to restart the "  + "\n" +
						 "program."																					+ "\n" );
		
		//Scanner for taking user input
		Scanner in = new Scanner(System.in);
		
		//Taking in user input for three cubes
		System.out.print("Please input the side length of your first cube. ");
		double input = in.nextDouble();
		Cube cube1 = new Cube(input);
		
		System.out.print("Please input the side length of your second cube. ");
		input = in.nextDouble();
		Cube cube2 = new Cube(input);
		
		System.out.print("Please input the side length of your third cube. ");
		input = in.nextDouble();
		Cube cube3 = new Cube (input);
		
		

		//Prints the volumes and surface areas of the cubes.
		System.out.print("The surface area of the first cube is " + cube1.CalculateSurfaceArea() + " and it's volume is " + cube1.CalculateVolume() + "\n");
		System.out.print("The surface area of the second cube is " + cube2.CalculateSurfaceArea() + " and it's volume is " + cube2.CalculateVolume() + "\n");
		System.out.print("The surface area of the third cube is " + cube3.CalculateSurfaceArea() + " and it's volume is " + cube3.CalculateVolume() + "\n");

		}		
	}
	
}