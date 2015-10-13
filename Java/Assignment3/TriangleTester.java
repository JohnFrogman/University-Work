// 			   Triangle Tester				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// 	This class contains a single method used//								
// 	to classify a triangle, the method is 	//								
// 	static as there is no reason to ever	//								
// 	instantiate the class, it holds no		//								
// 	variables, the spec said to instantiate	//	
// 	an object but also required a method 	//
//	with three parameters to return  		//
//	the triangle type. So it seemed very	//
//	redundant to me to make an object, only	//
// 	to pass the variables directly into the	//
// 	method. 								//
//											//
public class TriangleTester
{

//This method is static as at no point will an object of this class be instantiated. the class has no variables
public static String Classify(int side0, int side1, int side2)
{
		
		//INVALID checks if any side is zero or less, making the triangle invalid.
		if (((side0<=0)||(side1<=0))||(side2<=0))
			{
				return "Invalid input, a triangle cannot have a negative side length.";
			}
			
		//EQIULATERAL checks if the sides are equal
		else if ((side0==side1)&&(side1==side2))
			{
				return "Your triangle is equilateral.";
			}
			 
		//IMPOSSIBLE if the sum of any two sides if less than or equal to the other side the triangle is impossible.	
		else if  (((side0+side1)<=side2)||((side0+side2)<=side1)||((side1+side2)<=side0))
			{
				return "A triangle with these side lengths cannot exist.";
			}
		
		//RIGHT ANGLE
		//A right angled triangle may be scalene or isosceles however in the isosceles case it cannot take on integer values, hence after checking for right angles I have checked for only scalene instances.
		else if (((Math.pow(side0, 2)+Math.pow(side1, 2))==Math.pow(side2, 2))||((Math.pow(side1, 2)+Math.pow(side2, 2))==Math.pow(side0, 2))||((Math.pow(side2, 2)+Math.pow(side0, 2))==Math.pow(side1, 2))) 
			{	
				return "Your triangle is a right angled triangle.";			
			}
			
		//ISOSCOLESE if two sides are equal.
		else if (((side0==side1)||(side0==side2))||(side1==side2))
			{
				return "Your triangle is isosceles";
			}
			
		//SCALENE any input that gets past the other if statements has to be scalene.
		else if ((side0!=side1)&&(side1!=side2)&&(side2!=side0))
			{
				return "Your triangle is scalene";
			}
			
		//In case something goes wrong, no input should return this. 	
		else
			{
				return "Your input was not recognised";
			}
		
} 
}
