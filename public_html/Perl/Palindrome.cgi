#!/usr/bin/perl -w
print "Content-type:text/html\r\n\r\n";
use CGI qw(param); 
$s = param("PalindromeCheck");

print<<head; 
<head>
<link rel="stylesheet" type="text/css" href="http://cgi.csc.liv.ac.uk/~m4ah/StyleSheet.css">
<meta charset= "UTF-8">
<meta name="Author" content="Alexander Hayes">
<meta name="keywords" content="University of Liverpool, comp519, web development">
<title>Perl stuff</title>
</head>
<br>
head

@strings = split (/::/, $s);  					# Splits the string into individual sentences to be checked

for  (my $i= 0; $i<@strings; $i++)				# Iterates through each string in the array
	{
		print "$strings[$i]\n";					# Prints the user's input 
		print "<br>";							
		$value = $strings[$i];					# Takes the palindrome to be checked from the array
		$value =~ s/[^\w]//g;					# Removes non-alphanumeric characters and whitespace.
		$value = uc $value;						# To upper case		
			
		if($value eq "")						# If the string is just punctuation is cannot be a palindrome
		{
			print "Your input was not a palindrome \n";
		}
		
		elsif ($value eq reverse $value)		# If it is a palindrome then it will be the same reversed and so the function will return true.
		{
			print "Your input was a palindrome \n";
		}
	
		else 									# When it's none of the above it's not a palindrome.
		{
			print "Your input was not a palindrome \n";
		}
		print "<br>";
	}
