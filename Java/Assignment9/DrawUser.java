// 			   	  	 DrawUser					//
// 				   By Alex Hayes				//
// 				University of Liverpool			//
//												//
// Processes a file called RectangleSpecs.txt	//
// Generating a .txt with a series of 		 	//
// rectangles on that correspond with the input	//
// specifications. The details of how to input 	//
// into the file can be found at the top of the //
// RectangleSpecs.txt file						//
//												//
 
import java.io.BufferedReader;
import java.io.FileReader;

public class DrawUser
{
	public static void main(String [] args) throws Exception
	{	
		// Counter to tell people where the erroneous rectangle lies.
		int rectangleNo = 0;
		
		System.out.println("Reading from RectangleSpecs.txt");
		
		// Takes in the width and height of the drawing area then instantiates the matrix that will be drawn on.
		BufferedReader inStream = new BufferedReader(new FileReader("RectangleSpecs.txt"));
		
		// Ignores all the lines that don't have a number in, allowing for documentation to be written in the .txt file.
		String line = inStream.readLine();
		while (!Character.isDigit(line.charAt(0)))
		{
			line = inStream.readLine();
		}
		
		// Reads in the height and width, throwing an error if the dimensions are invalid.
		int height = Integer.parseInt(line);  
		line = inStream.readLine();
		
		
		// Checks that the width is also valid. Height will always be an integer as the first integer the program finds 
		// becomes the height.
		try  
		{  
			int i = Integer.parseInt(line);
		}
		 catch (Exception e)
		{
			System.out.println("Your matrix has an invalid dimension.");
		}	
		
		// Checking that the height and width are positive integers.
		int width = Integer.parseInt(line);
		if ((height < 1) || (width < 1))
		{
			throw new Exception("Your matrix has an invalid dimension.");
		}
		
		// The width and the height are not the maximum values of (x,y), as the origin begins at (0,0)
		// the maximal value for (x,y) will always be (width-1,height-1).
		MatrixDrawer drawingArea = new MatrixDrawer(height, width);
		line = inStream.readLine();
		
		// Loops through the document until a negative value is found, drawing the rectangles it finds to the matrix, 
		// if a rectangle cannot be drawn a message will be displayed and the program will terminate.
		try
		{
			while(Integer.parseInt(line) >=0)
			{		
				int topLeftX = Integer.parseInt(line);  
				int topLeftY = Integer.parseInt(inStream.readLine());  
				int bottomRightX = Integer.parseInt(inStream.readLine());  
				int bottomRightY = Integer.parseInt(inStream.readLine());    
				char filler	= inStream.readLine().charAt(0);
			
				line = inStream.readLine();
				
				// The rectangle is drawn by taking the top left corner's coordinates and the bottom right corner's 
				// coordinates and a filler character then it draws that rectangle to a matrix.
				drawingArea.drawRectangle(topLeftX, topLeftY, bottomRightX, bottomRightY, filler);
				rectangleNo += 1;
			}	
		}
		catch (Exception e)
		{
			System.out.println("Rectangle " + Integer.toString(rectangleNo) + " is invalid");
		}
		
		System.out.println("Saving output as rectangles.txt");
		// Draws the rectangles to a .txt file 
		drawingArea.saveToFile(); 
		drawingArea.debug(); 
	}
}