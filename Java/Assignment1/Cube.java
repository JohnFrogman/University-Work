
public class Cube 

{
	 private double l; //length of the cube's side
		
	//Constructor method, takes absolute values to avoid odd behaviour with negative numbers.
	public Cube(double sideLength)
	{
		l = Math.abs(sideLength);
	}
	 
	//This method calculates surface area and returns it as a double.
	public double CalculateSurfaceArea()
	{
	double sideArea = Math.pow(l, 2);
	return 6*sideArea ;
	}
	
	//Calculates & returns the volumes of the cube
	public double CalculateVolume()
	{
		return Math.pow(l, 3);
	}
	
}