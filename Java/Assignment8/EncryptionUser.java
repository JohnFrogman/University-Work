// 			    EncryptionUser				//
// 				By Alex Hayes				//
// 			University of Liverpool			//
//											//
// This class will take a keyword and a 	//
// character from a user and encrypt a 		//
// string that they input.					//


import java.util.Scanner;
public class EncryptionUser
{
	public static void main(String [] args) throws Exception
	{
		// Declaring the input variable and displaying the welcome message.
		String input;
		String keyword;
		char ignore;
		
		System.out.println("Welcome to EncryptionUser, this program will take a keyword and character to be ignored then encrypt a string for you.");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Taking keyword");	
		keyword = in.nextLine();

		System.out.println("Taking ignored character");	
		ignore = in.nextLine().charAt(0);
				
		System.out.println("Taking string to be encrypted.");	
		input = in.nextLine();
				
		Encryption cipher = new Encryption(keyword, ignore);
		System.out.println(cipher.encrypt(input));

		// cipher.debug();
	}
}